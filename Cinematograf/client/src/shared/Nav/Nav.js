import { Link, NavLink } from 'react-router-dom';
import {Login} from "../../Auth/Login/Login";
import style from "./Nav.module.css"
import buttonStyle from '../../Auth/Registration/Registration.module.css'
import {Logo} from "./Logo";
import {useAuthContext} from "../../Auth/AuthContext";
import {UserProfile} from "./UserProfile/UserProfile";
// import {Dropdown, DropdownButton, SplitButton, ButtonGroup}  from "react-bootstrap";
import './UserProfile/UserProfile.module.css'

export function Nav(){
    const {userProfile} = useAuthContext();

    return(
      <nav className={style.nav}>
          <Link exact to="/" style={{textDecoration:'none', color:'#181518', fontWeight:'bolder'}}>
              <Logo/>
          </Link>
          <ul>
              {!userProfile?.username && (
                  <>
                    <li className={style["push-left"]}>
                      <Login/>
                    </li>
                    <li className={`${style["registration-link"]} ${style["align-nav-items-vertical"]}`}>
                    <NavLink to="/registration">Registration</NavLink>
                    </li>
                  </>
              )}
              {userProfile?.username && (
                  <>
                    <li className={style["push-left"]}>
                        <UserProfile data={userProfile}/>

                    </li>
                    <li>
                    <button className={buttonStyle['button']}>
                            Logout
                        </button>
                    </li>
                  </>
              )}

          </ul>
      </nav>
    );
}
