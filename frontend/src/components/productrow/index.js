import React, {Component} from 'react';
import ProductsStore from '../../stores/products';
import {observer} from 'mobx-react';
import {Link} from 'react-router-dom';
import {del} from '../../lib/client';
import {NotificationManager} from 'react-notifications';

class ProductRow extends Component {
  constructor (props) {
    super(props);

    this.handleClick = this.handleClick.bind(this);
  }

  async handleClick() {
    const {id} = this.props.data;

    try {
      const resp = await del('stock/deletestock/'+id);

      ProductsStore.deleteProduct(id);
      NotificationManager.success('', 'Sikeres törlés!', 3000);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen törlés', 3000);
    }
  }

  render() {
    const {id,name, purchaseprice, sellingprice, onstockquantity} = this.props.data;
    return (
      <div className="table-row data-row">
        <div className="table-cell">{name}</div>
        <div className="table-cell">{purchaseprice}</div>
        <div className="table-cell">{sellingprice}</div>
        <div className="table-cell">{onstockquantity}</div>
        <div className="table-cell">
          <div className="features-content">
            <Link className="feature-item" to={`/productform/${id}`}>Módosítás</Link>
            <span className="feature-item" onClick={this.handleClick}>Törlés</span>
          </div>
        </div>
      </div>
    )
  }
}

export default observer(ProductRow);
