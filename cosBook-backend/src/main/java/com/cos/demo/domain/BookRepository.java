package com.cos.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;


//@Repository 적어야 스프링 IoC 에 빈으로 등록이 되는데..!!
//JpaRepository 를 extends 하면 생략가능함.
//JpaRepository는 CRUD 함수를 들고 있음.
public interface BookRepository extends JpaRepository<Book, Long>{

	
	
}
