import React, {Component} from 'react';
import CustomersStore from '../../stores/customers';
import {observer} from 'mobx-react';
import {Link} from 'react-router-dom';
import {del} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import NumberFormat from 'react-number-format';
import Edit from 'react-icons/lib/md/edit';
import Delete from 'react-icons/lib/md/delete';

class CustomerRow extends Component {
  constructor (props) {
    super(props);

    this.handleClick = this.handleClick.bind(this);
  }

  async handleClick() {
    const {id} = this.props.data;

    try {
      const resp = await del('customer/deletecustomer/'+id);

      CustomersStore.deleteCustomer(id);
      NotificationManager.success('', 'Sikeres törlés!', 3000);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message, 'Sikertelen törlés', 3000);
    }
  }

  render() {
    const {id,name, email, phone, discount} = this.props.data;
    return (
      <div className="table-row data-row">
        <div className="table-cell">
          <Link to={`/customerform/${id}`}>{name}</Link>
        </div>
        <div className="table-cell">{email}</div>
        <div className="table-cell">{phone}</div>
        <div className="table-cell number-cell">
          <NumberFormat value={discount} displayType="text" suffix="%" />
        </div>
        <div className="table-cell feature-cell">
          <div className="features-content">
            <Link className="feature-item" to={`/customerform/${id}`}>
              <Edit />
            </Link>
            <span className="feature-item" onClick={this.handleClick}>
              <Delete />
            </span>
          </div>
        </div>
      </div>
    )
  }
}

export default observer(CustomerRow);
