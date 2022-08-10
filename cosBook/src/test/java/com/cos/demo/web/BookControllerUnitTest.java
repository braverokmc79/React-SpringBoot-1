package com.cos.demo.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.cos.demo.domain.Book;
import com.cos.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

//단위테스트(Controller 관련 로직만 띄우기) Filter, ControllerAdvice
@Slf4j
//@Transactional
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
	
	
	@Test
	public void findAll_테스트() throws Exception{
		//given
		List<Book> books=new ArrayList<>();
		books.add(new Book(1L,"스프링부트 따라하기", "코스"));
		books.add(new Book(2L,"리엑트 따라하기", "코스"));		
		
		//결과값을 미리 설정
		when(bookService.getAllBook()).thenReturn(books);
		
		
		//when
		ResultActions resultActions=mockMvc.perform(get("/book")
				.accept(MediaType.APPLICATION_JSON));
			
		//공식문서 : https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing
		//https://jsonpath.com/
		//then 
		resultActions
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", Matchers.hasSize(2)))
			.andExpect(jsonPath("$.[0].title").value("스프링부트 따라하기"))
			.andDo(MockMvcResultHandlers.print());		
	}
	

	@Test
	public void findById_테스트() throws Exception{
		
		Long id=1L;
		when(bookService.getBook(id)).thenReturn(new Book(1L, "자바 공부하기", "쌀"));
		
		
		ResultActions resultActions=mockMvc.perform(get("/book/{id}", id)
				.accept(MediaType.APPLICATION_JSON));

		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value("자바 공부하기"))
			.andDo(MockMvcResultHandlers.print());				
	}
	
	
	
	
	
	
	
	
	
	
	
	
}


