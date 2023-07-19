package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeDto;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;
import reservation.musicroom.mapper.RoomDetailMapper;
import reservation.musicroom.mapper.RoomDetailTimeMapper;
import reservation.musicroom.service.RoomDetailTimeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomDetailTimeServiceImpl implements RoomDetailTimeService {

    private final RoomDetailMapper roomDetailMapper;
    private final RoomDetailTimeMapper roomDetailTimeMapper;

    @Override
    public List<String> findRoomDetailTime(RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        List<Long> roomDetailByLocation = roomDetailMapper.findRoomDetailByLocation(roomDetailTimeRequestDto.getRoomLocation());

        LocalDate startWantDay = LocalDate.parse(roomDetailTimeRequestDto.getStartDay());
        int monthsToAdd = Integer.parseInt(roomDetailTimeRequestDto.getUseMonth());
        LocalDate endWantDay = startWantDay.plusMonths(monthsToAdd);

        List<String> usableRoom = new ArrayList<>();
        for (Long value : roomDetailByLocation) {
            List<RoomDetailTimeDto> roomDetailTime = roomDetailTimeMapper.findRoomDetailTime(value);

            for (RoomDetailTimeDto roomDetailTimeDto : roomDetailTime) {
                String startDay = roomDetailTimeDto.getRoomDetailTimeStartDay();
                String endDay = roomDetailTimeDto.getRoomDetailTimeEndDay();

                LocalDate start = LocalDate.parse(startDay);
                LocalDate end = LocalDate.parse(endDay);

                if (endWantDay.isAfter(start) && endWantDay.isBefore(end)) {
                    // 예외처리
                    System.out.println("마지막 날짜가 걸림");
                } else if (startWantDay.isAfter(start) && startWantDay.isBefore(end)) {
                    // 예외처리
                    System.out.println("시작 날짜가 걸림");
                } else if (startWantDay.isAfter(start) && endWantDay.isBefore(end)){
                    // 예외처리
                    System.out.println("사용하고 있는 사이 기간임");
                } else if (startWantDay.isBefore(start) && endWantDay.isAfter(end)) {
                    // 예외처리
                    System.out.println("원하는 시간에 이미 예약되어있는 날짜가 있음");
                } else {
                    String name = roomDetailTimeDto.getRoomDetailName();
                    usableRoom.add(name);
                    System.out.println(name);
                }
            }
        }
        return usableRoom;
    }
}
