
import { Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import NotFound from './pages/NotFound';

import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';



function App() {
  return (

    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/login" element={<LoginPage />} >
        <Route path="/login/:id" element={<LoginPage />} />
      </Route>
      <Route path="*" element={<NotFound />} />
    </Routes >


  );
}



export default App;

