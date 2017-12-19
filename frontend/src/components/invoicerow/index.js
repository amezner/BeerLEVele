import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import Visibility from 'react-icons/lib/md/visibility';
import AuthStore from '../../stores/authorization';
import InvoiceStore from '../../stores/invoices';

class InvoiceRow extends Component {
  render() {
    const {invoicenumber, name, date} = this.props.data;

    const dateString = new Date(date).toLocaleString('hu-HU');
    const invoiceNumberString = InvoiceStore.createInvoiceNumber(this.props.data);
    return (
      <div className="table-row data-row">
        <div className="table-cell">
          {
            AuthStore.hasPermission('viewinvoice') ? 
            (<Link to={`/invoice/${invoicenumber}`}>
              {invoiceNumberString}
            </Link>) : invoiceNumberString
          }
        </div>
        <div className="table-cell">
          {
            AuthStore.hasPermission('viewinvoice') ? 
            (<Link to={`/invoice/${invoicenumber}`}>
              {name}
            </Link>) : name
          }
        </div>
        <div className="table-cell">{dateString}</div>
        {
          AuthStore.hasPermission('viewinvoice') ? 
          (<div className="table-cell feature-cell">
            <div className="features-content">
              <Link to={`/invoice/${invoicenumber}`} className="feature-item">
                <Visibility />
              </Link>
            </div>
          </div>) : null
        }
      </div>
    )
  }
}

export default InvoiceRow;
