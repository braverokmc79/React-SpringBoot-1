import React from 'react';
import styled from 'styled-components';
import { useNavigate } from "react-router-dom";

const LoginBox = styled.div`
    padding: 30px 0 30px 0;
`;

const Login = () => {
    let navigate = useNavigate();

    //  const goHome = () => {
    // navigate("/");
    //    navigate(-1);
    //    }
    return (
        <LoginBox>
            <button onClick={() => navigate(-1)}>뒤로가기</button>
            <h1>로그인 페이지입니다.</h1>
        </LoginBox>
    );
};

export default Login;