import React, {Component} from 'react';
import FormRow from '../formrow';
import Field from '../field';
import Button from '../button';
import {post, put, get} from '../../lib/client';
import {withRouter} from 'react-router-dom';
import {NotificationManager} from 'react-notifications';
import AuthStore from '../../stores/authorization';
import {PropTypes} from 'prop-types';
import Dropdown from '../dropdown';

class UserForm extends Component {
  static defaultProps = {
    rules: {
      0: 'Kérem válasszon jogosultságot!',
      admin: 'Admin',
      operator: 'Operátor',
      finance: 'Pénzügy'
    }
  };

  static propTypes = {
    rules: PropTypes.object
  };

  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      user: {}
    };
  }
  
  async handleSubmit(e) {
    e.preventDefault();
    const {button, name, pass, pass_conf, role} = this.refs;
    let valid = true;
    if (pass.value.trim() !== '' && pass.value !== pass_conf.value) {
      valid = false;
      NotificationManager.error('A két jelszó mező nem egyezik!', 'Sikertelen mentés!', 3000);
    }

    if (button && !button.disabled && valid) {
      button.setDisabled(true);

      let data = {
        name: name.value.trim(),
        role: role.value
      };

      if (pass.value !== '') {
        data.password = pass.value.trim();
      }

      try {
        const id = this.state.user.id;
        if (id) {
          const resp = await put('user/edituser'+id, data);
        } else {
          const resp = await put('user/saveuser', data);
        }
        
        NotificationManager.success('', 'Sikeres mentés!', 3000);
        this.props.history.push('/userlist');
      } catch (e) {
        const message = e.message ? e.message : 'Ismeretlen hiba!';
        NotificationManager.error(message, 'Sikertelen mentés!', 3000);
        button.setDisabled(false);
      }
    }
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (this.props.match.params.id !== nextProps.match.params.id) {
      this.setState({
        user:{}
      });
    }

    return true;
  }

  componentDidMount() {
    const userId = this.props.match.params.id;
    if (userId) {
      this.loadUser(userId).then((resp) => {
        if (resp) {
          this.setState({user:resp});
        }
      });
    }
  }
  
  async loadUser(userId) {
    try {
      const resp = await get('user/getuser/'+userId);
      if (!resp) {
        throw 'A felhasználó betöltése nem sikerült!';
      }
      return resp;
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba';
      NotificationManager.error(message);
    }
  }

  render() {
    const {id, name, role} = this.state.user;
    return (
      <div className="content-width thin">
        <section className="content-section">
          <h1>{name ? 'Felhasználó módosítása' : 'Felhasználó létrehozása'}</h1>
          <form onSubmit={this.handleSubmit}>
            <FormRow label="Név" id="name">
              <Field ref="name" value={name} type="text" id="name" name="name" />
            </FormRow>
            <div className="password-row">
              <FormRow extraClass="half" label="Jelszó" id="pass">
                <Field ref="pass" type="password" id="pass" name="pass" />
              </FormRow>
              <FormRow extraClass="half" label="Jelszó újra" id="pass_confirm">
                <Field ref="pass_conf" type="password" id="pass_confirm" name="pass_confirm" />
              </FormRow>
              <div className="clear"></div>
            </div>
            <FormRow label="Jogosultság" id="role">
              <Dropdown options={this.props.rules} value={role} ref="role" id="role"></Dropdown>
            </FormRow>
            {
              AuthStore.hasRight('adduser') ? 
            (<FormRow extraClass="button-row">
              <Button text="mentés" type="submit" ref="button" />
            </FormRow>) : null
            }
          </form>
        </section>
      </div>
    )
  }
}

export default UserForm;
