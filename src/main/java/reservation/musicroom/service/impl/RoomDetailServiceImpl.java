package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.dto.room.RoomResponseDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;
import reservation.musicroom.mapper.RoomDetailMapper;
import reservation.musicroom.service.RoomDetailService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomDetailServiceImpl implements RoomDetailService {

    private final RoomDetailMapper roomDetailMapper;
    @Override
    public int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto) {
        return 0;
    }

    @Override
    public List<RoomDetailResponseDto> findRoom(RoomDetailRequestDto roomDetailRequestDto) {
        return roomDetailMapper.findRoomDetail(roomDetailRequestDto.getRoomName(), roomDetailRequestDto.getRoomFloor());
    }
}
