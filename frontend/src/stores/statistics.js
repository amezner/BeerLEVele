import { extendObservable } from "mobx";
import { NotificationManager } from "react-notifications";
import { get } from '../lib/client';


class Statistics {
  constructor() {
    extendObservable(this, {
      profits: [],
      permonth: [],
      perstock: []
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

  setPerStock(perstock) {
    this.perstock = perstock;
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

  resetStatistics() {
    this.profits = [];
    this.permonth = [];
    this.perstock = [];
  }
}

export default new Statistics();
