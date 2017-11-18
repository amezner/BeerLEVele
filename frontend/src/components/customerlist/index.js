import React, {Component} from 'react';
import {NotificationManager} from 'react-notifications';
import {get} from '../../lib/client';

class CustomerList extends Component {
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
          <h1>Vásárlók</h1>
        </section>
      </div>
    );
  }
}

export default CustomerList;
