import React, {Component} from 'react';
import PropTypes from 'prop-types';
import './field.css';

class Field extends Component {

  static defaultProps = {
    type: 'text',
    placeholder: '',
    value: '',
    id: '',
    extraClass: '',
    changeEvt: null,
    bindEvt: null
  };

  static propTypes = {
    type: PropTypes.string,
    placeholder: PropTypes.string,
    value: PropTypes.any,
    id: PropTypes.string,
    extraClass: PropTypes.string
  };

  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);
    this.handleBlur = this.handleBlur.bind(this);

    this.state = {
      value: props.value
    };
  }

  componentWillReceiveProps(nextProps) {
    const value = nextProps.value;
    this.setState({value});
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (nextState.value === this.state.value) {
      return false;
    }

    return true;
  }

  handleChange(evt) {
    const {changeEvt} = this.props;
    const value = evt.target.value;
    this.setState({value});

    if (changeEvt) {
      changeEvt();
    }
  }

  handleBlur() {
    const {blurEvt} = this.props;

    if (blurEvt) {
      blurEvt();
    }
  }

  get value() {
    return this.state.value;
  }

  render() {
    const {type, placeholder, id, extraClass} = this.props;
    const {value} = this.state;

    return (<input id={id} type={type} placeholder={placeholder} className={`field ${extraClass}`} value={value} onChange={this.handleChange} onBlur={this.handleBlur} />);
  }
}

export default Field
