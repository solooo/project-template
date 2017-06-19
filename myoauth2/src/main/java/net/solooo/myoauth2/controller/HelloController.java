package net.solooo.myoauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:Eric
 * Date:2017/6/16
 */
@RestController
@RequestMapping(value = "/hello", produces = { "application/json;charset=UTF-8" })
public class HelloController {

    @GetMapping("")
    public String hello(String name) {
        return "hello " + name;
    }
}
