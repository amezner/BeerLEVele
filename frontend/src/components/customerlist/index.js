import React, {Component} from 'react';
import {NotificationManager} from 'react-notifications';
import {get} from '../../lib/client';
import PropTypes from 'prop-types';
import Table from '../table';

class CustomerList extends Component {
  static defaultProps = {
    tableFields: [{
        label: 'Név',
        field: 'name',
        key: 'name'
      }, {
        label: 'E-mail',
        field: 'email',
        key: 'email'
      }, {
        label: 'Telefonszám',
        field: 'phone',
        key: 'phone'
      }, {
        label: '',
        key:'features',
        features: {
          edit: {
            title: 'Módosítás',
            link: '/customerform/{id}',
            icon: 'edit.png'
          }
        }
      }]
  };

  static propTypes = {
    tableFields: PropTypes.array
  };


  constructor(props) {
    super(props);

    this.state = {
      customers: []
    }
  }

  componentDidMount() {
    this.loadCustomers().then((resp) => {
      this.setState({customers: resp});
    });
  }

  async loadCustomers() {
    try {
      let resp = await get('customer/getallcustomer');
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }
      return resp;
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message);
    }
  }

  render () {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Vásárlók</h1>
          <Table fields={this.props.tableFields} datas={this.state.customers} />
        </section>
      </div>
    );
  }
}

export default CustomerList;
