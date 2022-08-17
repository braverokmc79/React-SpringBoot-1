import { useEffect, useState } from 'react';
import { Container, Form, Button } from "react-bootstrap";
import { useNavigate, useParams } from 'react-router-dom';

const UpdateForm = (props) => {
    //const id=props.match.params.id;
    const { id } = useParams();
    let navigate = useNavigate();

    const [book, setBook] = useState({
        title: "",
        author: ""
    });

    const changeValue = (e) => {
        setBook({
            ...book,
            [e.target.name]: e.target.value
        });
    }

    useEffect(() => {
        fetch("http://localhost:8080/book/" + id)
            .then((res) => res.json())
            .then(data => setBook(data))
            .catch(error => {
                console.log("에러 :", error);
            })
    }, []);


    const submitBook = (e) => {
        e.preventDefault(); //submit이 action을 안타고 자기할일을 그만함.
        fetch("http://localhost:8080/book/" + id, {
            method: 'PUT',
            //mode: "cors",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            body: JSON.stringify(book)
        })
            .then((res) => {
                console.log(1, res);
                return res.json();
            })
            .then(res => {
                console.log(2, res);
                if (res != null) {
                    //props.history.push("/");
                    navigate("/book/" + id);
                } else {
                    alert("책 등록에 실패하였습니다.");
                }
            }).catch(error => {
                console.log("실패", error);
            })
    }


    return (
        <Container>
            <h3 className='mb-5'>수정하기</h3>
            <Form onSubmit={submitBook}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>제목</Form.Label>
                    <Form.Control type="text" placeholder="Enter Title" onChange={changeValue} name="title" value={book.title} />
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>작성자</Form.Label>
                    <Form.Control type="text" placeholder="Enter Author" onChange={changeValue} name="author" value={book.author} />
                </Form.Group>

                <Button variant="primary" type="submit">
                    수정하기
                </Button>
            </Form>
        </Container>
    );
};

export default UpdateForm;