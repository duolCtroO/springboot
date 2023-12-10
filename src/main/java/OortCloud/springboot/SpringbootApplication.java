package OortCloud.springboot;

import OortCloud.config.MySpringBootAnnotation;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


@MySpringBootAnnotation
public class SpringbootApplication {
	// Spring Container 생성 이후 ApplicationRunner를 구현하면 해당 내용이 실행됨
//	@Bean
//	ApplicationRunner applicationRunner(Environment env){
//		return args -> {
//			String name = env.getProperty("my.name");
//			System.out.println("my.name : " + name);
//		};
//	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		//MySpringBootApplication.run(SpringbootApplication.class, args);
	}

}
