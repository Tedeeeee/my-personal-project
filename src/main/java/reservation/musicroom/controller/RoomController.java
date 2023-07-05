package reservation.musicroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservation.musicroom.domain.dto.room.RoomRequestDto;
import reservation.musicroom.service.RoomService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @PostMapping("/createRoom")
    public ResponseEntity<Integer> createRoom(@RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.createRoom(roomRequestDto));
    }
}
