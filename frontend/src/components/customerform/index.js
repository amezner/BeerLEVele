import React, { Component } from 'react';

import Field from '../field';
import Button from '../button';

class Customerform extends Component {
  render() {
    return (
      <div className="customer-form">
        <div class="form-row">
          <Field type="text" placeholder="név" name="name" />
        </div>
        <div class="form-row">
          <Field type="text" placeholder="cím" name="address" />
        </div>
        <div class="form-row">
          <Field type="text" placeholder="telefonszám" name="phone" />
        </div>
        <div class="form-row">
          <Field type="text" placeholder="partnerszám" name="loyaltycard" />
        </div>
        <div class="form-row">
          Kedvezmény mértéke
        </div>
        <div class="form-row">
          <Button text="mentés" />
        </div>
      </div>
    );
  }
}

export default Customerform;
