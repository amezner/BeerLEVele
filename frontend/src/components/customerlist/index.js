import React, {Component} from 'react';
import {get} from '../../lib/client';
import PropTypes from 'prop-types';
import Table from '../table';
import CustomerStore from '../../stores/customers';
import {observer} from 'mobx-react';
import CustomerRow from '../customerrow';

class CustomerList extends Component {
  static defaultProps = {
    tableFields: ['Név', 'E-mail cím', 'Telefonszám', '']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    CustomerStore.loadData();
  }

  render () {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Vásárlók</h1>
          <Table fields={this.props.tableFields} datas={CustomerStore.getCustomers()} rowClass={CustomerRow} />
        </section>
      </div>
    );
  }
}

export default observer(CustomerList);
