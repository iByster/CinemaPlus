import logo from "../../images/cinema-logo.png"
import style from "./Nav.module.css"
export function Logo(){
    return(
        <div className={style.logo}>
            <img src={logo} alt="Logo" className={style["logo-image-nav"]}/>
            <p>Cinema+</p>
        </div>
    );
}