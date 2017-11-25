import React, {Component} from 'react';
import NumberFormat from 'react-number-format';

class InvoicedProductRow extends Component {

  render() {
    const {name, soldquantity, soldprice} = this.props.data;
    return (
      <div className="table-row data-row">
        <div className="table-cell">{name}</div>
        <div className="table-cell">
          <NumberFormat decimalSeparator="," thousandSeparator="." value={soldprice} decimalScale={2} suffix=" db" />
        </div>
        <div className="table-cell">
          <NumberFormat decimalSeparator="," thousandSeparator="." value={soldprice}  decimalScale={2} displayType="text" suffix=" Ft" />
        </div>
      </div>
    )
  }
}

export default InvoicedProductRow;
