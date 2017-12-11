import React, {Component} from 'react';
import {observer} from 'mobx-react';
import CartStore from '../../stores/cart';
import Field from '../field';
import {del, post} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import NumberFormat from 'react-number-format';


class CartRow extends Component {
  constructor(props) {
    super(props);

    this.removeFromCart = this.removeFromCart.bind(this);
    this.modifyQuantity = this.modifyQuantity.bind(this);
  }

  async removeFromCart() {
    const {stockId} = this.props.data;

    if (stockId) {
      try {
        const resp = await del('order/deleteitemfromcart/'+stockId);
        CartStore.removeItem(stockId);
        NotificationManager.success('A terméket eltávolítottuk a kosárból', '', 3000);
      } catch (e) {
        const message = e.message ? e.message : 'Ismeretlen hiba';
        NotificationManager.error(message, 'Sikertelen művelet!', 3000);
      }
    }
  }

  async modifyQuantity() {
    const {quantity} = this.refs;
    const {stockId} = this.props.data;

    const item = CartStore.getItem(stockId);
    if (item) {
      try {
        const resp = await post('order/putinthecart', {
          stock_id: stockId,
          quantity: quantity.value
        });
        CartStore.modifyItem(stockId, quantity.value);
        NotificationManager.success('Mennyiség módosítva', '', 3000);
      } catch (e) {
        const message = e.message ? e.message : 'Ismeretlen hiba';
        NotificationManager.error(message, 'Sikertelen művelet!', 3000);
      }
    }

  }

  render() {
    const {data} = this.props;
    const product = CartStore.productStore.getProduct(data.stockId);
    let id = product ? product.id : null;
    let name = product ? product.name : null;
    let price = product ? product.sellingprice : 0;
    let multiplier = 1;
    const customerId = CartStore.getCustomerId();

    if (customerId) {
      const customer = CartStore.customerStore.getCustomer(parseInt(customerId));
      if (customer) {
        multiplier = 1 - (customer.discount / 100);
      }
    }

    return (
      <div className="table-row data-row">
        <div className="table-cell">{name}</div>
        <div className="table-cell">
          <Field ref="quantity" value={data.quantity} changeEvt={this.modifyQuantity} extraClass="quantity-field"  />
        </div>
        <div className="table-cell number-cell">
          <NumberFormat decimalSeparator="," thousandSeparator="." value={price} displayType="text" suffix=" Ft" decimalScale={2} />
        </div>
        <div className="table-cell number-cell">
          <NumberFormat decimalSeparator="," thousandSeparator="." value={(price * multiplier)} displayType="text" suffix=" Ft" decimalScale={2} />
        </div>
        <div className="table-cell number-cell">
          <NumberFormat decimalSeparator="," thousandSeparator="." value={(price * multiplier * data.quantity)} decimalScale={2} displayType="text" suffix=" Ft" />
        </div>
        <div className="table-cell">
          <div className="features-content">
            <span className="feature-item" onClick={this.removeFromCart}>töröl</span>
          </div>
        </div>
      </div>
    );
  }
}

export default observer(CartRow);
