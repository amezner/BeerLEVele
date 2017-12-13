import {extendObservable} from 'mobx';
import {get} from '../lib/client';
import {NotificationManager} from 'react-notifications';

class InvoiceStore {
  constructor() {
    extendObservable(this, {
      invoices: [],
      invoice: {}
    });
  }

  setInvoices (invoices) {
    this.invoices = invoices;
  }

  getInvoices () {
    return this.invoices;
  }

  setInvoice(invoice) {
    this.invoice = invoice;
  }

  getInvoice() {
    return this.invoice;
  }

  getInvoiceTotal() {
    let total = 0;
    if (typeof this.invoice.invoicedproducts !== 'undefined') {
      this.invoice.invoicedproducts.map((row) => { total += row.soldprice * row.soldquantity });
    }

    return total;
  }

  async loadInvoice(invoiceId) {
    try {
      const resp = await get('invoice/getinvoice/'+invoiceId);

      this.setInvoice(resp);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message);
    }
  }

  async loadData() {
    try {
      let resp = await get('invoice/getallinvoices');
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }

      this.setInvoices(resp);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message);
    }
  }
}

export default new InvoiceStore;
