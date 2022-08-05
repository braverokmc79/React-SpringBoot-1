import React, { useState } from 'react';


//Function 방식
//class 방식
const Home = (props) => {
    //구조분할 할당
    const { boards, setBoards, number, setNumber } = props;

    return (

        <div>
            <h1>홈페이지 입니다.  {number} </h1>
            <button onClick={() => setNumber(number + 1)}>번호 증가</button>

            <button onClick={() => setBoards([])}>전체 삭제</button>

            {boards.map((board) =>
                <h3>{board.title}  - {board.content}</h3>
            )}


        </div>
    );
};

export default Home; <h1>홈페이지 입니다.</h1>