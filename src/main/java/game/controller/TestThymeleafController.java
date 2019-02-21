package game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestThymeleafController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("ms", "hi hi hi");
        return "homeView";
    }
    @GetMapping("/")
    public String index () {
        return "indexView";
    }
}
