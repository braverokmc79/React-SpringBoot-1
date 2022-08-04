
import { createRef, useRef, useState } from "react";



//userRef(디자인)
//dom 을 변경할 때 사용
function App() {

  const myRef = useRef(null);
  const [list, setList] = useState([{ id: 1, name: "홍길동" }, { id: 1, name: "임꺽정" }])
  const myRefs = Array.from({ length: list.length }).map(() => createRef());

  return (
    <div>
      <button onClick={() => {
        console.log(myRef);
        console.log(myRef.current);
        //        myRef.current.style.backgroundColor = 'red';

        myRefs[1].current.style.backgroundColor = 'red';
      }}>색변경</button>
      <div ref={myRef}>박스</div>

      {list.map((user, index) => (
        <h1 ref={myRefs[index]}>{user.name}</h1>
      ))}


    </div>
  );


}


export default App;

