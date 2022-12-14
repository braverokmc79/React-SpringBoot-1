package com.cos.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.demo.domain.Book;
import com.cos.demo.domain.BookRepository;

import lombok.RequiredArgsConstructor;

//기능을 정의할 수 있고, 트랜잭션을 관리할 수 있음.
@Service
@Transactional  //서비스 함수가 종료될 때 commit 할지 rollback 할지 트랜잭션 관리하겠다.
@RequiredArgsConstructor
public class BookService {

	
	private final BookRepository bookRepository;
	
		
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	
	//JPA 변경감지라는 내부 기능 활성화 x, update 시의 정합성을 유지해줌. insert 의 유령데이터현성(팬텀현상) 못 막음
	@Transactional(readOnly = true)
	public Book getBook(Long id) {
		return bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id를 확인해 주세요!"));
	}
	
	
	public List<Book> getAllBook(){
		return bookRepository.findAll();
	}
	

	public Book updateBook(Long id, Book book) {
		//더티체킹 update 하기
		//영속화(book 오브젝트)-> 영속성 컨텍스트 보관
		Book bookEntity=bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id 를 확인해 주세요.!")); 
		
		bookEntity.setTitle(book.getTitle());
		bookEntity.setAuthor(book.getAuthor());
		return bookEntity;
	}//함수 종료 => 트랜잭션 종료 => 영속화 되어있는 데이터를 DB로 갱신(flush) => commit =======> 더티체킹
	
	
	
	
	public String deletBook(Long id) {
		 bookRepository.deleteById(id);
		 return "ok";
	}
	
	
	
	
}
