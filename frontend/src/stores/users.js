import {extendObservable} from 'mobx'
import {get} from '../lib/client';
import {NotificationManager} from 'react-notifications';

class UserStore {
  constructor() {
    extendObservable(this, {
      'users': []
    });
  }

  setUsers(users) {
    this.users = users;
  }

  getUsers() {
    return this.users;
  }

  getUser(id) {
    return this.users.length > 0 ? this.users.find((item) => item.id === id) : null;
  }

  deleteUser(id) {
    this.users = this.users.filter((user) => user.id !== id);
  }

  async loadData() {
    try {
      let resp = await get('user/getalluser');
      if (!Array.isArray(resp)) {
        resp = Object.values(resp);
      }

      this.setUsers(resp);
    } catch(e) {
      const message = e.message ? e.message : 'Ismeretlen hiba!';
      NotificationManager.error(message);
    }
  }
}

export default new UserStore();
