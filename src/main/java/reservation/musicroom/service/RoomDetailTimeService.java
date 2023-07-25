package reservation.musicroom.service;

import reservation.musicroom.domain.Entity.RoomDetailTime;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;

import java.util.List;
import java.util.Map;

public interface RoomDetailTimeService {
    Map<Long, String> findRoomDetailTimeByMonth(RoomDetailTimeRequestDto roomDetailTimeRequestDto);
    Map<Long, String> findRoomDetailTimeByDay(RoomDetailTimeRequestDto roomDetailTimeRequestDto);

    int reservationRoom(RoomDetailTimeRequestDto roomDetailTimeRequestDto);
}
