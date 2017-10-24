import React, {Component} from 'react';
import {observer} from 'mobx-react';
import {Redirect, withRouter} from 'react-router-dom';
import AuthStore from '../../stores/authorization';

class Protected extends Component {
  componentDidMount() {
    if (!AuthStore.isLoggedIn) {
      const url = this.props.location.pathname;
      if (url !== '/login') {
        AuthStore.oldUrl = url;
      }
    }
  }

  render() {
    return AuthStore.isLoggedIn ? this.props.children : <Redirect to="/login" />;
  }
}

export default observer(withRouter(Protected));
