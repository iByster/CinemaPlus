import style from './Registration.module.css'

export function Registration(){
    return(
        <div className={style["registration-container"]}>
              <h1>Registration page</h1>
            <form className={style["form-alignment-grid"]}>
                <label className={style["grid-item-align-center"]} htmlFor="username">Username:</label>
                <input className={style["grid-item-align-center-stretch"]} name="username" id="username" type="text"/>
                <label className={style["grid-item-align-center"]} htmlFor="password">Password:</label>
                <input className={style["grid-item-align-center-stretch"]} name="password" id="password" type="password"/>
                <label className={style["grid-item-align-center"]} htmlFor="re-password">Re-Password:</label>
                <input className={style["grid-item-align-center-stretch"]} name="re-password" id="re-password" type="password"/>
                <button className={`${style["grid-item-align-center"]} ${style["button"]}`} type="submit">Register</button>
            </form>
        </div>
    );
}