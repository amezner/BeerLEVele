import {extendObservable} from 'mobx';
import {get} from '../lib/client';
import {NotificationManager} from 'react-notifications';
import ProductStore from './products';
import CustomerStore from './customers';

class CartStore {
  constructor() {
    extendObservable(this, {
      items: [],
      productStore: ProductStore,
      customerStore: CustomerStore,
      customer_id: null
    });
  }

  addItem(stockId, quantity) {
    this.items.push({stockId, quantity});
  }

  setItems(items) {
    this.items = items;
  }

  getItems() {
    return this.items;
  }

  getProductIds() {
    return this.items.map((item) => {
      return item.stockId;
    });
  }

  modifyItem(stockId, quantity) {
    this.items.map((item) => {
      if (item.stockId === stockId) {
        item.quantity = quantity;
      }
    });
  }

  getItem(stockId) {
    return this.items.length > 0 ? this.items.find((item) => item.stockId === stockId) : null;
  }

  removeItem(id) {
    this.items = this.items.filter((item) => item.stockId !== id);
  }

  setCustomerId(id) {
    this.customer_id = id;
  }

  getCustomerId() {
    return this.customer_id;
  }

  async loadData() {
    try {
      let resp = await get('order/getcart');
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }

      this.setItems(resp);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba!';
      NotificationManager.error(message, '', 3000);
    }
  }

  loadResources() {
    this.loadData();
    ProductStore.loadData();
    CustomerStore.loadData();
  }

  resetCart() {
    this.items = [];
    this.customer_id = null;
  }

}

export default new CartStore();
