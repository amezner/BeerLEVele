import {extendObservable} from 'mobx';

class Auth {
  constructor() {
    extendObservable(this, {
      isLoggedIn: !!(JSON.parse(localStorage.getItem('isLoggedIn'))),
      oldUrl: '/',
      role: localStorage.getItem('adminRole'),
      name: localStorage.getItem('adminName')
    });
  }
  setIsLoggedIn(value, data) {
    localStorage.setItem('isLoggedIn', value);
    localStorage.setItem('adminRole', data.privilege);
    localStorage.setItem('authToken', data.token);
    localStorage.setItem('adminName', data.username);
    this.isLoggedIn = value;
  }

  getRole() {
    return this.role;
  }

  getName() {
    return this.name;
  }

  logout() {
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('adminRole');
    localStorage.removeItem('authToken');
    localStorage.removeItem('adminName');
    this.isLoggedIn = false;
  }

  hasRight(modul) {
    const role = this.role;
    switch (role) {
      case 'admin':
        return true;
      case 'operator':
        return this.checkOperatorRights(modul);
      case 'finance':
        return this.checkFinanceRights(modul);
      default:
        return false;
    }
  }

  checkOperatorRights(modul) {
    const modules = ['productlist', 'customerlist'];

    return modules.includes(modul);
  }

  checkFinanceRights(modul) {
    const modules = ['customerlist', 'productlist'];

    return modules.includes(modul);
  }
}

export default new Auth();
