package almaz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {


    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first1/goodbye";
    }

    @GetMapping("/hello")
    public String hello() {
        return "first1/hello";
    }
}
