
import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {observer} from 'mobx-react';
import {withRouter} from 'react-router-dom';
import {post} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import AuthStore from '../../stores/authorization';

import './mainmenu.css';

class MainMenu extends Component {
  constructor(props) {
    super(props);

    this.handleLogout = this.handleLogout.bind(this);
  }

  async handleLogout(e) {
    e.preventDefault();

    try {
      const resp = await post('authentication/logout', {
        authtoken: sessionStorage.getItem('authToken')
      });

      NotificationManager.success(resp.message);
    } catch (e) {
      NotificationManager.warning(e.message);
    } finally {
      AuthStore.setIsLoggedIn(false);
      sessionStorage.removeItem('authToken');
      this.props.history.push('/login');
    }
  }

  render() {
    return (
      <div className="menu-outer">
        <div className="menu-icon">
          menü
        </div>
        <ul className="menu">
          <li className="menu-item">
            Vásárlók
            <ul className="submenu">
              <li className="menu-item submenu-item">
                <Link to="/customerlist">Vásárlók listája</Link>
              </li>
              <li className="menu-item submenu-item">
                <Link to="/customerform">Vásárló rögzítése</Link>
              </li>
            </ul>
          </li>
          <li className="menu-item">
            Termékek
            <ul className="submenu">
              <li className="menu-item submenu-item">
                <Link to="/productlist">Termékek listája</Link>
              </li>
              <li className="menu-item submenu-item">
                <Link to="/productform">Termék rögzítése</Link>
              </li>
            </ul>
          </li>
          <li className="menu-item">
            Számlázás
            <ul className="submenu">
              <li className="menu-item submenu-item">
                <Link to="/invoicelist">Számlák listája</Link>
              </li>
              <li className="menu-item submenu-item">
                <Link to="/cart">Számla létrehozása</Link>
              </li>
            </ul>
          </li>
          <li>
            <span onClick={this.handleLogout}>Kilépés</span>
          </li>
        </ul>
      </div>
    );
  }
}

export default observer(withRouter(MainMenu));
