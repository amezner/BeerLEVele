import React, {Component} from 'react';

class InvoiceRow extends Component {
  render() {
    return (
      <div className="table-row data-row">
        <div className="table-cell">Néve</div>
        <div className="table-cell">ideje</div>
        <div className="table-cell">össezeg</div>
        <div className="table-cell">
          <div className="features-content">
            <span className="feature-item">Megtekint</span>
          </div>
        </div>
      </div>
    )
  }
}

export default InvoiceRow;
