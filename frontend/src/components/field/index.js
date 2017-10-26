import React, {Component} from 'react';
import PropTypes from 'prop-types';
import './field.css';

class Field extends Component {

  static defaultProps = {
    type: 'text',
    placeholder: '',
    value: ''
  };

  static propTypes = {
    type: PropTypes.string,
    placeholder: PropTypes.string,
    value: PropTypes.string
  };

  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);

    this.state = {
      value: props.value
    };
  }

  handleChange(arg1) {
    const value = arg1.target.value;

    this.setState({value});
  }

  get value() {
    return this.state.value;
  }

  render() {
    const {type, placeholder} = this.props;
    const {value} = this.state;

    return (<input type={type} placeholder={placeholder} className="field" value={value} onChange={this.handleChange}/>);
  }
}

export default Field
