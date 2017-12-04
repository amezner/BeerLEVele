import React, { Component } from 'react';
import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';
import {post, get, put} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import {withRouter} from 'react-router-dom';

class Productform extends Component {
  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      product: {}
    }
  }

  async handleSubmit(e) {
    e.preventDefault();
    const {name, description, type, purchaseprice, sellingprice, onstockquantity, alcoholcontent, bottlesize, button} = this.refs;

    if (!button.disabled) {
      button.setDisabled(true);
      const data = {
        name: name.value,
        description: description.value,
        type: type.value,
        purchaseprice: purchaseprice.value,
        sellingprice: sellingprice.value,
        onstockquantity:onstockquantity.value,
        alcoholcontent:alcoholcontent.value,
        bottlesize:bottlesize.value
      }

      try {
        const id = this.state.product.id;
        if (id) {
          const resp = await put('stock/editstock/'+id, data);
        } else {
          const resp = await post('stock/savestock', data);
        }
        NotificationManager.success('', 'Sikeres mentés!', 3000);
        this.props.history.push('/productlist');
      } catch (e) {
        const message = e.message != null ? e.message : 'Ismeretlen hiba';
        NotificationManager.error(message, 'Sikertelen mentés!', 3000);
        button.setDisabled(false);
      }
    }
  }

  componentDidMount() {
    let productId = this.props.match.params.id;
    if (productId) {
      this.loadProduct(productId).then((resp) => {
        this.setState({'product':resp});
      });
    }
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (this.props.match.params.id !== nextProps.match.params.id) {
      this.setState({product:{}});
    }

    return true;
  }

  async loadProduct(productId) {
    try {
      const resp = await get('stock/getstock/'+productId);
      return resp;
    } catch (e) {
      NotificationManager.error(e.message);
    }
  }

  render() {
    const {name, description, type, alcoholcontent, bottlesize, purchaseprice, sellingprice, onstockquantity} = this.state.product;
    return (
      <div className="content-width thin">
        <section className="content-section">
          <h1>{!name ? 'Termék hozzáadása' : 'Termék módosítása'}</h1>
          <form onSubmit={this.handleSubmit}>
            <FormRow label="Termék név" id="name">
              <Field ref="name" value={name} type="text" id="name" />
            </FormRow>
            <FormRow label="Leírás" id="description">
              <Field ref="description" value={description} type="text" id="description" />
            </FormRow>
            <FormRow label="Típus" id="type">
              <Field ref="type" value={type} type="text" id="type" />
            </FormRow>
            <div className="half-content-outer">
              <FormRow extraClass="half" label="Alkoholfok (%)" id="content">
                <Field ref="alcoholcontent" value={alcoholcontent} type="text" id="content" />
              </FormRow>
              <FormRow extraClass="half" label="Kiszerelés (l)" id="size">
                <Field ref="bottlesize" type="text" value={bottlesize} id="size" />
              </FormRow>
              <div className="clear"></div>
            </div>
            <div className="price-row">
              <FormRow extraClass="half" label="Beszerzési ár (Ft)" id="price">
                <Field ref="purchaseprice" value={purchaseprice} type="text" id="price" />
              </FormRow>
              <FormRow extraClass="half" label="Eladási ár (Ft)" id="sell-price">
                <Field ref="sellingprice" value={sellingprice} type="text" id="sell-price" />
              </FormRow>
              <div className="clear"></div>
            </div>
            <FormRow label="Készlet (db)" id="quantity">
              <Field ref="onstockquantity" value={onstockquantity} type="text" id="quantity" />
            </FormRow>
            <FormRow extraClass="button-row">
              <Button text="mentés" type="submit" ref="button" />
            </FormRow>
          </form>
        </section>
      </div>
    );
  }
}

export default withRouter(Productform);
