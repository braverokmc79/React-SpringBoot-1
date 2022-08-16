import React from 'react';
import { Card } from "react-bootstrap";
import { Link } from 'react-router-dom';

const BookItem = (props) => {

    const { id, title, author } = props.book;

    return (

        <Card className='mb-5'>
            <Card.Body>
                <Card.Title>{title}</Card.Title>
                <Link to={"/post/1" + id} className="btn btn-primary" variant="primary">상세보기</Link>
            </Card.Body>
        </Card>

    );
};

export default BookItem;