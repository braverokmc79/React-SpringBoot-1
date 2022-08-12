import React from 'react';
import { Container } from 'react-bootstrap/Container';
import { Route, Routes } from 'react-router-dom';

import './App.css'
import Home from './pages/book/Home';
import SaveForm from './pages/book/SaveForm';
import Detail from './pages/book/Detail';
import LoginForm from './pages/user/LoginForm';
import JoinForm from './pages/user/JoinForm';
import UpdateForm from './pages/book/UpdateForm';


function App() {
  return (
    <Routes>
      <Route path='/' element={<Home />} />
      <Route path="/saveForm" element={<SaveForm />} />
      <Route path="/book/:id" element={<Detail />} />
      <Route path="/loginForm" element={<LoginForm />} />
      <Route path="/joinForm" element={<JoinForm />} />
      <Route path="/updateForm/:id" element={<UpdateForm />} />
    </Routes>
  );
}

export default App;


