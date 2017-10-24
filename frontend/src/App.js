import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import LoginPage from './components/login';
import ProductForm from './components/productform';
import CustomerForm from './components/customerform';
import Protected from './components/protected';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <Protected>
            <Route exact path="/" component={ProductForm} />
            <Route path="/productform" component={ProductForm} />
            <Route path="/customerform" component={CustomerForm} />
          </Protected>
          <Route path="/login" component={LoginPage} />
        </div>
      </Router>
    );
  }
}

export default App;
