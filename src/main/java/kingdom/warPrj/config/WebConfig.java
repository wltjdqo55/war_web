package kingdom.warPrj.config;

import kingdom.warPrj.interceptor.SessionCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private SessionCheckInterceptor sessionCheckInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(sessionCheckInterceptor)
        .addPathPatterns("/account/admin/**", "/account/analysis", "/account/battle"
            , "/account/soldier/add", "/account/soldier/edit/**", "/account/skill/add", "/account/skill/edit/**"
            , "/account/species/add", "/account/species/edit/**", "/account/storage/add", "/account/storage/edit/**"
            , "/account/legion/add", "/account/legion/edit/**", "/account/general/add", "/account/general/edit/*"
        ) // 필요한 경로에만 인터셉터 적용
        .excludePathPatterns("/account/login", "/account/error", "/account/loginCheck"); // 로그인 및 에러 페이지는 제외
  }
}
