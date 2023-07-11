package reservation.musicroom.service;

import reservation.musicroom.domain.dto.room.RoomRequestDto;
import reservation.musicroom.domain.dto.room.RoomResponseDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;

import java.util.*;

public interface RoomService {
    int createRoom(RoomRequestDto roomRequestDto);
    List<RoomResponseDto> getAllRoomByMemberId(String memberEmail);
    RoomResponseDto getMyRoomByRoomName(RoomRequestDto requestDto);
    RoomResponseDto ownerRoomDetail(RoomRequestDto roomRequestDto);

}
