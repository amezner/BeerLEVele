import React, {Component} from 'react';
import {NotificationManager} from 'react-notifications';
import {get} from '../../lib/client';
import Table from '../table';
import PropTypes from 'prop-types';

class Productlist extends Component {
  static defaultProps = {
    tableFields: [{
        label: 'Név',
        field: 'name',
        key: 'name'
      }, {
        label: 'Beszerzési ár',
        field: 'purchaseprice',
        key: 'purchaseprice'
      }, {
        label: 'Eladási ár',
        field: 'sellingprice',
        key: 'sellingprice'
      }, {
        label: 'Készlet',
        field: 'onstockquantity',
        key: 'quantity'
      },{
        label: '',
        key:'features',
        features: {
          edit: {
            title: 'Módosítás',
            link: '/productform/{id}',
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
      products: []
    };
  }

  componentDidMount() {
    this.loadProducts().then((resp) => {
      this.setState({products:resp});
    });
  }

  async loadProducts() {
    try {
      let resp = await get('stock/getallstock');
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
          <h1>Termékek</h1>
          <Table fields={this.props.tableFields} datas={this.state.products} />
        </section>
      </div>
    );
  }
}

export default Productlist;
