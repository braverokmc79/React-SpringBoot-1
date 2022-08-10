package com.cos.demo.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import com.cos.demo.domain.Book;
import com.cos.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

//단위테스트(Controller 관련 로직만 띄우기) Filter, ControllerAdvice
@Slf4j
@Transactional
@WebMvcTest
public class BookControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean //IoC 환경에 bean 등록됨.
	private BookService bookService;
	
	//BDDMockito 패턴 given, when, then
	@Test
	public void save_테스트() throws Exception {
		log.info("save_테스트() 시작 ==========================");
		//given (테스트를 하기 위한 준비)
		Book book=new Book(null, "스프링 따라하기", "코스");
		String content=new ObjectMapper().writeValueAsString(book);
		log.info(content);
		
		//결과값을 미리 설정
		when(bookService.saveBook(book)).thenReturn(new Book(1L,"스프링 따라하기", "코스"));
		
		
		//when(테스트 실행)
		ResultActions resultActions =mockMvc.perform(post("/book").contentType(
				MediaType.APPLICATION_JSON).content(content).accept(MediaType.APPLICATION_JSON));
		
		
		//then(검증)  //https://jsonpath.com/
		resultActions
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.title").value("스프링 따라하기"))
			.andDo(MockMvcResultHandlers.print());		
	}
	
	
	
}
