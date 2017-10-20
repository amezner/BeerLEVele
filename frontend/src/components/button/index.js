import React, { Component } from 'react';
import './button.css';

class Button extends Component {
  static get defaultProps() {
    return {
      type: 'button',
      text: 'gomb'
    }
  }

  render() {
    const { type, text } = this.props;
    return (
      <button type={type} className="button">{text}</button>
    )
  }
}

export default Button;
