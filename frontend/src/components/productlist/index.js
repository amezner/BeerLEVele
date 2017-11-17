import React, {Component} from 'react';
import {NotificationManager} from 'react-notifications';
import {get} from '../../lib/client';

class Productlist extends Component {
  constructor(props) {
    super(props);

    try {

    } catch (e) {
      NotificationManager.error(e.message);
    }
  }

  render () {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Termékek</h1>
        </section>
      </div>
    );
  }
}

export default Productlist;
