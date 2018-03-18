package gof.knowledgemirror.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hey {
    @RequestMapping("/sayhey")
    public String dosay() {
        return "hey";
    }
}
