import React, {Component} from 'react';
import PropTypes from 'prop-types';
import Table from '../table';
import {observer} from 'mobx-react';
import UserStore from '../../stores/users';
import UserRow from '../userrow';
import AuthStore from '../../stores/authorization';
import { NotificationManager } from 'react-notifications';

class UserList extends Component {
  static defaultProps = {
    tableFields: ['Név', 'Jogosultság', '']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    if (this.checkUserPermission()) {
      UserStore.loadData();
    }
  }

  checkUserPermission() {
    if (!AuthStore.hasPermission('userlist')) {
      NotificationManager.warning('Ehhez modulhoz nincs joga!', 'Hoppá!');
      this.props.history.push('/productlist');
      return false;
    }

    return true;
  }

  render() {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Felhasználók</h1>
          <Table fields={this.props.tableFields} datas={UserStore.getUsers()} rowClass={UserRow} />
        </section>
      </div>
    )
  }
}

export default observer(UserList);
