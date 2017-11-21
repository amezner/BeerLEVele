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

      if (typeof resp.token != 'undefined') {
        NotificationManager.info('Jó munkát kívánok!', 'Szia '+resp.username);
        sessionStorage.setItem('authToken', resp.token);
        AuthStore.setIsLoggedIn(true);
        this.props.history.push(AuthStore.oldUrl);
      } else if (typeof resp.message != 'undefined'){
        NotificationManager.error(resp.message, 'Sikertelen belépés!', 3000);
      } else {
        NotificationManager.error('Ismeretlen hiba', 'Sikertelen belépés!', 3000);
      }
    } catch (e) {
      const error = e.message ? e.message : 'Ismeretlen hiba!';
      NotificationManager.error(error, 'Sikertelen belépés!', 3000);
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
