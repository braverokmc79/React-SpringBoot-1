import React, { useState } from 'react';
import styled from 'styled-components';

const StyledItemBoxDiv = styled.div`
    border: 1px solid black;
    padding: 10px;
    height: 100px;
    margin-bottom: 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
`;

const ListPage = () => {
    const [posts, setPosts] = useState([
        { id: 1, title: "내용1" },
        { id: 2, title: "내용2" },
        { id: 3, title: "내용3" },
        { id: 4, title: "내용4" },
        { id: 5, title: "내용5" },
        { id: 6, title: "내용6" }
    ]);

    return (
        <div>
            <h1>글목록 페이지</h1>
            {posts.map((post) => (
                <StyledItemBoxDiv>
                    <div>
                        번호 :{post.id} - 제목: {post.title}
                    </div>
                    <div>
                        <button >삭제</button>
                    </div>
                </StyledItemBoxDiv>
            ))}
        </div>
    );


}

export default ListPage;