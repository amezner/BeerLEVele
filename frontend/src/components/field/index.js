import React, { Component } from 'react';
import './field.css';

class Field extends Component {
  static get defaultProps() {
      return {
        type: 'text',
        placeholder: ''
      };
  }

  render() {
    const { type, placeholder } = this.props;
    
    return (
      <input type={type} name="" placeholder={placeholder} className="field" />
    );
  }
}

export default Field
