package com.cos.demo.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * 통합테스트 (모든 Bean 들을 똑같이 IOC 에 올리고 테스트하는 것)
 * WebEnvironment.MOCK=실제 톰켓을 올리는것이 아니라, 다른 톰켓으로 테스트
 * WebEnvironment.RANDOM_PORT = 실제 톰켓으로 테스트
 * 
 * @AutoConfigureMockMvc MockMvc 를 IOC 에 등록해줌.
 * @Transactional 은 각각의 테스트함수가 종료될 때만다 트랜잭션을 rollback 해주는 어노테이션
 */

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) 
public class BookControllerItegreTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test1(){
		//DB insert
	}
	
	@Test
	public void test2(){
		//DB insert	
	}
	
	
}


