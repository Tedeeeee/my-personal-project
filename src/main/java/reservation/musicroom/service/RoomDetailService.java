package reservation.musicroom.service;

import org.springframework.stereotype.Service;
import reservation.musicroom.domain.dto.room.RoomResponseDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;

import java.util.List;

public interface RoomDetailService {

    int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto);

    List<RoomDetailResponseDto> findRoom(RoomDetailRequestDto roomDetailRequestDto);
}
