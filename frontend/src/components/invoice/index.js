import React, {Component} from 'react';
import {observer} from 'mobx-react';
import PropTypes from 'prop-types';
import FormRow from '../formrow';
import Table from '../table';
import InvoicedProductRow from '../invoicedproductrow';
import InvoiceStore from '../../stores/invoices';
import NumberFormat from 'react-number-format';
import AuthStore from '../../stores/authorization';

import './invoice.css';
import { NotificationManager } from 'react-notifications';

class Invoice extends Component {
  static defaultProps = {
    tableFields: ['Termék neve', 'Mennyiség', 'Eladási ár', 'Részösszeg']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    if (this.checkUserPermission()) {
      const invoiceId = this.props.match.params.id;
      if (invoiceId) {
        InvoiceStore.loadInvoice(invoiceId);
      }
    }
  }

  checkUserPermission() {
    if (!AuthStore.hasPermission('viewinvoice')) {
      NotificationManager.warning('Ehhez a modulhoz nincs joga!', 'Hoppá');
      this.props.history.push('/invoicelist')
      return false;
    }
    return true;
  }

  render() {
    const invoice = InvoiceStore.getInvoice();
    const {name, email, phone, country, postalcode, address, city, discount, invoicedproducts, date} = invoice;
    const total = InvoiceStore.getInvoiceTotal();

    const dateString = new Date(date).toLocaleString('hu-HU');

    return (
      <div className="content-width thin invoice-page">
        <h1>Számla megtekintése</h1>
        <section className="content-section">
          <div className="customer-content">
            <h3>Vásárló adatai</h3>
            <FormRow label="Vásáló neve">
              {name}
            </FormRow>
            <FormRow label="Telefonszám">
              {phone}
            </FormRow>
            <FormRow label="E-mail cím">
              {email}
            </FormRow>
            <FormRow label="Ország">
              {country}
            </FormRow>
            <div className="address-row">
              <FormRow label="Irszám." extraClass="zip-row">
                {postalcode}
              </FormRow>
              <FormRow label="Település">
                {city}
              </FormRow>
              <div className="clear"></div>
            </div>
            <FormRow label="Utca, házszám">
              {address}
            </FormRow>
            {
              (
                discount > 0 ? <FormRow label="Kedvezmény">{`${discount} %`}</FormRow> : null
              )
            }
          </div>
        </section>

        <section className="content-section">
          <div>
            <FormRow label="Számla kelte" extraClass="half">
              {dateString}
            </FormRow>
            <FormRow label="Számlaszám" extraClass="half">
              {InvoiceStore.createInvoiceNumber(invoice)}
            </FormRow>
            <div className="clear"></div>
          </div>
          <h3>Termékek</h3>
          <Table fields={this.props.tableFields} rowClass={InvoicedProductRow} datas={invoicedproducts}>
            {
              total > 0 ? (
                <div className="table-row total-row header-row">
                  <div className="table-cell text-cell">Összesen</div>
                  <div className="table-cell"></div>
                  <div className="table-cell"></div>
                  <div className="table-cell number-cell">
                    <NumberFormat decimalSeparator="," thousandSeparator="." value={total} fixedDecimalScale={true} decimalScale={2} displayType="text" suffix=" Ft" />
                  </div>
                </div>
              ) : null
            }
          </Table>
        </section>
      </div>
    )
  }
}

export default observer(Invoice);
