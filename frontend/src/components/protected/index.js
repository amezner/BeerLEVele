import React, {Component} from 'react';
import {Redirect, withRouter} from 'react-router-dom';
import AuthStore from '../../stores/authorization';

class Protected extends Component {
  constructor(props) {
    super(props);

    this.checkLoggedIn = this.checkLoggedIn.bind(this);
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.isLoggedIn != this.props.isLoggedIn) {
      this.checkLoggedIn(nextProps);
    }
  }

  componentDidMount() {
    this.checkLoggedIn(this.props);
  }

  checkLoggedIn(props) {
    const url = props.location.pathname;
    if (!props.isLoggedIn) {
      if (url !== '/login') {
        AuthStore.oldUrl = url;
        props.history.push('/login');

      }
    } else if (props.isLoggedIn && url === '/login') {
      props.history.push('/');
    }
  }

  render() {
    return this.props.isLoggedIn ? this.props.children : null;
  }
}

export default withRouter(Protected);
