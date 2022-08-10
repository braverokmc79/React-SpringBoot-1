package com.cos.demo.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import com.cos.demo.domain.Book;
import com.cos.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 통합테스트 (모든 Bean 들을 똑같이 IOC 에 올리고 테스트하는 것)
 * WebEnvironment.MOCK=실제 톰켓을 올리는것이 아니라, 다른 톰켓으로 테스트
 * WebEnvironment.RANDOM_PORT = 실제 톰켓으로 테스트
 * 
 * @AutoConfigureMockMvc MockMvc 를 IOC 에 등록해줌.
 * @Transactional 은 각각의 테스트함수가 종료될 때만다 트랜잭션을 rollback 해주는 어노테이션
 */
@Slf4j
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) 
public class BookControllerItegreTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private BookService bookService;
	
	@Test
	public void save_테스트() throws Exception {
		log.info("save_테스트() 시작 ==========================");
		//given (테스트를 하기 위한 준비)
		Book book=new Book(null, "스프링 따라하기", "코스");
		String content=new ObjectMapper().writeValueAsString(book);
		log.info(content);
		
		
		//when(테스트 실행)
		ResultActions resultActions =mockMvc.perform(post("/book").contentType(
				MediaType.APPLICATION_JSON).content(content).accept(MediaType.APPLICATION_JSON));
		
		
		//then(검증)  //https://jsonpath.com/
		resultActions
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.title").value("스프링 따라하기"))
			.andDo(MockMvcResultHandlers.print());		
	}
	
	
	
	@Test
	public void test1(){
		//DB insert
	}
	
	@Test
	public void test2(){
		//DB insert	
	}
	
	
}


