package com.github.leegphillips.BDDSpringBootCucumber;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    @RequestMapping("/version")
    public String getVersion() {
        return "1.0";
    }
}
