import React, { Component } from 'react';
import {post} from '../../lib/client';

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
    const response = await post('Customer/SaveCustomer', data);

    console.log(response);
  }

  render() {
    return (
      <div className="customer-form content-width">
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
            Kedvezmény mértéke
          </FormRow>
          <FormRow>
            <Button text="mentés" type="submit" />
          </FormRow>
        </form>
      </div>
    );
  }
}

export default Customerform;
