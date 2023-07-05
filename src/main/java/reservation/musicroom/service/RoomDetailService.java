package reservation.musicroom.service;

import org.springframework.stereotype.Service;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;

public interface RoomDetailService {

    int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto);
}
