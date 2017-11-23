import React, { Component } from 'react';
import PropTypes from 'prop-types';

import './dropdown.css';

class DropDown extends Component {

  static defaultProps = {
    label: null,
    value: '',
    name: '',
    id: '',
    options: {},
    changeEvt: null
  };

  static propTypes = {
    label: PropTypes.string,
    name: PropTypes.string,
    id: PropTypes.string,
    value: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    options: PropTypes.object
  };

  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);

    this.state = {
      value: props.value
    };
  }

  handleChange(evt) {
    const {changeEvt} = this.props;
    const value = evt.target.value;

    this.setState({value});
    if (changeEvt) {
      changeEvt(value);
    }
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (nextState.value === this.state.value && nextProps.options === this.props.options) {
      return false;
    }

    return true;
  }

  get value() {
    return this.state.value;
  }

  render() {
    const {name, id, label, value, options, changeEvt} = this.props;

    return (

      <span className="custom-select">
        <select name={name} id={id} onChange={this.handleChange}>
            {
              Object.keys(options).length > 0 ?
                Object.entries(options).map(([value, label]) => {
                  return <option key={value} value={value}>{label}</option>
                }) : null
            }
        </select>
      </span>
    )
  }
}

export default DropDown;
