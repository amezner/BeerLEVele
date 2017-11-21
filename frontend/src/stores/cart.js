import {extendObservable} from 'mobx';

class Cart {
  constructor() {
    extendObservable(this, {
      items: []
    });

    addItem(stockid, soldquantity, soldprice) {
      this.items.push({stockid, soldquantity, soldprice});
    }

    setItems(items) {
      this.items = items;
    }

    getProductIds() {
      return this.items.map((item) => {
        return item.stockid;
      });
    }

    removeItem(id) {
      this.items = this.items.filter((item) => item.stockid !== id);
    }

  }
}

export default new Cart();
