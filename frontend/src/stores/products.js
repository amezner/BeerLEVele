import {extendObservable} from 'mobx';
import {get} from '../lib/client';
import {NotificationManager} from 'react-notifications';

class ProductsStore {
  constructor() {
    extendObservable(this, {
      'products': []
    });
  }

  setProducts(products) {
    this.products = products;
  }

  getProduct(id) {
    return this.products.length > 0 ? this.products.find((item) => item.id === id) : null;
  }

  getProducts() {
    return this.products;
  }

  deleteProduct(id) {
    this.products = this.products.filter((product) => product.id !== id);
  }

  async loadData() {
    try {
      let resp = await get('stock/getallstock');
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }
      this.setProducts(resp);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message);
    }
  }
}

export default new ProductsStore();
