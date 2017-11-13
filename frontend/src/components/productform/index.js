import React, { Component } from 'react';
import FormRow from '../formrow';
import Field from '../field';

class Productform extends Component {
  render() {
    return (
      <div className="content-width">
        <section className="content-section">
          <h1>Termék hozzáadása</h1>
          <FormRow>
            <Field placeholder="termék név" />
          </FormRow>
        </section>
      </div>
    );
  }
}

export default Productform;
