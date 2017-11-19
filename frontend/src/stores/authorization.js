import {extendObservable} from 'mobx';

class Auth {
  constructor() {
    extendObservable(this, {
      isLoggedIn: !!sessionStorage.getItem('isLoggedIn'),
      oldUrl: '/'
    });
  }
  setIsLoggedIn(value) {
    sessionStorage.setItem('isLoggedIn', value);
    this.isLoggedIn = value;
  }
}

export default new Auth();
