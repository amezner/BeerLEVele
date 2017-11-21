import {extendObservable} from 'mobx';
import {get} from '../lib/client';
import {NotificationManager} from 'react-notifications';

class CartStore {
  constructor() {
    extendObservable(this, {
      items: []
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
}

export default new CartStore();
