import React, { Component } from 'react';
import PropTypes from 'prop-types';
import './field.css';

class Field extends Component {
  static defaultProps = {
    type: 'text',
    placeholder: '',
    name: ''
  };

  static propTypes = {
    type: PropTypes.string,
    placeholder: PropTypes.string,
    name: PropTypes.string
  };

  render() {
    const { type, placeholder, name } = this.props;

    return (
      <input type={type} name={name} placeholder={placeholder} className="field" />
    );
  }
}

export default Field
