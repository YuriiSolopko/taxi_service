package com.ua.taxi.controller;

import com.ua.taxi.domain.Operator;
import com.ua.taxi.domain.Region;
import com.ua.taxi.service.RegionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jura on 17.05.2015.
 */
@Controller
@SessionAttributes("operator")
public class RegionController {

    public static final Logger log = Logger.getLogger(RegionController.class);

    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/getRegions", method = RequestMethod.GET)
    public @ResponseBody List<Region> getRegions(@ModelAttribute Operator operator) {
        log.info("/getRegions controller");
        return operator.getOperatorId() == null ? null : regionService.getRegions();
    }

    @RequestMapping(value = "/addRegion", method = RequestMethod.GET)
    public @ResponseBody boolean addRegion(@ModelAttribute Operator operator, @RequestParam String regionName) {
        log.info("/addRegion controller");
        return regionService.addRegion(regionName);
    }

    @RequestMapping(value = "/editRegion", method = RequestMethod.GET)
    public @ResponseBody String editRegion(@ModelAttribute Operator operator, @RequestParam String regionName, @RequestParam String regionId) {
        log.info("/editRegion controller");
        return regionService.editRegion(regionName, regionId) ? "true":"false";
    }

}
