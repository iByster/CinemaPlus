import style from "./Login.module.css"
import registrationStyle from '../Registration/Registration.module.css'
import {useState} from "react";
import {useAuthContext} from "../AuthContext";
import jwtDecode from 'jwt-decode';
import {GetClientLogged} from "../../utils/rest-calls-clients";

export function Login(){
    const [loginValues, setLoginValues] = useState({
        username: '',
        password: ''
    });

    const { login } = useAuthContext();

    function handleInputChange(e) {
        setLoginValues({
            ...loginValues,
            [e.target.name]: e.target.value,
        });
    }


    async function handleSubmit(e) {
        e.preventDefault();
        await GetClientLogged(loginValues.username, loginValues.password)
            .then(res => login(res))
            .catch(
                e => console.log(e)
            );
    }

    return(
        <form className={style.login}>
            <label htmlFor="username">Username:</label>
            <input onChange={handleInputChange} value={loginValues.username} name="username" id="username" type="text"/>
            <label htmlFor="password">Password:</label>
            <input onChange={handleInputChange} value={loginValues.password} name="password" id="password" type="password"/>
            <button onClick={handleSubmit} type="submit" className={registrationStyle.button}>Login</button>
        </form>
    );
}