import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class InvoiceRow extends Component {
  render() {
    const {invoicenumber, name, date} = this.props.data;

    let dateString = new Date(date).toLocaleString('hu-HU');

    return (
      <div className="table-row data-row">
        <div className="table-cell">
          <Link to={`/invoice/${invoicenumber}`}>
            {name}
          </Link>
        </div>
        <div className="table-cell">{dateString}</div>
        <div className="table-cell">
          <div className="features-content">
            <Link to={`/invoice/${invoicenumber}`} className="feature-item">Megtekint</Link>
          </div>
        </div>
      </div>
    )
  }
}

export default InvoiceRow;
