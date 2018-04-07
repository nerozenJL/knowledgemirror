package gof.knowledgemirror;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("gof.knowledgemirror.dao")
@ComponentScan( basePackages = "gof.knowledgemirror.*")
public class KnowledgemirrorApplication {
	public static void main(String[] args) {
		SpringApplication.run(KnowledgemirrorApplication.class, args);
	}
}
