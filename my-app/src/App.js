import { useEffect, useState } from "react";
import "./App.css";


//map, filter, concat, spread, slice
function App() {

  const [data, setData] = useState(0);
  const [search, setSearch] = useState(0);

  const download = () => {
    //다운로드 받고 (통신)
    let downloadData = 5;  //가정
    setData(downloadData);
  }

  //useEffect 실행시점 :
  //(1) App() 함수가 최초실행 될때(마운트 될 때) App 그림이 최초 그려질때
  //(2) 상태 변수가 변경될 때(  dependencyList 에 등록되어 있어야 함)
  //(3) 의존리스트 관리를 할 수 있다.
  useEffect(() => {
    console.log("userEffect 실행됨");
    download();
  }, [search]);


  return (
    <div>
      <button onClick={() => {
        setSearch(2);
      }}>검색</button>

      <h1>데이터 :  {data}</h1>
      <button onClick={() => { setData(data + 1) }}>더하기</button>
    </div>
  );

}


export default App;

