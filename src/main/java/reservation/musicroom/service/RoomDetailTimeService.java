package reservation.musicroom.service;

import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;

public interface RoomDetailTimeService {
    int findRoomDetailTime(RoomDetailTimeRequestDto roomDetailTimeRequestDto);
}
