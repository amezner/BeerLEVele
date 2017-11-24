import React, {Component} from 'react';
import {observer} from 'mobx-react';
import PropTypes from 'prop-types';
import InvoiceStore from '../../stores/invoices';
import Table from '../table';
import InvoiceRow from '../invoicerow';

class InvoiceList extends Component {
  static defaultProps = {
    tableFields: ['Vásárló neve', 'Kiállítás dátuma', '']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    InvoiceStore.loadData();
  }

  render() {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Számlák</h1>
          <Table fields={this.props.tableFields} datas={InvoiceStore.getInvoices()} rowClass={InvoiceRow} />
        </section>
      </div>
    )
  }
}

export default observer(InvoiceList);
