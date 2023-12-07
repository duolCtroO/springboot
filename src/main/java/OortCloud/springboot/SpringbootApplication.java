package OortCloud.springboot;

import OortCloud.config.MySpringBootAnnotation;


@MySpringBootAnnotation
public class SpringbootApplication {
	public static void main(String[] args) {
		//SpringApplication.run(SpringbootApplication.class, args);
		MySpringBootApplication.run(SpringbootApplication.class, args);
	}

}
