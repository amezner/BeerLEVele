import React, {Component} from 'react';
import {get} from '../../lib/client';
import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';

import AuthStore from '../../stores/authorization';
import {observer} from 'mobx-react';
import {withRouter} from 'react-router-dom';
import {post} from '../../lib/client';

import './login.css';


class Login extends Component {
  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);

  }

  async handleSubmit(e) {
    e.preventDefault();
    const {username, password} = this.refs;

    AuthStore.setIsLoggedIn(true);
    this.props.history.push(AuthStore.oldUrl);
  }

  render() {
    return (
      <div className="login-content">
        <form onSubmit={this.handleSubmit}>
          <FormRow>
            <Field ref="username" placeholder="felhasználónév" value="Béla"/>
          </FormRow>
          <FormRow>
            <Field ref="password" type="password" placeholder="jelszó"/>
          </FormRow>
          <FormRow>
            <Button text="belépés" type="submit"/>
          </FormRow>
        </form>
      </div>
    );
  }
}

export default observer(withRouter(Login));
