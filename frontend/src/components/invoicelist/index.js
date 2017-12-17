import React, {Component} from 'react';
import {observer} from 'mobx-react';
import PropTypes from 'prop-types';
import InvoiceStore from '../../stores/invoices';
import AuthStore from '../../stores/authorization';
import {NotificationManager} from 'react-notifications';
import Table from '../table';
import InvoiceRow from '../invoicerow';


class InvoiceList extends Component {
  static defaultProps = {
    tableFields: ['Számlaszám', 'Vásárló neve', 'Kiállítás dátuma', '']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    if (AuthStore.hasPermission('invoicelist')) {
      InvoiceStore.loadData();
    } else {
      NotificationManager.warning('Ehhez modulhoz nincs joga!', 'Hoppá!');
      this.props.history.push('/productlist');
    }
  }

  render() {
    let {tableFields} = this.props;
    if (!AuthStore.hasPermission('viewinvoice')) {
      tableFields = ['Számlaszám', 'Vásárló neve', 'Kiállítás dátuma'];
    }
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Számlák</h1>
          <Table fields={tableFields} datas={InvoiceStore.getInvoices()} rowClass={InvoiceRow} />
        </section>
      </div>
    )
  }
}

export default observer(InvoiceList);
