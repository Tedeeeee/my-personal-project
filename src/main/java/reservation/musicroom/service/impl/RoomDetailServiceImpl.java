package reservation.musicroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reservation.musicroom.domain.Entity.RoomDetail;
import reservation.musicroom.domain.dto.roomDetail.ChangeRoomDetailDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;
import reservation.musicroom.mapper.RoomDetailMapper;
import reservation.musicroom.service.RoomDetailService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomDetailServiceImpl implements RoomDetailService {

    private final RoomDetailMapper roomDetailMapper;

    // 방 저장하기
    @Override
    public int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto) {
        roomDetailRequestDto.setRoomDetailState("Y");
        RoomDetail roomDetail = roomDetailRequestDto.toRoomDetail(roomDetailRequestDto);
        return roomDetailMapper.registerRoomDetail(roomDetail);
    }

    // 위치와 층을 기반한 연습실가져오기
    @Override
    public List<RoomDetailResponseDto> findRoom(RoomDetailRequestDto roomDetailRequestDto) {
        return roomDetailMapper.findRoomDetail(roomDetailRequestDto.getRoomLocation(), roomDetailRequestDto.getRoomFloor());
    }


    @Override
    public RoomDetailResponseDto findRoomNameByRoomNum(RoomDetailRequestDto roomDetailRequestDto) {
        return roomDetailMapper.findRoomDetailByRoomNum(roomDetailRequestDto.getRoomDetailName(), roomDetailRequestDto.getRoomLocation());
    }

    @Override
    public RoomDetailResponseDto ownerRoomDetail(String roomLocation, String memberEmail) {
        return roomDetailMapper.ownerRoomDetail(roomLocation, memberEmail);
    }

    // 옵션바꾸기
    @Override
    public int roomDetailOptionChange(RoomDetailRequestDto roomDetailRequestDto) {
        String roomDetailName = roomDetailRequestDto.getRoomDetailName();
        // 룸의 전체적인 정보를 가져와서 이름을 비교해서 있다면 예외처리

        roomDetailRequestDto.setRoomDetailName(roomDetailName);
        RoomDetail roomDetail = roomDetailRequestDto.toRoomDetail(roomDetailRequestDto);
        return roomDetailMapper.optionChange(roomDetail.getRoomDetailName(), roomDetail.getRoomLocation(), roomDetail.getRoomDetailFacilities());
    }

    @Override
    public int roomDetailNameChange(ChangeRoomDetailDto changeRoomDetailDto) {
        return roomDetailMapper.nameChange(changeRoomDetailDto.getExRoomDetailName(), changeRoomDetailDto.getRoomLocation(), changeRoomDetailDto.getNewRoomDetailName());
    }

    @Override
    public int roomDetailSizeChange(ChangeRoomDetailDto changeRoomDetailDto) {
        return roomDetailMapper.sizeChange(changeRoomDetailDto.getExRoomDetailName(), changeRoomDetailDto.getRoomLocation(), changeRoomDetailDto.getNewRoomDetailSize());
    }

    @Override
    public int roomDetailTimePriceChange(ChangeRoomDetailDto changeRoomDetailDto) {
        return roomDetailMapper.timePriceChange(changeRoomDetailDto.getExRoomDetailName(), changeRoomDetailDto.getRoomLocation(), changeRoomDetailDto.getNewRoomDetailTimePrice());
    }

    @Override
    public int roomDetailMonthPriceChange(ChangeRoomDetailDto changeRoomDetailDto) {
        return roomDetailMapper.monthPriceChange(changeRoomDetailDto.getExRoomDetailName(), changeRoomDetailDto.getRoomLocation(), changeRoomDetailDto.getNewRoomDetailMonthPrice());
    }
}
