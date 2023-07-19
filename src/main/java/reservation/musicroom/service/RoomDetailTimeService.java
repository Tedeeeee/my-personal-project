package reservation.musicroom.service;

import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;

import java.util.List;

public interface RoomDetailTimeService {
    List<String> findRoomDetailTime(RoomDetailTimeRequestDto roomDetailTimeRequestDto);
}
