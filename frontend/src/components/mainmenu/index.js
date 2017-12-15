
import React, {Component} from 'react';
import MenuItem from '../menuitem';
import {observer} from 'mobx-react';
import {withRouter} from 'react-router-dom';
import {post} from '../../lib/client';
import {NotificationManager} from 'react-notifications';
import AuthStore from '../../stores/authorization';

import 'react-push-menu/styles/component.css';
import PushMenu from 'react-push-menu';
import Bars from 'react-icons/lib/fa/bars';

import './mainmenu.css';

class MainMenu extends Component {
  constructor(props) {
    super(props);

    this.handleLogout = this.handleLogout.bind(this);
    this.state = {
      menu: {
        header: `Szia ${AuthStore.getName()},`,
        children: [
          {
            name:'Vásárlók',
            id: 1,
            link: '/customerlist',
            children: [
              {
                name: 'Vásárlók listája',
                link: '/customerlist'
              }, {
                name: 'Vásárló rögzítése',
                link: '/customerform'
              }
            ]
          },
          {
            name:'Termékek',
            link:'/productlist',
            children: [
              {
                name:'Termékek listája',
                link:'/productlist'
              },
              {
                name:'Termék rögzítése',
                link:'/productform'
              }
            ]
          },
          {
            name:'Számlák',
            link:'/invoicelist',
            children: [
              {
                name:'Kiállított számlák',
                link:'/invoicelist'
              }, {
                name:'Számla létrehozása',
                link:'/cart'
              }
            ]
          },
          {
            name:'Felhasználók',
            link:'/userlist',
            children: [
              {
                name:'Felhasználók listája',
                link:'/userlist'
              }, {
                name:'Felhasználó létrehozása',
                link:'/userform'
              }
            ]
          },
          {name:'Kilépés', type:'logout'}
        ]
      }
    };
  }

  async handleLogout(e) {
    e.preventDefault();

    try {
      const resp = await post('authentication/logout', {
        authtoken: localStorage.getItem('authToken')
      });

      NotificationManager.success(resp.message);
    } catch (e) {
      NotificationManager.warning(e.message);
    } finally {
      AuthStore.logout();
      this.props.history.push('/login');
    }
  }

  render() {
    return (
      <PushMenu 
        className="beerlevele-push-menu"
        onNodeClick={(e, {menu, node, rootNode}) => {
          if (typeof node.type !== 'undefined') {
            this.handleLogout(e);
          }
          
          menu.tools.reset();
        }}
        nodes={this.state.menu}
        type={'overlap'}
        propMap={{
          url: 'link',
        }}
        linkComponent={MenuItem}
        autoHide={true} >
        <div className="rpm-trigger" id="rpm-trigger" >
          <Bars />
        </div>
      </PushMenu>
    );
  }
}

export default observer(withRouter(MainMenu));
