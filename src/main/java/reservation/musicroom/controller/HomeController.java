package reservation.musicroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index() {
        return "home";
    }

    @GetMapping("/studioList")
    public String studioList() {
        return "fragment/studioList";
    }

    @GetMapping("/studioPage")
    public String studioPage() {
        return "fragment/studioPage";
    }

    @GetMapping("/makeRoomPage")
    public String roomWritePage() {
        return "fragment/makeRoomPage";
    }

    @GetMapping("/myProfilePage")
    public String myProfilePage() {
        return "profile/myProfile";
    }

    @GetMapping("/myRoomPage")
    public String myRoomPage() {
        return "profile/myRoom";
    }
}
