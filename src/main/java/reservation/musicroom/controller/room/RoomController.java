package reservation.musicroom.controller.room;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {

    @PostMapping("/makeRoom")
    public String makeRoom() {

        return "myProfile";
    }

}
