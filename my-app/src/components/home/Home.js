import React, { useState } from 'react';
import styled from 'styled-components';

const StyledDeleteButton = styled.button`
       color :${(props) => (props.user.username === 'ssar' ? 'blue' : 'red')};
`;


const Home = (props) => {
    //구조분할 할당
    const { boards, setBoards, number, setNumber, user } = props;



    return (

        <div>
            <h1>홈페이지 입니다.  {number} </h1>
            <button onClick={() => setNumber(number + 1)}>번호 증가</button>

            <StyledDeleteButton user={user} onClick={() => setBoards([])}>전체 삭제</StyledDeleteButton>

            {boards.map((board) =>
                <h3>{board.title}  - {board.content}</h3>
            )}


        </div>
    );
};

export default Home; <h1>홈페이지 입니다.</h1>