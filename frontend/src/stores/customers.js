import {extendObservable} from 'mobx';
import {get} from '../lib/client';
import {NotificationManager} from 'react-notifications';

class CustomersStore {
  constructor() {
    extendObservable(this, {
      'customers': []
    });
  }

  setCustomers(customers) {
    this.customers = customers;
  }

  getCustomers() {
    return this.customers;
  }

  getCustomer(id) {
    return this.customers.length > 0 ?  this.customers.find((item) => item.id === id) : null;
  }

  deleteCustomer(id) {
    this.customers = this.customers.filter((customer) => customer.id !== id);
  }

  async loadData() {
    try {
      let resp = await get('customer/getallcustomer');
     /* if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }*/
      console.log(resp);

      this.setCustomers(resp.customer);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message);
    }

  }
}

export default new CustomersStore();
