import React, { Component } from 'react';
import './field.css';

class Field extends Component {
  static get defaultProps() {
      return {
        type: 'text',
        placeholder: '',
        name: ''
      };
  }

  render() {
    const { type, placeholder, name } = this.props;

    return (
      <input type={type} name={name} placeholder={placeholder} className="field" />
    );
  }
}

export default Field
