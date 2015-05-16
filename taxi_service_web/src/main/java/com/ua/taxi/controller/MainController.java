package com.ua.taxi.controller;

import com.ua.taxi.domain.Operator;
import com.ua.taxi.service.OperatorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by White Queen on 10.05.2015.
 */
@Controller
@SessionAttributes("operator")
public class MainController {

    public static final Logger log = Logger.getLogger(MainController.class);

    @Autowired
    private OperatorService operatorService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index() {
        log.info("/index.html controller");
        return "index";
    }

    @RequestMapping(value = "/operatorLoginCheck", method = RequestMethod.GET)
    public @ResponseBody boolean operatorLoginCheck(@RequestParam String login) {
        log.info("/operatorLoginCheck controller");
        return operatorService.operatorLoginCheck(login);
    }

    @RequestMapping(value = "/registerOperator", method = RequestMethod.POST)
    public @ResponseBody boolean registerOperator(@RequestParam String login, @RequestParam String password) {
        log.info("/registerOperator controller");
        return operatorService.registerOperator(login, password);
    }

    @RequestMapping(value = "/authOperator", method = RequestMethod.POST)
    public @ResponseBody String authOperator(@RequestParam String login, @RequestParam String password, Model model) {
        log.info("/authOperator controller");
        if(operatorService.authenticate(login, password)) {
            if(operatorService.isExpiredPass(login)) {
                return "newpass";
            } else {
                model.addAttribute("operator", operatorService.readByLogin(login));
                return "dashboard";
            }
        }
        return "index";
    }

    @RequestMapping(value = "/dashboard.html", method = RequestMethod.GET)
    public String dashboard(@ModelAttribute Operator operator) {
        log.info("/dashboard.html controller");
        return "dashboard";
    }
}
