
import { Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import NotFound from './pages/NotFound';



import ListPage from './pages/ListPage';
import WritePage from './pages/WritePage';
import Navigation from './components/Navigation';

//글쓰기,글삭제,글목록보기

function App() {
  return (
    <div>
      {/* <Navigation /> */}
      <Navigation />
      <Routes>
        <Route path='/' element={<ListPage />} />
        <Route path='/write' element={<WritePage />} />
      </Routes>
    </div>

  );

}



export default App;

