package almaz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {


    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first1/goodbye";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname,
                        Model model) {
        model.addAttribute("message", "hello, " + name + " " + surname);
        return "first1/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action,
                             Model model
    ) {
        double result = 0;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
        }
        model.addAttribute("result",result);
        return "first1/calculator";
    }
}
