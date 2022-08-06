import React from 'react';



const WritePage = () => {

    const hadleWrtie = (props) => {
        //ListPage 의 setPosts에 무엇을 담아야 함?
        let post = { id: 6, title: "인풋값" }
        console.log(props);
        // setPosts();
    }

    return (
        <div>
            <h1>글쓰기 페이지</h1>
            <hr />
            <form>
                <input type="text" placeholder='제목을 입력하세요.' />
                <button type='button' onClick={hadleWrtie}>글쓰기</button>
            </form>
        </div >
    );
};

export default WritePage;