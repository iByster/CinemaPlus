import {useAuthContext} from "../Auth/AuthContext";
import {Redirect, Route} from "react-router";

export function PrivateRoute({component: Component, ...rest}){
    const {userProfile} = useAuthContext();

    return (
        <Route
            {...rest}
            render={(props) =>
                userProfile?.username ? (
                    <Component {...props}/>
                ) : (
                    <Redirect
                        to={{
                            pathname: '/registration',
                            state: { from: props.location },
                        }}
                    />
                )
            }
        />
    );
}