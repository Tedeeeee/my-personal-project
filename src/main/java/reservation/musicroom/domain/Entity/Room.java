package reservation.musicroom.domain.Entity;

import lombok.*;
import reservation.musicroom.domain.dto.member.MemberDto;
import reservation.musicroom.domain.dto.room.RoomRequestDto;
import reservation.musicroom.domain.dto.room.RoomResponseDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Room {
    private String memberEmail;
    private String roomName;
    private String roomLocation;
    private String roomLocationDetail;
    private String roomExplanation;
    private String roomFloor;
    private String roomFacilities;
    private String roomCount;
}
