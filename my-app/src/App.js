import logo from './logo.svg';

import "./App.css";
import Wood from './wood';

//0.React 엔진 - 데이터변경감지에서UI 그려주는 !
//1.실행과정(index.html) SPA 
//2.JSX문법
//3.바벨(자바스크립트 ES5)->ES6

//(1) retrun 시에 하나의 Dom 만 리턴할 수 있다.
//(2) 변수선언은 let 혹은 const 로만 해야 함.
//(3) if 사용 불가능 -> 삼항연산자 (조건 ? 값(true) : 값 (false))
//(4) 조건부 렌더링 (조건 &&  값 true)
//(5) css 디자인
// - 내부에 적는 방법
//- 외부 파일에 적는 방법
//- 라이브러리 사용 (부트스트랩, component-sytled)



function App() {
  let list = [1, 2, 3];

  return (
    <div>
      <div>
        {list.map(function (n) {
          return <h1>{n}</h1>;
        })}
      </div>
    </div>

  )
    ;


}


export default App;
