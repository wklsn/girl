package com.wkl.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.websocket.server.PathParam;


@Controller
@ResponseBody
@RequestMapping(value = {"/hello"})
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Autowired
    private GirlProp girlProp;

    // 第一个方法
    @RequestMapping(value = {"/hi", "/say"},method = RequestMethod.GET)
        public String say() {
        return  girlProp.getName();
    }

    // 获取path参数 http://127.0.0.1:8080/hello/sayVar/23
    @RequestMapping(value = {"/sayVar/{id}"},method = RequestMethod.GET)
    public String sayVar(@PathVariable("id") int id) {
        return "id: ".concat(String.valueOf(id));
    }

    // 获取param参数 http://127.0.0.1:8080/hello/sayParam?myId=100
    @RequestMapping(value = {"/sayParam"},method = RequestMethod.GET)
    public String sayParam(@PathParam("myId") String myId) {
        return "myId: ".concat(myId);
    }

    // 获取参数 http://127.0.0.1:8080/hello/sayReq
    @GetMapping(value = {"/sayReq"})
    public String sayReq(@RequestParam(value = "id", required = true, defaultValue = "0") String id) {
        return "id: ".concat(id);
    }

    // post方式提交
    @RequestMapping(value = {"/sayPost"},method = RequestMethod.POST)
    public String sayPost() {
        return  "大小是：" + girlProp.getCupSize();
    }

    // 使用模板方式
    @RequestMapping(value = "/helloTmp", method = RequestMethod.GET)
    public String sayTmp() {
        return  "index";
    }
}
