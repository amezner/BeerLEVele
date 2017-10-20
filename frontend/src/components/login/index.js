import React, { Component } from 'react';
import './login.css';

import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';

class Login extends Component {
  render() {
    return (
      <div className="login-content">
        <FormRow>
          <Field placeholder="felhasználónév" name="username" />
        </FormRow>
        <FormRow>
          <Field type="password" name="password" placeholder="jelszó" />
        </FormRow>
        <FormRow>
          <Button text="belépés" />
        </FormRow>
      </div>
    );
  }
}

export default Login;
