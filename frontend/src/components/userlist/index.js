import React, {Component} from 'react';
import PropTypes from 'prop-types';
import Table from '../table';
import {observer} from 'mobx-react';
import UserStore from '../../stores/users';
import UserRow from '../userrow';

class UserList extends Component {
  static defaultProps = {
    tableFields: ['Név', 'Jogosultság', '']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    UserStore.loadData();
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
