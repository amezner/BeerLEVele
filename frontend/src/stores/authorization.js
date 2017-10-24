import {observable} from 'mobx';

const defaultState = {
  isLoggedIn: false,
  oldUrl: '/'
};

if ( localStorage.isLoggedIn ) {
  defaultState.isLoggedIn = true;
}

const Auth = observable(defaultState);

export default Auth;
