package com.wkl.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping(value = {"/hello"})
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Autowired
    private GirlProp girlProp;

    @RequestMapping(value = {"/hi", "/say"},method = RequestMethod.GET)
    public String say() {
        return  girlProp.getName();
    }

    @RequestMapping(value = {"/sayPost"},method = RequestMethod.POST)
    public String sayPost() {
        return  "大小是：" + girlProp.getCupSize();
    }

    // 模板方式
    @RequestMapping(value = "/helloTmp", method = RequestMethod.GET)
    public String sayTmp() {
        return  "index";
    }
}
