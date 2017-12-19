import React, {Component} from 'react';
import Table from '../table';
import PropTypes from 'prop-types';
import ProductsStore from '../../stores/products';
import CartStore from '../../stores/cart';
import AuthStore from '../../stores/authorization';
import {observer} from 'mobx-react';
import ProductRow from '../productrow';

class Productlist extends Component {
  static defaultProps = {
    tableFields: ['Név', 'Beszerzési ár', 'Eladási ár', 'Készlet', '']
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
    ProductsStore.loadData();
    if (AuthStore.hasPermission('cart')) {
      CartStore.loadData();
    }
  }

  render () {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Termékek</h1>
          <Table fields={this.props.tableFields} datas={ProductsStore.getProducts()} rowClass={ProductRow} />
        </section>
      </div>
    );
  }
}

export default observer(Productlist);
