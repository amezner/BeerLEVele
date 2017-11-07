import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './button.css';

class Button extends Component {
  static defaultProps = {
    type: 'button',
    text: 'gomb',
    clickEvt: null,
    extraClass: ''
  };

  static propTypes = {
    type: PropTypes.string,
    text: PropTypes.string,
    extraClass: PropTypes.string
  };

  render() {
    const { type, text, clickEvt, extraClass } = this.props;
    const className = extraClass ? 'button '+extraClass : 'button';

    return (
      <button type={type} className={className} onClick={clickEvt} >{text}</button>
    )
  }
}

export default Button;
