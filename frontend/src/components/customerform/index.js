import React, { Component } from 'react';

import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';

class Customerform extends Component {
  render() {
    return (
      <div className="customer-form content-width">
        <FormRow>
          <Field type="text" placeholder="név" name="name" />
        </FormRow>
        <FormRow>
          <Field type="text" placeholder="cím" name="address" />
        </FormRow>
        <FormRow>
          <Field type="text" placeholder="telefonszám" name="phone" />
        </FormRow>
        <FormRow>
          <Field type="text" placeholder="partnerszám" name="loyaltycard" />
        </FormRow>
        <FormRow>
          Kedvezmény mértéke
        </FormRow>
        <FormRow>
          <Button text="mentés" />
        </FormRow>
      </div>
    );
  }
}

export default Customerform;
