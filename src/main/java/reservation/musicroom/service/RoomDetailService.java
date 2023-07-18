package reservation.musicroom.service;

import reservation.musicroom.domain.dto.roomDetail.ChangeRoomDetailDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailRequestDto;
import reservation.musicroom.domain.dto.roomDetail.RoomDetailResponseDto;

import java.util.List;

public interface RoomDetailService {

    int registerRoomDetail(RoomDetailRequestDto roomDetailRequestDto);
    List<RoomDetailResponseDto> findRoom(RoomDetailRequestDto roomDetailRequestDto);
    RoomDetailResponseDto findRoomNameByRoomNum(RoomDetailRequestDto roomDetailRequestDto);

    int roomDetailOptionChange(RoomDetailRequestDto roomDetailRequestDto);
    int roomDetailNameChange(ChangeRoomDetailDto changeRoomDetailDto);
    int roomDetailSizeChange(ChangeRoomDetailDto changeRoomDetailDto);
    int roomDetailTimePriceChange(ChangeRoomDetailDto changeRoomDetailDto);
    int roomDetailMonthPriceChange(ChangeRoomDetailDto changeRoomDetailDto);
}
