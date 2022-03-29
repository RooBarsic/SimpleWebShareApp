package com.company.servingwebcontent.controller;

import org.jetbrains.annotations.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloRequestHandler(@RequestParam(name= "name", required = false) @Nullable String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Got GET /hello request");
            return "Salam my friend";
        }
        else {
            System.out.println("Got GET /hello request with name = " + name);
            return "Salam my friend, " + name;
        }
    }

}
