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

    String[] interceptorPath = new String[]{"/account/admin/**", "/account/analysis"
        , "/account/soldier/add", "/account/soldier/edit/**", "/account/skill/add", "/account/skill/edit/**"
        , "/account/species/add", "/account/species/edit/**", "/account/storage/add", "/account/storage/edit/**"
        , "/account/legion/add", "/account/legion/edit/**", "/account/general/add", "/account/general/edit/*"};

    String[] excludePath = new String[]{"/account/login", "/account/error", "/account/loginCheck"};

    registry.addInterceptor(sessionCheckInterceptor)
        .addPathPatterns(interceptorPath) // 필요한 경로에만 인터셉터 적용
        .excludePathPatterns(excludePath); // 로그인 및 에러 페이지는 제외
  }
}
