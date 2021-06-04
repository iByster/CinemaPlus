import './App.css';
import {Nav} from "./shared/Nav/Nav";
import {Switch, Route, BrowserRouter, useLocation} from "react-router-dom";
import {Registration} from "./Auth/Registration/Registation";
import {SidebarUtils} from "./shared/SidebarUtils/SidebarUtils";
import {MovieList} from "./Movies/MovieList";
import {MovieDetails} from "./Movies/MovieDetails";
import {AuthContextProvider} from "./Auth/AuthContext";
import {Reservation} from "./Reservations/Reservation";
import {Offers} from "./Offers/Offers";
import {PrivateRoute} from "./shared/PrivateRoute";
import {BuyTicketPage} from "./BuyTicketPage/BuyTicketPage";
import {ReservationsContainer} from "./Reservations/ReservationsContainer";
import {AddMovie} from "./Admin/AddMovie";
import {MovieContextProvider} from "./Movies/MovieContextProvider";
import {CustomRegistrationRoute} from "./shared/CustomRegistrationRoute";
import {Footer} from "./shared/Footer/Footer";
import {OffersContainer} from "./Offers/OffersContainer";


function App() {
    const location = useLocation();
  return (
      <AuthContextProvider>
          <MovieContextProvider>
          <Nav/>
          {location.pathname.includes('/buyticket') || location.pathname.includes('/reservations') ? null : <SidebarUtils/>}

          <Switch>
            <Route exact path="/" component={MovieList}/>
            <PrivateRoute path="/admin/add-movie" component={AddMovie}/>
            <PrivateRoute path="/admin/update-movie" component={() => (<AddMovie isUpdate/>)}/>
            <CustomRegistrationRoute path="/registration" component={Registration}/>
            <Route path="/movies/:id" component={MovieDetails} />
            <PrivateRoute path="/client/:username/reservations" component={ReservationsContainer}/>
            <PrivateRoute path="/client/:username/offers" component={OffersContainer}/>
            <PrivateRoute path="/buyticket/:title/:id" component={BuyTicketPage}/>
            <Route path="*" component={() => <h1>404</h1>} />
        </Switch>
              <Footer/>
          </MovieContextProvider>
      </AuthContextProvider>
  );
}

export default App;
