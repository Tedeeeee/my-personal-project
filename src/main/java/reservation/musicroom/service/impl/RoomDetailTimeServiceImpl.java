package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeDto;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;
import reservation.musicroom.mapper.RoomDetailMapper;
import reservation.musicroom.mapper.RoomDetailTimeMapper;
import reservation.musicroom.service.RoomDetailTimeService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomDetailTimeServiceImpl implements RoomDetailTimeService {

    private final RoomDetailMapper roomDetailMapper;
    private final RoomDetailTimeMapper roomDetailTimeMapper;

    @Override
    public List<String> findRoomDetailTimeByMonth(RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        List<Long> roomDetailByLocation = roomDetailMapper.findRoomDetailByLocation(roomDetailTimeRequestDto.getRoomLocation());
        List<String> usableRoom = new ArrayList<>();

        LocalDate startWantDay = LocalDate.parse(roomDetailTimeRequestDto.getStartDay());
        int monthsToAdd = Integer.parseInt(roomDetailTimeRequestDto.getUseMonth());
        LocalDate endWantDay = startWantDay.plusMonths(monthsToAdd);

        for (Long value : roomDetailByLocation) {
            List<RoomDetailTimeDto> roomDetailTimeByMonth = roomDetailTimeMapper.findRoomDetailTime(value);

            for (RoomDetailTimeDto timeMonth : roomDetailTimeByMonth) {
                String startDay = timeMonth.getRoomDetailTimeStartDay();
                String endDay = timeMonth.getRoomDetailTimeEndDay();
                LocalDate start = LocalDate.parse(startDay);

                if (endDay == null) {
                    System.out.println("비교할 필요 없음");
                    continue;
                }
                LocalDate end = LocalDate.parse(endDay);

                if (endWantDay.isAfter(start) && endWantDay.isBefore(end)) {
                    System.out.println("마지막 날짜가 걸림");
                } else if (startWantDay.isAfter(start) && startWantDay.isBefore(end)) {
                    System.out.println("시작 날짜가 걸림");
                } else if (startWantDay.isAfter(start) && endWantDay.isBefore(end)){
                    System.out.println("사용하고 있는 사이 기간임");
                } else if (startWantDay.isBefore(start) && endWantDay.isAfter(end)) {
                    System.out.println("원하는 시간에 이미 예약되어있는 날짜가 있음");
                } else {
                    String name = timeMonth.getRoomDetailName();
                    usableRoom.add(name);
                }
            }
        }
        return usableRoom;
    }

    @Override
    public List<String> findRoomDetailTimeByDay(RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        List<Long> roomDetailByLocation = roomDetailMapper.findRoomDetailByLocation(roomDetailTimeRequestDto.getRoomLocation());
        String startWantDay = roomDetailTimeRequestDto.getStartDay();

        LocalTime startWantTime = LocalTime.parse(roomDetailTimeRequestDto.getStartTime());
        LocalTime endWantTime = LocalTime.parse(roomDetailTimeRequestDto.getEndTime());

        List<String> usableRoom = new ArrayList<>();

        for (Long value : roomDetailByLocation) {
            List<RoomDetailTimeDto> roomDetailTimeByDay = roomDetailTimeMapper.findRoomDetailTime(value);

            for (RoomDetailTimeDto timeDay : roomDetailTimeByDay) {
                LocalTime startTime = timeDay.getRoomDetailTimeStartTime() != null ? LocalTime.parse(timeDay.getRoomDetailTimeStartTime()) : null;
                LocalTime endTime = timeDay.getRoomDetailTimeEndTime() != null ? LocalTime.parse(timeDay.getRoomDetailTimeEndTime()) : null;

                if (startTime == null || endTime == null) {
                    System.out.println("달단위로 예약한 사람");
                } else if (!timeDay.getRoomDetailTimeStartDay().equals(startWantDay)) {
                    System.out.println("날짜가 달라서 괜찮아");
                } else if (startWantTime.equals(startTime) || endWantTime.equals(endTime)) {
                    System.out.println("시작 시간 혹은 종료 시간이 겹침");
                } else if (endWantTime.isAfter(startTime) && endWantTime.isBefore(endTime)) {
                    System.out.println("마지막 시간이 걸림");
                } else if (startWantTime.isAfter(startTime) && startWantTime.isBefore(endTime)) {
                    System.out.println("시작 시간이 걸림");
                } else if (startWantTime.isBefore(startTime) && endWantTime.isAfter(endTime)) {
                    System.out.println("이 시간은 기존에 있는 예약이랑 겹침");
                } else if (startWantTime.isAfter(startTime) && endWantTime.isBefore(endTime)) {
                    System.out.println("해당 시간 사이에 에약한 사람이 있음");
                } else {
                    String name = timeDay.getRoomDetailName();
                    usableRoom.add(name);
                }
            }
        }
        return usableRoom;
    }
}
