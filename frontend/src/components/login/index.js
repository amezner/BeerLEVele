import React, {Component} from 'react';
import {post} from '../../lib/client';
import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';

import {NotificationManager} from 'react-notifications';

import AuthStore from '../../stores/authorization';
import {observer} from 'mobx-react';
import {withRouter} from 'react-router-dom';

import './login.css';

class Login extends Component {
  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async handleSubmit(e) {
    e.preventDefault();
    const {username, password} = this.refs;

    try {
      const resp = await post('authentication/login', {
        username: username.value,
        password: password.value,
      });
      
      // console.log(resp);
      NotificationManager.info('visszatért');

      AuthStore.setIsLoggedIn(true);
      sessionStorage.setItem('authToken', resp.authToken);
      this.props.history.push(AuthStore.oldUrl);


    } catch (e) {
      NotificationManager.error(e.message, 'Sikeretelen belépés!', 3000);
    }


  }

  render() {
    return (
    <div className="login-content">
      <form onSubmit={this.handleSubmit}>
        <FormRow>
          <Field ref="username" placeholder="felhasználónév"/>
        </FormRow>
        <FormRow>
          <Field ref="password" type="password" placeholder="jelszó"/>
        </FormRow>
        <FormRow>
          <Button text="belépés" type="submit"/>
        </FormRow>
      </form>
    </div>);
  }
}

export default observer(withRouter(Login));
