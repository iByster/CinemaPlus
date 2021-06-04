import { createContext, useContext, useState } from 'react';

export const AuthContext = createContext();

export function useAuthContext() {
    return useContext(AuthContext);
}

export function AuthContextProvider({ children }) {
    // const [accessToken, setAccessToken] = useState();
    const [userProfile, setUserProfile] = useState();

    function login(userProfile) {
        // setAccessToken(accessToken);
        setUserProfile(userProfile);
        console.log(`user: ${userProfile.username} logged in ${userProfile}`);
    }

    function logout() {
        login({});

    }

    return (
        <AuthContext.Provider value={{userProfile, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
}