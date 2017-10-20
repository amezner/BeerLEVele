import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import loginPage from './components/login';
import productForm from './components/productform';

class App extends Component {
  render() {
    return (
      <Router>
        <div>
          <Route exact path="/" component={loginPage} />
          <Route path="/login" component={loginPage} />
          <Route path="/productform" component={productForm}/>
        </div>
      </Router>
    );
  }
}

export default App;
