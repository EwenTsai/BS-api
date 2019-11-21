package tk.ewentsai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ewentsai.dao")
public class BsApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BsApiApplication.class, args);
	}
}
