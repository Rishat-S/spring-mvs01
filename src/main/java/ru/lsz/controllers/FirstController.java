package ru.lsz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("massage", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodBay() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Integer a,
                             @RequestParam(value = "b", required = false) Integer b,
                             @RequestParam(value = "action", required = false) String action,
                             Model model) {

        switch (action) {
            case "multiplication": {
                model.addAttribute("massage", a * b);
                break;
            }
            case "addition": {
                model.addAttribute("massage",a + b);
                break;
            }
            case "subtraction": {
                model.addAttribute("massage",a % b);
                break;
            }
            case "division": {
                model.addAttribute("massage",a / b);
                break;
            }
        }

        return "first/calculator";
    }
}
