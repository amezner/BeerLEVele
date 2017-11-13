import React, {Component} from 'react';
import {Link} from 'react-router-dom';

import './mainmenu.css';

class MainMenu extends Component {
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
                Termékek listája
              </li>
              <li className="menu-item submenu-item">
                <Link to="productform">Termék rögzítése</Link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    );
  }
}

export default MainMenu;
