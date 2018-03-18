package gof.knowledgemirror;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("gof.knowledgemirror.mappers")
public class KnowledgemirrorApplication {
	public static void main(String[] args) {
		SpringApplication.run(KnowledgemirrorApplication.class, args);
	}
}
