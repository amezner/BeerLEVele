import React, { Component } from 'react';
import './global.css';
import './styles/reset.css';
import './styles/styles.css';

import { BrowserRouter as Router, Route } from 'react-router-dom';
import {observer} from 'mobx-react';
import {NotificationContainer} from 'react-notifications';
import 'react-notifications/lib/notifications.css';

import LoginPage from './components/login';
import Layout1 from './components/layout1';
import ProductForm from './components/productform';
import CustomerForm from './components/customerform';
import Protected from './components/protected';
import AuthStore from './stores/authorization';
import CustomerList from './components/customerlist';
import ProductList from './components/productlist';
import InvoiceList from './components/invoicelist';
import UserList from './components/userlist';
import UserForm from './components/userform';
import Cart from './components/cart';
import Invoice from './components/invoice';
import ProfitList from './components/profitlist';
import MonthStatistic from './components/monthstatistic';
import StockStatistic from './components/stockstatistic';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <Protected isLoggedIn={AuthStore.isLoggedIn}>
            <Layout1>
              <Route exact path="/" component={ProductList} />
              <Route path="/productform/:id?" component={ProductForm} />
              <Route path="/productlist" component={ProductList} />
              <Route path="/customerform/:id?" component={CustomerForm} />
              <Route path="/customerlist" component={CustomerList} />
              <Route path="/invoicelist" component={InvoiceList} />
              <Route path="/cart" component={Cart} />
              <Route path="/invoice/:id" component={Invoice} />
              <Route path="/userlist" component={UserList} />
              <Route path="/userform/:id?" component={UserForm} />

              <Route path="/statistic/profit" component={ProfitList} />
              <Route path="/statistic/permonth" component={MonthStatistic} />
              <Route path="/statistic/perstock" component={StockStatistic} />
            </Layout1>
          </Protected>
          <Route path="/login" component={LoginPage} />

          <NotificationContainer />
        </div>
      </Router>
    );
  }
}

export default observer(App);
