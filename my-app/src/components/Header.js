import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

//하나의 컴포넌트를 생성(재사용)

//styled-components => js 파일과 css 파일 관리!!!
const StyleHeaderDiv = styled.div`
    border: 1px solid black;
    height: 300px;
    background-color: ${(props) => props.backgroundColor};
`;

const StyleHeadLink = styled.a`
    color: red;
    text-decoration: none;
    outline: none;
`;


const Header = () => {
    // return (
    //     <StyleHeaderDiv backgroundColor="#8bc34a" >
    //         <div>
    //             <ul>
    //                 <li><StyleHeadLink to="/">홈</StyleHeadLink></li>
    //                 <li><StyleHeadLink to="/login/10">로그인</StyleHeadLink></li>
    //             </ul>
    //         </div>
    //     </StyleHeaderDiv>
    // );


    return (
        <>
            <Navbar bg="primary" variant="dark">
                <Container>
                    <Navbar.Brand href="#">Navbar</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/">홈</Nav.Link>
                        <Link to="/login" className='nav-link StyleHeadLink'>로그인</Link>
                        <Nav.Link href="/login">로그인</Nav.Link>
                        <Nav.Link href="#pricing">Pricing</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>




        </>
    );
};



export default Header;