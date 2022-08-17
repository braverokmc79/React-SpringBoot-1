import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { Button, Container } from "react-bootstrap";

const Detail = () => {
    const { id } = useParams();
    let navigate = useNavigate();

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

    const deleteBook = () => {

        fetch("http://localhost:8080/book/" + id, {
            method: "DELETE",
        })
            .then((res) => res.text())
            .then((data) => {
                console.log("data : ", data);
                if (data === "ok") {
                    navigate("/");
                }
            })
            .catch(error => {
                console.log("에러 ", error);
            })
    }

    const updateBook = () => {
        navigate("/updateForm/" + id);
    }


    return (
        <Container>
            <h1>책 상세보기</h1>
            <Button variant='warning' className='me-3' onClick={updateBook}>수정</Button>
            {''}
            <Button variant='danger' onClick={deleteBook}>삭제</Button>
            <hr />
            <h3>저자 - {book.author}</h3>
            <h1>제목 - {book.title}</h1>
        </Container>
    );
};

export default Detail;