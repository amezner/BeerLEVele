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

    this.state = {
      disabled: false
    };
  }

  handleClick() {
    const {clickEvt} = this.props;

    this.setState({
      disabled: false
    });

    if (clickEvt) {
      clickEvt();
    }
  }

  get disabled() {
    return this.state.disabled;
  }

  setDisabled(disabled) {
    this.setState({disabled});
  }

  render() {
    const { type, text, extraClass } = this.props;
    const className = extraClass ? 'button '+extraClass : 'button';

    return (
      <button type={type} className={className} disabled={this.state.disabled} onClick={this.handleClick} >{text}</button>
    )
  }
}

export default Button;
