import React, { Component } from 'react';
import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';
import {post} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';

class Productform extends Component {
  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit(e) {
    e.preventDefault();
    const {name, description, type, purchaseprice, sellingprice, onstockquantity} = this.refs;

    const data = {
      name: name.value,
      description: description.value,
      type: type.value,
      purchaseprice: purchaseprice.value,
      sellingprice: sellingprice.value,
      onstockquantity:onstockquantity.value
    }

    console.log(data);
    try {

      const resp = await post('stock/savestock', data);
      NotificationManager.success('', 'Sikeres mentés!', 3000);
    } catch (e) {
      const message = e.message != null ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen mentés!', 3000);
    }
  }

  render() {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Termék hozzáadása</h1>
          <form onSubmit={this.handleSubmit}>
            <FormRow>
              <Field ref="name" type="text" placeholder="termék név" />
            </FormRow>
            <FormRow>
              <Field ref="description" type="text" placeholder="termék leírás" />
            </FormRow>
            <FormRow>
              <Field ref="type" type="text" placeholder="típus" />
            </FormRow>
            <FormRow>
              <Field ref="purchaseprice" type="text" placeholder="beszerzési ár" />
            </FormRow>
            <FormRow>
              <Field ref="sellingprice" type="text" placeholder="eladási ár" />
            </FormRow>
            <FormRow>
              <Field ref="onstockquantity" type="text" placeholder="készlet" />
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

export default Productform;
