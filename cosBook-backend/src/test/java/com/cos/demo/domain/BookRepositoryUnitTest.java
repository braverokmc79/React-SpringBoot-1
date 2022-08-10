package com.cos.demo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

//단위테스트(Controller, Filter, ControllerAdvice
@Transactional
@AutoConfigureTestDatabase(replace = Replace.ANY) //Replace.ANY 가짜 디비로 테스트, Replace.None 실제 DB 로 테스트
@DataJpaTest() //Repository 들을 다 IOC 등록해둠.
public class BookRepositoryUnitTest {

	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Test
	public void save_테스트(){		
		Book book=new Book(null,"책제목1","책저자1");		
		Book bookEntity=bookRepository.save(book);		
		assertEquals("책제목1", bookEntity.getTitle());		
	}
	
	
	
}
