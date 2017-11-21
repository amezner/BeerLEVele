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

  constructor(props) {
    super(props);

    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    const {clickEvt} = this.props;

    if (clickEvt) {
      clickEvt();
    }
  }

  render() {
    const { type, text, clickEvt, extraClass } = this.props;
    const className = extraClass ? 'button '+extraClass : 'button';

    return (
      <button type={type} className={className} onClick={this.handleClick} >{text}</button>
    )
  }
}

export default Button;
