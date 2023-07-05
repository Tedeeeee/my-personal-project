package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.Entity.Room;
import reservation.musicroom.domain.dto.room.RoomRequestDto;
import reservation.musicroom.mapper.RoomMapper;
import reservation.musicroom.service.RoomService;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomMapper roomMapper;

    @Override
    public int createRoom(RoomRequestDto roomRequestDto) {
        // 예외처리 : 주소를 기반으로 이미 저장되어있는 주소의 가게라면 예외처리

        Room room = roomRequestDto.toRoom(roomRequestDto);
        return roomMapper.createRoom(room);
    }
}
