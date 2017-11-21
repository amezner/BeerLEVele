import React, {Component} from 'react';
import {observer} from 'mobx-react';
import PropTypes from 'prop-types';
import InvoiceStore from '../../stores/invoices';

class InvoiceList extends Component {
  static defaultProps = {
    tableFields: ['Vásárló', 'Kiállítás dátuma', 'Összeg', '']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    InvoiceStore.loadData();
  }

  render() {
    console.log(InvoiceStore.getInvoices());

    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Számlák</h1>
        </section>
      </div>
    )
  }
}

export default observer(InvoiceList);
