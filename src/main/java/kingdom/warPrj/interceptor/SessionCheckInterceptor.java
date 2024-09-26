package kingdom.warPrj.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionCheckInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute("adminInfo") == null) {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write("<script>alert('접근권한이 없습니다.'); window.location='/account/login';</script>");
    }
    return true; // 요청을 계속 진행
  }
}
