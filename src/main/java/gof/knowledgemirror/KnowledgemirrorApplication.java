package gof.knowledgemirror;

import gof.knowledgemirror.filter.MyInterCeptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("gof.knowledgemirror.dao")
@ComponentScan( basePackages = "gof.knowledgemirror.*")
@ServletComponentScan
public class KnowledgemirrorApplication extends WebMvcConfigurerAdapter {

	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterCeptor()).addPathPatterns("/**").
				excludePathPatterns("/showLogin","/login");
		super.addInterceptors(registry);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(KnowledgemirrorApplication.class, args);
	}
}
