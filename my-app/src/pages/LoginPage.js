import React from 'react';
import Login from '../components/login/Login';
import { useParams, useLocation } from 'react-router-dom';



const LoginPage = (props) => {

    //const navigate = useNavigate()
    const location = useLocation()
    let params = useParams();

    //console.log("props ", props);
    //console.log("navigate ", navigate);
    console.log("location ", location);
    console.log("params ", params.id);

    return <Login />;
};

export default LoginPage;