import React, { Component } from 'react';
import './global.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import {observer} from 'mobx-react';

import LoginPage from './components/login';
import ProductForm from './components/productform';
import CustomerForm from './components/customerform';
import Protected from './components/protected';
import AuthStore from './stores/authorization';
import CustomerList from './components/customerlist';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <Protected isLoggedIn={AuthStore.isLoggedIn}>
            <Route exact path="/" component={CustomerForm} />
            <Route path="/productform" component={ProductForm} />
            <Route path="/customerform" component={CustomerForm} />
          </Protected>
          <Route path="/login" component={LoginPage} />
        </div>
      </Router>
    );
  }
}

export default observer(App);
