package reservation.musicroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservation.musicroom.domain.dto.room.RoomRequestDto;
import reservation.musicroom.domain.dto.room.RoomResponseDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;
import reservation.musicroom.mapper.RoomMapper;
import reservation.musicroom.service.RoomService;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @PostMapping("/createRoom")
    public ResponseEntity<Integer> createRoom(@RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.createRoom(roomRequestDto));
    }

    // 모든 룸을 가져오는 로직
    @GetMapping("/allRoom")
    public ResponseEntity<List<RoomResponseDto>> AllRoom(@RequestParam String memberEmail) {
        List<RoomResponseDto> rooms = roomService.getAllRoomByMemberId(memberEmail);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/findAllRoom")
    public ResponseEntity<List<RoomResponseDto>> findAllRoom() {
        return ResponseEntity.ok(roomMapper.findAllRoom());
    }

    // 룸 이름을 가지고 가져오는 데이터
    @PostMapping ("/myRoom")
    public ResponseEntity<RoomResponseDto> myRoom(@RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.getMyRoomByRoomName(roomRequestDto));
    }
}
