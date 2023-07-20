package reservation.musicroom.service;

import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;

import java.util.List;

public interface RoomDetailTimeService {
    List<String> findRoomDetailTimeByMonth(RoomDetailTimeRequestDto roomDetailTimeRequestDto);

    List<String> findRoomDetailTimeByDay(RoomDetailTimeRequestDto roomDetailTimeRequestDto);
}
