import React, { useEffect, useState } from 'react';
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

const StyledInput = styled.input`
    width: 300px;
    height: 30px;
    margin-bottom:10px;
`;
const StyledTextArea = styled.textarea`
    width: 300px;
    height: 130px;
    margin-bottom:10px;
`;
const ListPage = () => {
    const [no, setNo] = useState(6);

    const [post, setPost] = useState({
        id: no,
        title: "",
        content: ""
    })

    const [posts, setPosts] = useState([
        { id: 1, title: "제목1", content: "내용1" },
        { id: 2, title: "제목2", content: "내용2" },
        { id: 3, title: "제목3", content: "내용3" },
        { id: 4, title: "제목4", content: "내용4" },
        { id: 5, title: "제목5", content: "내용5" }
    ]);
    const hadleWrtie = () => {
        if (post.title === "") {
            alert("제목을 입력하세요");
            return;
        }
        if (post.content === "") {
            alert("내용을 입력하세요");
            return;
        }
        post.id = document.form1.id.value;
        post.title = document.form1.title.value;

        setPosts([...posts, post]);
        setNo(no + 1);

        setPost({
            id: no,
            title: "",
            content: ""
        });
        document.form1.content.value = "";
    }



    const handleForm = (e) => {
        //computed property names 문법 (키값 동적할당)
        setPost({
            ...post,
            [e.target.name]: e.target.value
        });
        console.log("[post, setPost] ", post.title, post.content);
    }

    const deletPost = (e) => {
        if (window.confirm("정말 삭제 하시겠습니까?")) {
            const id = e.target.getAttribute("data-id");
            const update = posts.filter(n => {
                return parseInt(n.id) !== parseInt(id)
            });
            console.log(id, update);

            setPosts(update);
        }
    }




    return (
        <div>
            <div>
                <h1>글쓰기 페이지</h1>
                <hr />
                <form name='form1'>
                    <input type="hidden" name='id' value={no} onChange={handleForm} />
                    <StyledInput type="text" placeholder='제목을 입력하세요.' name='title' value={post.title} onChange={handleForm} />
                    <br></br>
                    <StyledTextArea type="text" placeholder='내용을 입력하세요.' name='content' onChange={handleForm} >{post.content}</StyledTextArea>
                    <br></br>
                    <button type='button' onClick={hadleWrtie}>글쓰기</button>
                </form>
            </div>
            <br /><br /><br /><br />
            <h1>글목록 페이지</h1>
            {posts.map((post) => (
                <StyledItemBoxDiv>
                    <div>
                        번호 :{post.id} / 제목: {post.title}  / 내용 :   {post.content}
                    </div>
                    <div>
                        <button onClick={deletPost} data-id={post.id}>삭제</button>
                    </div>
                </StyledItemBoxDiv>
            ))}
        </div>
    );


}

export default ListPage;