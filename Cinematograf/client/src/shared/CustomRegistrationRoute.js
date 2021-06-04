import {useAuthContext} from "../Auth/AuthContext";
import {Redirect, Route} from "react-router";

export function CustomRegistrationRoute({component: Component, ...rest}){
    const {userProfile} = useAuthContext();

    return (
        <Route
            {...rest}
            render={(props) =>
                userProfile?.username ? (
                        <Redirect
                            to={{
                                pathname: '/',
                                state: { from: props.location },
                            }}
                        />

                ) : (
                    <Component {...props}/>
                )
            }
        />
    );
}