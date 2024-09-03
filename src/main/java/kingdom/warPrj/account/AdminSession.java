package kingdom.warPrj.account;

import jakarta.servlet.http.HttpSession;
import kingdom.warPrj.entity.dto.AdminDTO;

public class AdminSession {

  //세션값 설정
  public static void setSession(AdminDTO adminDTO, HttpSession session, int time){
    session.setAttribute("adminInfo", adminDTO);
    intervalSession(time, session);
  }

  //세션 유지시간 설정
  public static void intervalSession(int time, HttpSession session){
    session.setMaxInactiveInterval(time);
  }

  //세션값 삭제
  public static void removeSession(String sessionName, HttpSession session){
    session.removeAttribute(sessionName);
  }

  //세션 전체 제거, 무효화
  public static void closeSession(HttpSession session){
    session.invalidate();
  }
}
