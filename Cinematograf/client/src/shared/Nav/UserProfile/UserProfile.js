import style from "./UserProfile.module.css";
import '../Nav.module.css';
import {useState} from "react";
import {NavLink} from "react-router-dom";

export function UserProfile({data}){
    const [dropdownActive, setDropdownActive] = useState(false);
    const {username} = data;

    const handleToggle = () =>{
        setDropdownActive(!dropdownActive);
    }


    return(

            <div className={style['user-profile-container']}>
                <div onClick={handleToggle} className={`${style["user-profile-logo"]} ${dropdownActive ? style["dropdown-logo-active"] : ''} ${style.noselect}`}>
                    {username.substring(0, 2).toUpperCase()}
                </div>
                <ul className={
                    `${style['dropdown-items']} 
                    ${dropdownActive ? style["dropdown-active"] : style["dropdown-disable"]} 
                    ${style['noselect']}`
                }>
                    <li>
                        <NavLink to={`/client/${username}/reservations`}>
                            Reservations
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to={`/client/${username}/offers`}>
                            Offers
                        </NavLink>
                    </li>
                    <li>Fidelity</li>
                </ul>
            </div>

    );
}