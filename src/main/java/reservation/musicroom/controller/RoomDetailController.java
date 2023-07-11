package reservation.musicroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservation.musicroom.domain.dto.roomDetail.ChangeRoomDetailDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;
import reservation.musicroom.service.RoomDetailService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roomDetail")
public class RoomDetailController {

    private final RoomDetailService roomDetailService;

    // 비록 이름만 생성하는 곳이지만 연습실 위치와 층을 기반으로 이름을 생성
    @PostMapping("/registerRoomName")
    public ResponseEntity<Integer> registerRoomDetail(@RequestBody RoomDetailRequestDto roomDetailRequestDto) {
        System.out.println("roomDetailRequestDto.toString() = " + roomDetailRequestDto.toString());
        return ResponseEntity.ok(roomDetailService.registerRoomDetail(roomDetailRequestDto));
    }

    //해당 층의 모든 개인 연습실 가져오기
    @PostMapping("/findRoom")
    public ResponseEntity<List<RoomDetailResponseDto>> findRoom(@RequestBody RoomDetailRequestDto roomDetailRequestDto) {
        return ResponseEntity.ok(roomDetailService.findRoom(roomDetailRequestDto));
    }

    // 개인 연습실 상세 정보 가져오기
    @PostMapping("/findDetailRoomName")
    public ResponseEntity<RoomDetailResponseDto> findDetailRoomName(@RequestBody RoomDetailRequestDto roomDetailRequestDto) {
        return ResponseEntity.ok(roomDetailService.findRoomNameByRoomNum(roomDetailRequestDto));
    }

    // 개인 연습실 옵션 변경
    @PostMapping("/optionChange")
    public ResponseEntity<Integer> roomDetailOptionChange(@RequestBody RoomDetailRequestDto roomDetailRequestDto) {
        return ResponseEntity.ok(roomDetailService.roomDetailOptionChange(roomDetailRequestDto));
    }

    // 개인 연습실 이름 변경
    @PostMapping("/changeRoomDetailName")
    public ResponseEntity<Integer> roomDetailNameChange(@RequestBody ChangeRoomDetailDto changeRoomDetailDto) {
        return ResponseEntity.ok(roomDetailService.roomDetailNameChange(changeRoomDetailDto));
    }

    // 개인 연습실 평수 변경
    @PostMapping("/changeRoomDetailSize")
    public ResponseEntity<Integer> roomDetailSizeChange(@RequestBody ChangeRoomDetailDto changeRoomDetailDto) {
        return ResponseEntity.ok(roomDetailService.roomDetailSizeChange(changeRoomDetailDto));
    }

    // 개인 연습실 시간당 가격
    @PostMapping("/changeRoomDetailTimePrice")
    public ResponseEntity<Integer> roomDetailTimePriceChange(@RequestBody ChangeRoomDetailDto changeRoomDetailDto) {
        return ResponseEntity.ok(roomDetailService.roomDetailTimePriceChange(changeRoomDetailDto));
    }

    // 개인 연습실 월별 가격
    @PostMapping("/changeRoomDetailMonthPrice")
    public ResponseEntity<Integer> roomDetailMonthPriceChange(@RequestBody ChangeRoomDetailDto changeRoomDetailDto) {
        return ResponseEntity.ok(roomDetailService.roomDetailMonthPriceChange(changeRoomDetailDto));
    }


}
