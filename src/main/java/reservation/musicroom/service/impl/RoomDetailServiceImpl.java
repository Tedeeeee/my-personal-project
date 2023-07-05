package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.service.RoomDetailService;

@Service
@RequiredArgsConstructor
public class RoomDetailServiceImpl implements RoomDetailService {
    @Override
    public int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto) {
        return 0;
    }
}
