import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import Visibility from 'react-icons/lib/md/visibility';

class InvoiceRow extends Component {
  constructor(props) {
    super(props);

    this.createInvoiceNumber = this.createInvoiceNumber.bind(this);
  }

  createInvoiceNumber() {
    const {date, invoicenumber} = this.props.data;
    let result = new String(invoicenumber);
    
    if (result.length < 6) {
      const max = (6 - result.length);
      for (var i = 0; i < max; i++) {
        result = "0"+result;
      }
    }
    const year = new Date(date).getFullYear();

    return `${year}/${result}`;
  }

  render() {
    const {invoicenumber, name, date} = this.props.data;

    const dateString = new Date(date).toLocaleString('hu-HU');

    return (
      <div className="table-row data-row">
        <div className="table-cell">
          <Link to={`/invoice/${invoicenumber}`}>
            {this.createInvoiceNumber()}
          </Link>
        </div>
        <div className="table-cell">
          <Link to={`/invoice/${invoicenumber}`}>
            {name}
          </Link>
        </div>
        <div className="table-cell">{dateString}</div>
        <div className="table-cell feature-cell">
          <div className="features-content">
            <Link to={`/invoice/${invoicenumber}`} className="feature-item">
              <Visibility />
            </Link>
          </div>
        </div>
      </div>
    )
  }
}

export default InvoiceRow;
