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

    // 세션이 없으면 에러 페이지로 리다이렉트
    if (session == null || session.getAttribute("adminInfo") == null) {
      response.sendRedirect("/account/login");
      return false; // 요청을 중단
    }
    return true; // 요청을 계속 진행
  }
}
