import React, { Component } from 'react';
import './login.css';

import Field from '../field';
import Button from '../button';

class Login extends Component {
  render() {
    return (
      <div className="login-content">
        <div className="form-row">
          <Field placeholder="felhasználónév" />
        </div>
        <div className="form-row">
          <Field type="password" placeholder="jelszó" />
        </div>
        <div className="form-row">
          <Button />
        </div>
      </div>
    );
  }
}

export default Login;
