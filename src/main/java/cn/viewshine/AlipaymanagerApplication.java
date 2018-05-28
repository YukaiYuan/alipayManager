package cn.viewshine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.viewshine.mapper")
public class AlipaymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlipaymanagerApplication.class, args);
	}
}
