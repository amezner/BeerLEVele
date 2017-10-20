import React, { Component } from 'react';
import './login.css';

import Field from '../field';
import Button from '../button';

class Login extends Component {
  render() {
    return (
      <div className="login-content">
        <div className="form-row">
          <Field placeholder="felhasználónév" name="username" />
        </div>
        <div className="form-row">
          <Field type="password" name="password" placeholder="jelszó" />
        </div>
        <div className="form-row">
          <Button text="belépés" />
        </div>
      </div>
    );
  }
}

export default Login;
