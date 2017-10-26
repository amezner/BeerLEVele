import {extendObservable} from 'mobx';

class Auth {
  constructor() {
    extendObservable(this, {
      isLoggedIn: !!localStorage.isLoggedIn,
      oldUrl: '/'
    });
  }
  setIsLoggedIn(value) {
    localStorage.isLoggedIn = value;
    this.isLoggedIn = value;
  }
}

export default new Auth();
