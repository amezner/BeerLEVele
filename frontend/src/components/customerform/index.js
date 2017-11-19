import React, {Component} from 'react';
import {post} from '../../lib/client';
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
      const response = await post('customer/savecustomer', data);

      NotificationManager.success('', 'Sikeres mentés!', 3000);
      this.props.history.push('/customerlist');
    } catch (e) {
      const message = e.message != null
        ? e.message
        : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen mentés!', 3000);
    }

  }

  render() {
    return (<div className="customer-form content-width thin">
      <section className="content-section">
        <h1>Vásárló hozzáadása</h1>
        <form onSubmit={this.handleSubmit}>
          <FormRow>
            <Field ref="name" type="text" placeholder="név" name="name"/>
          </FormRow>
          <FormRow>
            <Field ref="email" type="text" placeholder="e-mail cím" name="email"/>
          </FormRow>
          <FormRow extraClass="country-row">
            <Field ref="country" type="text" placeholder="ország" name="address"/>
          </FormRow>
          <div className="address-row">
            <FormRow extraClass="zip-row">
              <Field ref="zip" type="text" extraClass="z" placeholder="irszám." name="address"/>
            </FormRow>
            <FormRow extraClass="city-row">
              <Field ref="city" type="text" placeholder="város" name="address"/>
            </FormRow>
            <div className="clear"></div>
          </div>
          <FormRow extraClass="address-row">
            <Field ref="address" type="text" placeholder="utca, házszám" name="address"/>
          </FormRow>
          <FormRow>
            <Field ref="phone" type="text" placeholder="telefonszám" name="phone"/>
          </FormRow>
          <FormRow>
            <Field ref="loyalty" type="text" placeholder="partnerszám" name="loyalty"/>
          </FormRow>
          <FormRow>
            <Field ref="discount" type="text" placeholder="kedvezmény mértéke"/>
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
