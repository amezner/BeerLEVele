import React, { Component } from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';


import Field from '../field';

class Root extends Component {
  render() {
    return (
      <Router>
        <Route path="" component="{Field}" />
        <Route path="/" component="{Field}" />
      </Router>
    );
  }
}

export default Root;
