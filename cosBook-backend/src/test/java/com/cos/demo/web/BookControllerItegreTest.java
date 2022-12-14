package com.cos.demo.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import com.cos.demo.domain.Book;
import com.cos.demo.domain.BookRepository;
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
	private BookRepository bookRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	
//	@BeforeEach
//	public void init(){
//		List<Book> books =new ArrayList<Book>();
//		books.add(new Book(null,"스프링부트 따라하기","코스"));
//		books.add(new Book(null,"리엑트 따라하기","코스"));
//		books.add(new Book(null,"JUnit 따라하기","코스"));
//		bookRepository.saveAll(books);
//		entityManager.createNativeQuery("ALTER TABLE book ALTER COLUMN id RESTART WITH 1").executeUpdate();
//		//entityManager.createNativeQuery("ALTER TABLE book AUTO_INCREMENT=1").executeUpdate();
//	}
//	
//	@AfterEach
//	public void end(){
//		bookRepository.deleteAll();
//	}
	
	
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
	public void findAll_테스트() throws Exception{
		//given
		List<Book> books=new ArrayList<>();
		books.add(new Book(1L,"스프링부트 따라하기", "코스"));
		books.add(new Book(2L,"리엑트 따라하기", "코스"));		
		
		bookRepository.saveAll(books);
		
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
		List<Book> books =new ArrayList<Book>();
		books.add(new Book(null,"스프링부트 따라하기","코스"));
		books.add(new Book(null,"리엑트 따라하기","코스"));
		books.add(new Book(null,"JUnit 따라하기","코스"));
		bookRepository.saveAll(books);
		
		Long id=1L;
		
		ResultActions resultActions=mockMvc.perform(get("/book/{id}", id)
				.accept(MediaType.APPLICATION_JSON));
		
		//then
		resultActions
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value("스프링부트 따라하기"))
			.andDo(MockMvcResultHandlers.print());				
	}
	
	
	@Test
	public void update_테스트() throws Exception{
		Long id=1L;
		List<Book> books =new ArrayList<Book>();
		books.add(new Book(null,"스프링부트 따라하기","코스"));
		books.add(new Book(null,"리엑트 따라하기","코스"));
		books.add(new Book(null,"JUnit 따라하기","코스"));
		bookRepository.saveAll(books);
		
		
		Book book=new Book(id, "C++ 따라하기","코스");
		String content=new ObjectMapper().writeValueAsString(book);
		//영속성 객체 가져오기
		Book entitiy=bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("ID 를 찾을 수 없습니다."));
		entitiy.setTitle(book.getTitle());
		
	
		//when
		ResultActions resultActions=mockMvc.perform(
				put("/book/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.content(content)
				.accept(MediaType.APPLICATION_JSON));
			
		
		//공식문서 : https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing
		//https://jsonpath.com/
		//then 
		resultActions
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value("C++ 따라하기"))
			.andDo(MockMvcResultHandlers.print());						
	}
	
	
	
	@Test
	public void delete_테스트() throws Exception{	
		Long id=1L;
		Book book=new Book(id, "C++ 따라하기","코스");
		bookRepository.save(book);
		
		//삭제처리시 예상값
		//when(bookService.deletBook(id)).thenReturn("ok");
				
		//when
		ResultActions resultActions=mockMvc.perform(delete("/book/{id}", id)
				.accept(MediaType.TEXT_PLAIN));
		
		//then
		resultActions
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print());
				
		MvcResult requestResult=resultActions.andReturn();
		String result=requestResult.getResponse().getContentAsString();
		
		log.info("1.resultActions  ==>{}", resultActions);
		log.info("2.result  ==>{}", result);		
		assertEquals("ok", result);			
	}
	
	
	
}


