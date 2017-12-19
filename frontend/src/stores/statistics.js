import { extendObservable } from "mobx";
import { NotificationManager } from "react-notifications";
import { get } from '../lib/client';


class Statistics {
  constructor() {
    extendObservable(this, {
      profits: [],
      permonth: [],
      perstock: [],
    });
  }

  setProfits(profits) {
    this.profits = profits;
  }

  getProfits() {
    return this.profits;
  }

  setPerMonth(permonth) {
    this.permonth = permonth;
  }

  getPerMonth() {
    return this.permonth;
  }

  setPerStock(perstock) {
    this.perstock = perstock;
  }

  getPerStock() {
    return this.perstock;
  }

  async loadProfit() {
    try {
      let resp = await get('invoice/profitperinvoice');
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }

      this.setProfits(resp);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen művelet!', 3000);
    }
  }

  async loadPerMonth() {
    try {
      let resp = await get('invoice/stockconsumptionpermonth');
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }
      console.log(resp);
      this.setPerMonth(resp);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen művelet!', 3000);
    }
  }

  async loadPerStock(productId) {
    try {
      let resp = await get('invoice/stockconsumptionperstock/'+productId);
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }
      
      this.setPerStock(resp);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen művelet!', 3000);
    }
  }

  resetStatistics() {
    this.profits = [];
    this.permonth = [];
    this.perstock = [];
  }
}

export default new Statistics();
