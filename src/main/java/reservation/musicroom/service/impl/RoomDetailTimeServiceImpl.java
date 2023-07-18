package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeDto;
import reservation.musicroom.domain.dto.roomdetailTime.RoomDetailTimeRequestDto;
import reservation.musicroom.mapper.RoomDetailMapper;
import reservation.musicroom.mapper.RoomDetailTimeMapper;
import reservation.musicroom.service.RoomDetailTimeService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoomDetailTimeServiceImpl implements RoomDetailTimeService {

    private final RoomDetailMapper roomDetailMapper;
    private final RoomDetailTimeMapper roomDetailTimeMapper;

    @Override
    public int findRoomDetailTime(RoomDetailTimeRequestDto roomDetailTimeRequestDto) {
        List<Long> roomDetailByLocation = roomDetailMapper.findRoomDetailByLocation(roomDetailTimeRequestDto.getRoomLocation());

        for (Long value : roomDetailByLocation) {
            List<RoomDetailTimeDto> roomDetailTime = roomDetailTimeMapper.findRoomDetailTime(value);

            System.out.println("roomDetailTime = " + roomDetailTime);
        }
        return 0;
    }
}
