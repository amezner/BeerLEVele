import React, {Component} from 'react';
import './login.css';

import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';

class Login extends Component {
  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);

  }

  handleSubmit(e) {
    e.preventDefault();
    const {username, password} = this.refs;
    console.log(username);
    console.log(password);
  }

  render() {
    return (
      <div className="login-content">
        <form onSubmit={this.handleSubmit}>
          <FormRow>
            <Field ref="username" placeholder="felhasználónév" value="Béla"/>
          </FormRow>
          <FormRow>
            <Field ref="password" type="password"  placeholder="jelszó"/>
          </FormRow>
          <FormRow>
            <Button text="belépés" type="submit"/>
          </FormRow>
        </form>
      </div>
    );
  }
}

export default Login;
