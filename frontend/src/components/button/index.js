import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './button.css';

class Button extends Component {
  static defaultProps = {
    type: 'button',
    text: 'gomb'
  };

  static propTypes = {
    type: PropTypes.string,
    text: PropTypes.string,
  };

  render() {
    const { type, text } = this.props;
    return (
      <button type={type} className="button">{text}</button>
    )
  }
}

export default Button;
