package reservation.musicroom.service;

import reservation.musicroom.domain.dto.room.RoomRequestDto;
import reservation.musicroom.domain.dto.room.RoomResponseDto;

import java.util.*;

public interface RoomService {
    int createRoom(RoomRequestDto roomRequestDto);
    List<RoomResponseDto> getAllRoomByMemberId(String memberEmail);
    RoomResponseDto getMyRoomByRoomName(RoomRequestDto requestDto);
}
