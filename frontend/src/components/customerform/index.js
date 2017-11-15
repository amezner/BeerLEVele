import React, { Component } from 'react';
import {post} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';

import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';
import DropDown from '../dropdown';

class Customerform extends Component {
  static defaultProps = {
    discountOptions: {
      '0': 'Kérem válasszon',
      '1': 'bronz',
      '2': 'ezüst',
      '3': 'arany'
    }
  };


  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit(e) {
    e.preventDefault();
    const {name, address, loyalty, phone, email} = this.refs;

    const data = {
      name: name.value,
      email: email.value,
      address: address.value,
      loyaltycard: loyalty.value,
      phone: phone.value,
      discount: 0
    };
    console.log(data);
    try {
      const response = await post('customer/savecustomer', data);

      NotificationManager.info('Érkezett válasz');
    } catch (e) {
      NotificationManager.error(e.message, 'Sikertelen mentés!', 3000);
    }


  }

  render() {
    const { discountOptions } = this.props;

    return (
      <div className="customer-form content-width thin">
        <section className="content-section">
          <h1>Vásárló hozzáadása</h1>
          <form onSubmit={this.handleSubmit}>
            <FormRow>
              <Field ref="name" type="text" placeholder="név" name="name" />
            </FormRow>
            <FormRow>
              <Field ref="email" type="text" placeholder="e-mail cím" name="email" />
            </FormRow>
            <FormRow>
              <Field ref="address" type="text" placeholder="cím" name="address" />
            </FormRow>
            <FormRow>
              <Field ref="phone" type="text" placeholder="telefonszám" name="phone" />
            </FormRow>
            <FormRow>
              <Field ref="loyalty" type="text" placeholder="partnerszám" name="loyalty" />
            </FormRow>
            <FormRow>
              <DropDown name="discount" label="kedvezmény mértéke" id="discount" options={discountOptions} />
            </FormRow>
            <FormRow extraClass="button-row">
              <Button text="mentés" type="submit" />
            </FormRow>
          </form>
        </section>
      </div>
    );
  }
}

export default Customerform;
