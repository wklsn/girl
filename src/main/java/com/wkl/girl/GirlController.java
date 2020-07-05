package com.wkl.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.ga.TimeZoneNames_ga;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("girl")
public class GirlController {

    @Autowired
    private GirlRepository girlResp;

    @Autowired
    private GirlService girlService;

    // 查询所有数据
    @GetMapping("/listGirls")
    public List<Girl> listGirls() {
        return girlResp.findAll();
    }

    // 新增1条
    @PostMapping("/addGirl")
    public String addGirl(@RequestParam("cupSize") String cupSize, @RequestParam("age")Integer age) {
        Girl g = girlResp.save(new Girl(cupSize, age));
        return  "增加"+g.getId()+"成功!";
    }

    // 新增多条
    @GetMapping("/addGirls")
    public String addGirls() {
        Girl girl1 = new Girl("S", 45);
        Girl girl2 = new Girl("C", 14);
        Girl girl3 = new Girl("E", 32);
        List<Girl> girls = new ArrayList<>();
        girls.add(girl1);
        girls.add(girl2);
        girls.add(girl3);
        girlResp.saveAll(girls);
        return "增加Girls成功!";
    }

    // 新增多条 事务
    @GetMapping("/addGirlsTran")
    public String addGirlsTran() {
        girlService.insertTwo();
        return "增加Girls事务成功!";
    }

    @GetMapping("/delGirl")
    public String delGirl(@RequestParam("id") Integer id) {
        girlResp.deleteById(id);
        return "删除成功!";
    }

    // 删除全部
    @GetMapping("/delGirls")
    public String delGirls() {
        girlResp.deleteAll();
        return "全部删除成功!";
    }

    // 更新
    @PostMapping("/updateGirl")
    public String updateGirl(@RequestParam("id") Integer id, @RequestParam("cupSize") String cupSize) {
        Optional<Girl> girlOptional = girlResp.findById(id);
        Girl girl = girlOptional.get();
        String origin = girl.getCupSize();
        girl.setCupSize(cupSize);
        girlResp.save(girl);
        return "CupSize由：" + origin +"，修改为： " + girl.getCupSize();
    }


    // 新增check
    @GetMapping("/addGirlValid")
    public String addGirlValid(@Valid Girl girl, BindingResult result) {
        if (result.hasErrors()) {
           return result.getFieldError().getDefaultMessage();
        }
        girlResp.save(girl);
        return girl.toString();
    }
}
