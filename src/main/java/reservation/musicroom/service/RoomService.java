package reservation.musicroom.service;

import reservation.musicroom.domain.dto.room.RoomRequestDto;

public interface RoomService {
    int createRoom(RoomRequestDto roomRequestDto);
}
