import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';


import { Provider } from "react-redux";
import rootReducer from "./store";
import { configureStore } from '@reduxjs/toolkit'
const store = configureStore({ reducer: rootReducer })

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>

    <Provider store={store}>
      <App />
    </Provider>

  </React.StrictMode>
);



reportWebVitals();
