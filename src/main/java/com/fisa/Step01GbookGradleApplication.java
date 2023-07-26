/*
 * 이미 존재하는 table 사용하는 로직으로 spring data jsp 학습
 * table명 : deptcopy
 * application.yml 의 table 생성 비활성화 : none- 존재하는 애 한해서만 인식하겠다. 새로 생성 안한다.
 */

package com.fisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//연관없는 package 내부에 존재하는 스프링 빈 package 등록
//@ComponentScan({})

@SpringBootApplication
public class Step01GbookGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step01GbookGradleApplication.class, args);
	}

}
