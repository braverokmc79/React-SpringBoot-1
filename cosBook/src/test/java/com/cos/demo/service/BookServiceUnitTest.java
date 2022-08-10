package com.cos.demo.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cos.demo.domain.BookRepository;

//단위테스트(Controller, Filter, ControllerAdvice)
//BookRepository => 가짜 객체로 만들 수 있음.
@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTest {

	@InjectMocks //BookService 객체가 만들어 질때 BookServiceUnitTest 파일에	 @Mock 로 등록된 모든 애들을 주입받는다.
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	
	
	
}
