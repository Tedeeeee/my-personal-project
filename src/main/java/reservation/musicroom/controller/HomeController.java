package reservation.musicroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index() {
        return "home";
    }
    @GetMapping("/studioPage")
    public String studio() {
        return "fragment/studioList";
    }

}
