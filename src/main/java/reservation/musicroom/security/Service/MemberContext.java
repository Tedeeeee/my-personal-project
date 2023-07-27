package reservation.musicroom.security.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import reservation.musicroom.domain.Entity.Member;

import java.util.Collection;

public class MemberContext extends User {

    private final Member member;

    public MemberContext(Member member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getMemberEmail(), member.getMemberPassword(), authorities);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}
