import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import NumberFormat from 'react-number-format';

class ProfitRow extends Component {
  render() {
    const {invoicenumber, name, profit} = this.props.data;

    return (
      <div className="table-row data-row">
        <div className="table-cell">
          <Link to={`/invoice/${invoicenumber}`}>{invoicenumber}</Link>
        </div>
        <div className="table-cell">{name}</div>
        <div className="table-cell number-cell">
        <NumberFormat decimalSeparator="," thousandSeparator="." value={profit} fixedDecimalScale={true} displayType="text" suffix=" Ft" decimalScale={2} />
        </div>
      </div>
    );
  }
}

export default ProfitRow;
