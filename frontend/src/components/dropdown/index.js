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
      value: props.value,
    };
  }

  handleChange(evt) {
    const value = evt.target.value;

    this.setState({value});
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (nextState.value === this.state.value && nextProps.options === this.props.options) {
      return false;
    }

    return true;
  }

  componentDidUpdate(prevProps, prevState) {
    const {changeEvt} = this.props;

    if (prevState.value !== this.state.value) {
      if (changeEvt) {
        changeEvt();
      }
    }
  }

  get value() {
    return this.state.value;
  }

  render() {
    const {name, id, label, value, options, changeEvt} = this.props;

    return (

      <span className="custom-select">
        <select name={name} id={id} onChange={this.handleChange} defaultValue={this.state.value}>
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
