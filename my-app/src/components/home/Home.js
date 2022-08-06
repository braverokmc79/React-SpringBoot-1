import React from 'react';
import styled from 'styled-components';

const StyledDeleteButton = styled.button`
       color :${(props) => (props.user.username === 'ssar' ? 'blue' : 'red')};     
`;

//스타일 확장
const StyledAddButton = styled(StyledDeleteButton)`
       background-color: green;
`;



const Home = (props) => {
    //구조분할 할당
    const { boards, setBoards, number, setNumber, user } = props;

    return (

        <div>
            <h1>홈페이지 입니다.  {number} </h1>
            <button className='btn btn-success ml-3 me-3 mb-5' onClick={() => setNumber(number + 1)}>번호 증가</button>

            <StyledAddButton user={user}>더하기</StyledAddButton>

            <StyledDeleteButton user={user} onClick={() => setBoards([])}>전체 삭제</StyledDeleteButton>

            {boards.map((board) =>
                <h3>{board.title}  - {board.content}</h3>
            )}
        </div>
    );
};

export default Home; <h1>홈페이지 입니다.</h1>