import React, {Component} from 'react';
import ProductsStore from '../../stores/products';
import {observer} from 'mobx-react';
import {Link} from 'react-router-dom';
import {del, post} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import CartStore from '../../stores/cart';
import AuthStore from '../../stores/authorization';
import NumberFormat from 'react-number-format';
import Edit from 'react-icons/lib/md/edit';
import Delete from 'react-icons/lib/md/delete';
import AddToCart from 'react-icons/lib/md/shopping-cart';


class ProductRow extends Component {
  constructor (props) {
    super(props);

    this.handleClick = this.handleClick.bind(this);
    this.addToCart = this.addToCart.bind(this);
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

  async addToCart() {
    const {id, name} = this.props.data;

    const item = CartStore.getItem(id);

    const quantity = item ? (item.quantity + 1) : 1;
    try {
      if (quantity > 1) {
        CartStore.modifyItem(id, quantity);
      } else {
        CartStore.addItem(id, quantity);
      }

      const resp = await post('order/putinthecart', {
        stock_id: id,
        quantity: quantity
      });

      NotificationManager.success('Az alábbi terméket hozzáadta a kosárhoz: '+name, 'Sikeres művelet!', 3000);

    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen kosárba rakás!', 3000);
    }
  }

  render() {
    const {id,name, purchaseprice, sellingprice, onstockquantity} = this.props.data;
    return (
      <div className="table-row data-row">
        <div className="table-cell">
          <Link to={`/productform/${id}`}>{name}</Link>
        </div>
        <div className="table-cell number-cell">
          <NumberFormat value={purchaseprice} decimalSeparator="," thousandSeparator="." decimalScale={2} fixedDecimalScale={true} displayType="text" suffix=" Ft" />
        </div>
        <div className="table-cell number-cell">
          <NumberFormat value={sellingprice} decimalSeparator="," thousandSeparator="." decimalScale={2} fixedDecimalScale={true} displayType="text" suffix=" Ft" />
        </div>
        <div className="table-cell number-cell">
          <NumberFormat value={onstockquantity} decimalSeparator="," thousandSeparator="." decimalScale={2} displayType="text" suffix=" db" />
        </div>
        <div className="table-cell feature-cell">
          <div className="features-content">
            <Link className="feature-item" to={`/productform/${id}`}>
              <Edit />
            </Link>
            {
              AuthStore.hasPermission('cart') ?
              (<span className="feature-item" onClick={this.addToCart}>
                <AddToCart />
              </span>) : null
            }
            <span className="feature-item" onClick={this.handleClick}>
              <Delete />
            </span>
          </div>
        </div>
      </div>
    )
  }
}

export default observer(ProductRow);
