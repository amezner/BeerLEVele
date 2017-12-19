import React, { Component } from 'react';
import PropTypes from 'prop-types';

class Formrow extends Component {
  static defaultProps = {
    extraClass: '',
    id: '',
    label: '',
  };

  static propTypes = {
    extraClass: PropTypes.string,
    label: PropTypes.string,
    id: PropTypes.string
  };

  render() {
    const {extraClass, label, id} = this.props;
    const classNames = extraClass ? 'form-row '+extraClass : 'form-row';
    const labelElement = label ? <label htmlFor={id}>{label}</label> : null;
    return (
      <div className={classNames}>
        {labelElement}
        {this.props.children}
      </div>
    );
  }
}

export default Formrow;
