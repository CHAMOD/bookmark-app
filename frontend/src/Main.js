import React, { useContext } from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Welcome from './components/Welcome';
import Adduser from './components/Adduser';
import Login from './components/Login';
import { LoginContext } from './components/loginContext';
import BookMarksList from './components/BookMarksList';
import Logout from './components/Logout';

const ProtectedRoute = ({ isAllowed, ...props }) => isAllowed ? <Route {...props} /> : <Redirect to="/login" />;

const Main = () => {
    const loginContext = useContext(LoginContext);
   
    return (
        
        <Container>
        <Switch>
          <Route exact path='/login' render={() => <Login/> }/>
          <Route exact path='/logout' render={() => <Logout />}/>
          <ProtectedRoute path='/editBookmark/:id'  render={(props) => <Adduser {...props} /> } isAllowed={loginContext.isLoggedIn}/>
          <ProtectedRoute path='/bookmarks'  render={() => <BookMarksList /> }isAllowed={loginContext.isLoggedIn} />
         <ProtectedRoute path='/' component={Welcome} isAllowed={loginContext.isLoggedIn} />
        </Switch>
        </Container>
    );
};

export default Main;