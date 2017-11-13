import React, { Component } from 'react';
import PropTypes from 'prop-types';

class Formrow extends Component {
  static defaultProps = {
    extraClass: ''
  };

  static propTypes = {
    extraClass: PropTypes.string
  };

  render() {
    const {extraClass} = this.props;
    const classNames = extraClass ? 'form-row '+extraClass : 'form-row';
    return (
      <div className={classNames}>
        {this.props.children}
      </div>
    );
  }
}

export default Formrow;
