import './App.css';
import {Nav} from "./shared/Nav/Nav";
import {Switch, Route, BrowserRouter, useLocation} from "react-router-dom";
import {Registration} from "./Auth/Registration/Registation";
import {SidebarUtils} from "./shared/SidebarUtils/SidebarUtils";
import {MovieList} from "./Movies/MovieList";
import {MovieDetails} from "./Movies/MovieDetails";
import {AuthContextProvider} from "./Auth/AuthContext";
import {Reservations} from "./Reservations/Reservations";
import {Offers} from "./Offers/Offers";
import {PrivateRoute} from "./shared/PrivateRoute";
import {BuyTicketPage} from "./BuyTicketPage/BuyTicketPage";


function App() {
    const location = useLocation();
  return (
      <AuthContextProvider>

          <Nav/>
          {location.pathname.includes('/buyticket') ? null : <SidebarUtils/>}
        <Switch>

            <Route exact path="/" component={MovieList}/>
            <Route path="/registration" component={Registration}/>
            <Route path="/movies/:id" component={MovieDetails} />
            <PrivateRoute path="/client/:username/reservations" component={Reservations}/>
            <PrivateRoute path="/client/:username/offers" component={Offers}/>
            <PrivateRoute path="/buyticket/:title/:id" component={BuyTicketPage}/>
            <Route path="*" component={() => <h1>404</h1>} />
        </Switch>
      </AuthContextProvider>
  );
}

export default App;
