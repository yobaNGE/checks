package org.chiches.checks;

import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {
    private final ServiceMain serviceMain;

    public RestControl(ServiceMain serviceMain) {
        this.serviceMain = serviceMain;
    }
    @GetMapping("/getBools")
    public boolean[] setBool() {
        return serviceMain.getBools();
    }
    @GetMapping("/getTwoDimBools")
    public boolean[][] getTwoDimBools() {
        return serviceMain.getTwoDimBools();
    }
}
