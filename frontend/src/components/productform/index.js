import React, { Component } from 'react';
import FormRow from '../formrow';
import Field from '../field';

class Productform extends Component {
  render() {
    return (
      <div className="content-width">
        <FormRow>
          <Field name="cica" />
        </FormRow>
      </div>
    );
  }
}

export default Productform;
