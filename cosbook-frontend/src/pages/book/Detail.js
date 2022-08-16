import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container } from "react-bootstrap";

const Detail = () => {
    const { id } = useParams();

    const [book, setBook] = useState({
        title: '',
        author: ''
    })

    useEffect(() => {
        console.log("id : ", id);
        fetch("http://localhost:8080/book/" + id)
            .then((res) => res.json())
            .then(
                data => {
                    console.log("data : ", data);
                    setBook(data);
                }
            )
            .catch(error => {
                console.log("에러", error);
            });

    }, [])

    return (
        <Container>
            <h1>책 상세보기</h1>
            <hr />
            <h3>{book.author}</h3>
            <h1>{book.title}</h1>
        </Container>
    );
};

export default Detail;