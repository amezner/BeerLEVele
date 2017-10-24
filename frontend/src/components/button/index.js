import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './button.css';

class Button extends Component {
  static defaultProps = {
    type: 'button',
    text: 'gomb',
    clickEvt: null
  };

  static propTypes = {
    type: PropTypes.string,
    text: PropTypes.string,
  };

  render() {
    const { type, text, clickEvt } = this.props;
    
    return (
      <button type={type} className="button" onClick={clickEvt} >{text}</button>
    )
  }
}

export default Button;
