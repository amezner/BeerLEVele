import React, {Component} from 'react';
import {observer} from 'mobx-react';
import CartStore from '../../stores/cart';
import Table from '../table';
import CartRow from '../cartrow';
import PropTypes from 'prop-types';
import Button from '../button';
import DropDown from '../dropdown';
import FormRow from '../formrow';
import {post, del} from '../../lib/client';
import {NotificationManager} from 'react-notifications';

import './cart.css';


class Cart extends Component {
  static defaultProps = {
    tableFields: ['Termék', 'Mennyiség', 'Alapár','Eladási ár', 'Részösszeg', '']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);
    this.addToCart = this.addToCart.bind(this);
    this.deleteCart = this.deleteCart.bind(this);
    this.changeCustomer = this.changeCustomer.bind(this);
  }

  componentDidMount() {
    CartStore.loadResources();
  }

  async handleSubmit(evt) {
    evt.preventDefault();
    NotificationManager.info('Ez a funkció még nincs implementálva', 'Számla kiállítása!', 3000);
  }

  async addToCart() {
    const {productField} = this.refs;
    const stockId = parseInt(productField.value);
    const item = CartStore.getItem(stockId);

    if (!item) {
      try {
        const product = CartStore.productStore.getProduct(stockId);
        const resp = await post('order/putinthecart', {
          stock_id: stockId,
          quantity: 1
        });
        CartStore.addItem(stockId, 1);

        NotificationManager.success('Az alábbi terméket hozzáadta a kosárhoz: '+product.name, 'Sikeres művelet!', 3000);
      } catch (e) {
        const message = e.message ? e.message : 'Ismeretlen hiba';
        NotificationManager.error(message, 'Sikertelen kosárba rakás!', 3000);
      }
    }
  }

  async deleteCart() {
    try {
      const resp = await del('order/emptycart');

      CartStore.resetCart();
      NotificationManager.success('A kosarat kiürítettük', '', 3000);

    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikeretelen kosár ürítés', 3000);
    }
  }

  changeCustomer(customerId) {
    CartStore.setCustomerId(customerId);
  }

  render() {
    let customerOptions = {0: "Kérem válasszon vásárlót"};
    const customers = CartStore.customerStore.getCustomers();
    if (customers) {
      if (customers.length > 0) {
        customers.map((customer) => {
          customerOptions[customer.id] = customer.name;
        });
      }
    }


    let productOptions = {0: "Kérem válasszon terméket"};
    const stockInCart = CartStore.getProductIds();

    const products = CartStore.productStore.getProducts();
    if (products) {
      if (products.length > 0) {
        products.map((product) => {
          if (!stockInCart || (stockInCart && !stockInCart.includes(product.id))) {
            productOptions[product.id] = product.name;
          }
        });
      }
    }

    const isEmpty = CartStore.getItems().length == 0;
    return (
      <div className="content-width thin cart-page">
        <form onSubmit={this.handleSubmit}>
          <section className="content-section">
            <h1>Számla létrehozása</h1>
            <FormRow label="Vásárló kiválasztása" id="customer" extraClass="customer-content">
              <DropDown ref="customerField" options={customerOptions} id="customer" changeEvt={this.changeCustomer} />
            </FormRow>
            <div className="product-content">
              <FormRow label="Termék hozzáadása a kosárhoz" id="product" extraClass="half">
                  <DropDown ref="productField" options={productOptions} id="product" />
              </FormRow>
              <FormRow extraClass="button-row half">
                <Button text="hozzáadás" type="button" clickEvt={this.addToCart} />
              </FormRow>
              <div className="clear"></div>
            </div>
            {
            (!isEmpty ?
              <FormRow extraClass="cart-content">
                <h3>Kosár tartalma</h3>
                <Table datas={CartStore.getItems()} fields={this.props.tableFields} rowClass={CartRow} />
              </FormRow>
              : null)
            }
          </section>
          <section className="content-section buttons-content">
            {
              (!isEmpty ?
              <Button text="elvetés" type="button" extraClass="secondary" clickEvt={this.deleteCart} />
              : null)
            }
            <Button text="lezárás" type="submit" extraClass="primary"  />
          </section>
        </form>
      </div>
    )
  }
}

export default observer(Cart);
