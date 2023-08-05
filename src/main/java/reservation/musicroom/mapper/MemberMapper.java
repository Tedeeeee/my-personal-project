package reservation.musicroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import reservation.musicroom.domain.Entity.Member;

@Mapper
public interface MemberMapper {
    int save(Member member);
    Member findByEmail(String memberEmail);

    Member findBySq(int memberSq);
}
