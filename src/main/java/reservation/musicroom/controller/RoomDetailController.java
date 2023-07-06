package reservation.musicroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;
import reservation.musicroom.service.RoomDetailService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roomDetail")
public class RoomDetailController {

    private final RoomDetailService roomDetailService;

    @PostMapping("/findRoom")
    public ResponseEntity<List<RoomDetailResponseDto>> findRoom(@RequestBody RoomDetailRequestDto roomDetailRequestDto) {
        return ResponseEntity.ok(roomDetailService.findRoom(roomDetailRequestDto));
    }
}
