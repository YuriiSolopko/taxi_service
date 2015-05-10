package com.ua.taxi.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by White Queen on 10.05.2015.
 */
@Controller
public class MainController {

    public static final Logger log = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String registration() {
        log.info("/index.html controller");
        return "index";
    }
}
