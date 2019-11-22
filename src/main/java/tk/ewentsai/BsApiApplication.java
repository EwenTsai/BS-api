package tk.ewentsai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("tk.ewentsai.dao")
public class BsApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BsApiApplication.class, args);
	}
}
