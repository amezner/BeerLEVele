import React, {Component} from 'react';
import {observer} from 'mobx-react';
import PropTypes from 'prop-types';
import FormRow from '../formrow';
import Table from '../table';
import InvoicedProductRow from '../invoicedproductrow';
import InvoiceStore from '../../stores/invoices';
import NumberFormat from 'react-number-format';

import './invoice.css';

class Invoice extends Component {
  static defaultProps = {
    tableFields: ['Termék neve', 'Mennyiség', 'Eladási ár']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    const invoiceId = this.props.match.params.id;
    if (invoiceId) {
      InvoiceStore.loadInvoice(invoiceId);
    }
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
          <FormRow label="Számla kelte">
            {dateString}
          </FormRow>
          <h3>Termékek</h3>
          <Table fields={this.props.tableFields} rowClass={InvoicedProductRow} datas={invoicedproducts}>
            {
              total > 0 ? (
                <div className="table-row total-row header-row">
                  <div className="table-cell">Összesen</div>
                  <div className="table-cell"></div>
                  <div className="table-cell number-cell">
                    <NumberFormat decimalSeparator="," thousandSeparator="." value={total}  decimalScale={2} displayType="text" suffix=" Ft" />
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
