import {extendObservable} from 'mobx';
import CartStore from './cart';
import ProductStore from './products';
import CustomerStore from './customers';
import InvoiceStore from './invoices';
import UserStore from './users';

class Auth {
  constructor() {
    this.modulRights = {
      operator: ['productlist', 'editproduct', 'customerlist', 'editcustomer'],
      finance: ['productlist', 'editproduct', 'customerlist', 'editcustomer', 'invoicelist']
    };
    extendObservable(this, {
      isLoggedIn: !!(JSON.parse(localStorage.getItem('isLoggedIn'))),
      oldUrl: '/',
      name: localStorage.getItem('adminName')
    });
  }
  setIsLoggedIn(value, data) {
    localStorage.setItem('adminRole', data.privilege);
    localStorage.setItem('authToken', data.token);
    localStorage.setItem('adminName', data.username);
    localStorage.setItem('isLoggedIn', value);
    this.isLoggedIn = value;
  }

  getRole() {
    return localStorage.getItem('adminRole');
  }

  getName() {
    return localStorage.getItem('adminName');
  }

  logout() {
    localStorage.removeItem('isLoggedIn');
    localStorage.removeItem('adminRole');
    localStorage.removeItem('authToken');
    localStorage.removeItem('adminName');
    this.resetStores();
    this.isLoggedIn = false;
  }

  hasPermission(modul) {
    const role = localStorage.getItem('adminRole');
    
    switch (role) {
      case 'admin':
        return true;
      default:
        if (typeof this.modulRights[role] !== 'undefined') {
          return this.modulRights[role].includes(modul);
        }
        return false;
    }
  }

  resetStores() {
    ProductStore.setProducts([]);
    CustomerStore.setCustomers([]);
    InvoiceStore.setInvoices([]);
    UserStore.setUsers([]);
    CartStore.resetCart();
  }
}

export default new Auth();
