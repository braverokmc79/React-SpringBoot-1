import React, { useEffect, useState } from 'react';
import Footer from '../components/Footer';
import Header from '../components/Header';
import Home from '../components/home/Home';

const HomePage = () => {

    //http요청 (jquery ajax, fetch, axios(다운))
    const [boards, setBoards] = useState([]);
    const [number, setNumber] = useState(0);



    //빈 배열이면 한번만 실행
    useEffect(() => {

        //다운로드 가정 =fetch(),axios(),ajax()
        let data = [
            { id: 1, title: "제목1", content: "내용1" },
            { id: 2, title: "제목1", content: "내용2" },
            { id: 3, title: "제목1", content: "내용3" },
        ];

        setBoards([...data]);

    }, [])


    return (
        <div>
            <Header />
            <Home boards={boards} setBoards={setBoards} number={number} setNumber={setNumber} />
            <Footer />
        </div>
    );
};

export default HomePage;