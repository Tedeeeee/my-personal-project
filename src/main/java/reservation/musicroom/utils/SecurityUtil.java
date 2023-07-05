//package reservation.musicroom.utils;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SecurityUtil {
//
//    private SecurityUtil() { }
//
//    public static String getCurrentMemberEmail() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || authentication.getName() == null) {
//            throw new RuntimeException("회원 정보가 존재하지 않습니다");
//        }
//        return authentication.getName();
//    }
//}
