import React, {Component} from 'react';
import {post, get, put} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import {withRouter} from 'react-router-dom';

import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';

class Customerform extends Component {
  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);

    this.state = {
      customer: {}
    };
  }

  async handleSubmit(e) {
    e.preventDefault();
    const {
      name,
      address,
      loyalty,
      phone,
      email,
      city,
      country,
      zip,
      discount
    } = this.refs;

    const data = {
      name: name.value,
      email: email.value,
      address: address.value,
      loyaltycard: loyalty.value,
      phone: phone.value,
      discount: discount.value,
      postalcode: zip.value,
      country: country.value,
      city: city.value
    };

    try {
      const id = this.state.customer.id;
      if (id) {
        const response = await put('customer/editcustomer/'+id, data);
      } else {
        const response = await post('customer/savecustomer', data);
      }

      NotificationManager.success('', 'Sikeres mentés!', 3000);
      this.props.history.push('/customerlist');
    } catch (e) {
      const message = e.message != null
        ? e.message
        : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen mentés!', 3000);
    }
  }

  componentDidMount() {
    let customerId = this.props.match.params.id;
    if (customerId) {
      this.loadCustomer(customerId).then((resp) => {
        this.setState({'customer':resp});
      });
    }
  }

  async loadCustomer(customerId) {
    try {
      const resp = await get('customer/getcustomer/'+customerId);
      return resp;
    } catch (e) {
      NotificationManager.error(e.message);
    }
  }

  render() {
    const {name, email, phone, country, postalcode, address, city, loyaltycard, discount} = this.state.customer;

    return (<div className="customer-form content-width thin">
      <section className="content-section">
        <h1>{name ? 'Vásárló módosítása' : 'Vásárló hozzáadása'}</h1>
        <form onSubmit={this.handleSubmit}>
          <FormRow label="Név" id="name">
            <Field ref="name" value={name} type="text" id="name" name="name"/>
          </FormRow>
          <FormRow label="Telefonszám" id="phone">
            <Field ref="phone" value={phone} type="text" id="phone" name="phone"/>
          </FormRow>
          <FormRow label="E-mail cím" id="email">
            <Field ref="email" value={email} type="text" id="email" name="email"/>
          </FormRow>
          <FormRow extraClass="country-row" id="country" label="Ország">
            <Field ref="country" value={country} type="text" id="country" name="country"/>
          </FormRow>
          <div className="address-row">
            <FormRow extraClass="zip-row" label="Irszám." id="zip">
              <Field ref="zip" type="text" value={postalcode} id="zip" name="postalcode"/>
            </FormRow>
            <FormRow extraClass="city-row" label="Város" id="city">
              <Field ref="city" type="text" value={city} id="city" name="city"/>
            </FormRow>
            <div className="clear"></div>
          </div>
          <FormRow extraClass="address-row" label="Utca, házszám" id="address">
            <Field ref="address" type="text" value={address} id="address" name="address"/>
          </FormRow>
          <FormRow label="Partnerszám" id="parnter">
            <Field ref="loyalty" type="text" value={loyaltycard} id="partner" name="loyalty"/>
          </FormRow>
          <FormRow label="Kedvezmény mértéke" id="discount">
            <Field ref="discount" type="text" value={discount} id="discount" name="discount" />
          </FormRow>
          <FormRow extraClass="button-row">
            <Button text="mentés" type="submit"/>
          </FormRow>
        </form>
      </section>
    </div>);
  }
}

export default withRouter(Customerform);
