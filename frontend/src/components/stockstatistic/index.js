import React, {Component} from 'react';
import AuthStore from '../../stores/authorization';
import { NotificationManager } from 'react-notifications';
import ProductStore from '../../stores/products';
import FormRow from '../formrow';
import DropDown from '../dropdown';
import { observer } from 'mobx-react';
import StockChart from '../stockchart';

class StockStatistic extends Component {
  constructor(props) {
    super(props);

    this.changeSelect = this.changeSelect.bind(this);
    this.state = {
      productId: null
    };
  }

  componentDidMount() {
    if (AuthStore.hasPermission('perstock')) {
      ProductStore.loadData();
    } else {
      NotificationManager.warning('Ehhez a modulhoz nincs joga!', 'Hoppá!');
      this.props.history.push('/productlist');
    }
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (nextState.productId !== this.state.productId) {
      return true;
    }
    
    return false;
  }

  changeSelect() {
      const {productSelect} = this.refs;
      if (productSelect) {
        const id = productSelect.value;
        this.setState({
          productId: parseInt(id) > 0 ? id : null
        });
      }
  }

  render() {
    let productOptions = [{
      value: 0,
      label: 'Válasszon terméket'
    }];

    const products = ProductStore.getProducts();
    if (products.length > 0) {
      products.map((item) => {
        productOptions.push({
          value: item.id,
          label: item.name
        });
      });
    }
    if (this.state.productId) {
      
    }
    return (
      <div className="content-width">
        <div className="content-section">
          <h1>Termék kimutatás</h1>
          <FormRow id="products" label="Termék">
            <DropDown options={productOptions} id="products" value={this.state.productId} name="products" ref="productSelect" changeEvt={this.changeSelect} />
          </FormRow>
        </div>
        {
          this.state.productId ? 
          (<div className="content-section">
            <StockChart product={ProductStore.getProduct(parseInt(this.state.productId))} />
          </div>) : null
        }
      </div>
    );
  }
}

export default observer(StockStatistic);
/*  */
