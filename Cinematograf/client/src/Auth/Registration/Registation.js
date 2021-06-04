import style from './Registration.module.css'
import {useState} from "react";
import {useAuthContext} from "../AuthContext";
import {GetClientLogged, SaveClient} from "../../utils/rest-calls-clients";
import {GetAdminLogged} from "../../utils/rest-calls-admins";
import {SaveSeat} from "../../utils/rest-calls-seats";

export function Registration(){
    const [registerValues, setRegisterValues] = useState({
        username: '',
        password: '',
        rePassword:'',
        name:'',
        age:'',
        telNumber:''
    });

    const { login } = useAuthContext();

    function handleInputChange(e) {
        setRegisterValues({
            ...registerValues,
            [e.target.name]: e.target.value,
        });
    }

    async function handleSubmit(e) {
        e.preventDefault();
        if(registerValues.password === registerValues.rePassword){
            await SaveClient(...[registerValues])
                .then(res => login(res))
                .then(res => alert(`You are you now signed in to Cinema+!`))
                .catch(e => console.log(e));
        }

    }

    return(
        <div className={style["registration-background"]}>
            <div className={style["registration-container"]}>
                <h1>Registration page</h1>

                <form className={style["form-alignment-grid"]}>
                    <label className={style["grid-item-align-center"]} htmlFor="username">Username:</label>
                    <input onChange={handleInputChange} value={registerValues.username} className={style["grid-item-align-center-stretch"]} name="username" id="username" type="text"/>
                    <label className={style["grid-item-align-center"]} htmlFor="password">Password:</label>
                    <input onChange={handleInputChange} value={registerValues.password} className={style["grid-item-align-center-stretch"]} name="password" id="password" type="password"/>
                    <label className={style["grid-item-align-center"]} htmlFor="rePassword">Re-Password:</label>
                    <input onChange={handleInputChange} value={registerValues.rePassword} className={style["grid-item-align-center-stretch"]} name="rePassword" id="rePassword" type="password"/>
                    <label className={style["grid-item-align-center"]} htmlFor="name">Full-Name:</label>
                    <input onChange={handleInputChange} value={registerValues.name} className={style["grid-item-align-center-stretch"]} name="name" id="name" type="text "/>
                    <label className={style["grid-item-align-center"]} htmlFor="telNumber">Telephone:</label>
                    <input onChange={handleInputChange} value={registerValues.telNumber} className={style["grid-item-align-center-stretch"]} name="telNumber" id="telNumber" type="text"/>
                    <label className={style["grid-item-align-center"]} htmlFor="age">Age:</label>
                    <input onChange={handleInputChange} value={registerValues.age} className={style["grid-item-align-center-stretch"]} name="age" id="age" type="text"/>
                    <button onClick={handleSubmit} className={`${style["grid-item-align-center"]} ${style["button"]}`} type="submit">Register</button>
                </form>
            </div>
        </div>
    );
}