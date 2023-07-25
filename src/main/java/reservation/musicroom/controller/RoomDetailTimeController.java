package reservation.musicroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;
import reservation.musicroom.service.RoomDetailTimeService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roomDetailTime")
public class RoomDetailTimeController {

    private final RoomDetailTimeService roomDetailTimeService;

    // 월 단위의 예약 상황을 보여주는 컨트롤
    @PostMapping("/findRoomTimeMonth")
    public ResponseEntity<Map<Long, String>> findRoomTimeMonth(@RequestBody RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        return ResponseEntity.ok(roomDetailTimeService.findRoomDetailTimeByMonth(roomDetailTimeRequestDto));
    }

    @PostMapping("/findRoomTimeDay")
    public ResponseEntity<Map<Long, String>> findRoomTimeDay(@RequestBody RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        return ResponseEntity.ok(roomDetailTimeService.findRoomDetailTimeByDay(roomDetailTimeRequestDto));
    }

    // 예약하기
    @PostMapping("/reservationRoom")
    public ResponseEntity<Integer> reservationRoom(@RequestBody RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        return ResponseEntity.ok(roomDetailTimeService.reservationRoom(roomDetailTimeRequestDto));
    }
}
