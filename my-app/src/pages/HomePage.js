import React, { useEffect, useState } from 'react';
import Home from '../components/home/Home';

const HomePage = () => {

    //http요청 (jquery ajax, fetch, axios(다운))
    const [boards, setBoards] = useState([]);
    const [number, setNumber] = useState(0);
    const [user, setUser] = useState([]);


    //빈 배열이면 한번만 실행
    useEffect(() => {

        //다운로드 가정 =fetch(),axios(),ajax()
        let data = [
            { id: 1, title: "제목1", content: "내용1" },
            { id: 2, title: "제목1", content: "내용2" },
            { id: 3, title: "제목1", content: "내용3" },
        ];

        setBoards([...data]);
        setUser({ id: 1, username: 'ssar' });

    }, [])


    return <Home boards={boards} setBoards={setBoards} user={user} number={number} setNumber={setNumber} />;


};

export default HomePage;