import React, { Component } from 'react';
import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';
import {post} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import {withRouter} from 'react-router-dom';

class Productform extends Component {
  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit(e) {
    e.preventDefault();
    const {name, description, type, purchaseprice, sellingprice, onstockquantity, alcoholcontent, bottlesize} = this.refs;

    const data = {
      name: name.value,
      description: description.value,
      type: type.value,
      purcahaseprice: purchaseprice.value,
      sellingprice: sellingprice.value,
      onstockquantity:onstockquantity.value,
      alcoholcontent:alcoholcontent.value,
      bottlesize:bottlesize.value
    }

    try {
      const resp = await post('stock/savestock', data);
      NotificationManager.success('', 'Sikeres mentés!', 3000);
      this.props.history.push('/productlist');
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
            <div className="half-content-outer">
              <FormRow extraClass="half">
                <Field ref="alcoholcontent" type="text" placeholder="alkoholtartalom" />
              </FormRow>
              <FormRow extraClass="half">
                <Field ref="bottlesize" type="text" placeholder="kiszerelés (literben)" />
              </FormRow>
              <div className="clear"></div>
            </div>
            <div className="price-row">
              <FormRow extraClass="half">
                <Field ref="purchaseprice" type="text" placeholder="beszerzési ár" />
              </FormRow>
              <FormRow extraClass="half">
                <Field ref="sellingprice" type="text" placeholder="eladási ár" />
              </FormRow>
              <div className="clear"></div>
            </div>
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

export default withRouter(Productform);
