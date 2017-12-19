import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {NotificationManager} from 'react-notifications';
import UserStore from '../../stores/users';
import {del} from '../../lib/client';
import {observer} from 'mobx-react';
import Edit from 'react-icons/lib/md/edit';
import Delete from 'react-icons/lib/md/delete';

class UserRow extends Component {
  constructor(props) {
    super(props);

    this.handleDelete = this.handleDelete.bind(this);
  }

  async handleDelete() {
    const {id} = this.props.data;
    try {
      const resp = await del('user/deleteuser/'+id);

      UserStore.deleteUser(id);
      NotificationManager.success('', 'Sikeres Törlés', 3000);
    } catch (e) {
      const message = e.message ? e.message : 'Ismeretlen hiba!';
      NotificationManager.error(message, 'Sikertelen törlés', 3000);
    }
  }

  render() {
    const {id, name, role} = this.props.data;
    return (
      <div className="table-row data-row">
        <div className="table-cell">
          <Link to={`/userform/${id}`}>{name}</Link>
        </div>
        <div className="table-cell">{role}</div>
        <div className="table-cell feature-cell">
          <div className="features-content">
            <Link to={`/userform/${id}`} className="feature-item">
              <Edit />
            </Link>
            <span className="feature-item" onClick={this.handleDelete}>
              <Delete />
            </span>
          </div>
        </div>
      </div>
    )
  }
}

export default observer(UserRow);
