import React, { useEffect, useState } from 'react';
import { Container } from "react-bootstrap";
import BookItem from './../../components/BookItem';

const Home = () => {

    const [books, setBooks] = useState([])

    //함수 실행시 최초 한법 실행되는 것 + 상태값이 변경될때마다 실행
    useEffect(() => {
        fetch("http://localhost:8080/book").then(res => res.json()).then(
            res => {
                // console.log(res)
                setBooks(res);
            }
        ); //비동기 함수
    }, [])


    return (
        <div>
            <Container >
                <h1 className='mb-5'>책 리스트 보기</h1>
                {books.map(book => <BookItem key={book.id} book={book} />)}
            </Container>
        </div>
    );
};

export default Home;