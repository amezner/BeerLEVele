import React, {Component} from 'react';


import './layout1.css';
import logo from './logo.png';
import MainMenu from '../mainmenu';

class Layout1 extends Component {
  render() {
    return (
      <div id="wrapper">
        <header>
          <div className="content-width">
            <MainMenu />
            <div className="logo-content">
              <img src={logo} alt="BeerLEVele" />
            </div>
          </div>
        </header>
        <main>
          <div className="content">
            {this.props.children}
          </div>
        </main>
      </div>
    )
  }
}

export default Layout1;
