import React, {Component} from 'react';
import PropTypes from 'prop-types';
import './checkfield.css';

class Checkfield extends Component {
  static defaultProps = {
    type: 'checkbox',
    id: '',
    value: '',
    label: '',
    name: '',
    selected: false
  };

  static propTypes = {
    label: PropTypes.string,
    type: PropTypes.string,
    name: PropTypes.string,
    id: PropTypes.string,
    selected: PropTypes.bool
  }

  constructor(props) {
    super(props);

    this.state = {
      selected: props.selected
    };

    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(evt) {
    const {selected} = this.state;

    this.setState({
      selected: !selected
    });
  }

  componentWillReceiveProps(nextProps, nextState) {
    if (nextProps.selected !== this.state.selected) {
      this.setState({selected:nextProps.selected});
    }
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (nextState.selected === this.state.selected) {
      return false;
    }

    return true;
  }

  get selected() {
    return this.state.selected
  }

  render() {
    const {type, id, value, label, name} = this.props;
    const {selected} = this.state;

    const labelElement = label ? <label htmlFor={id}>{label}</label> : null;
    return (
      <span className="checkfield">
        <input type={type} id={id} value={value} name={name} checked={selected} onChange={this.handleChange} />
        {labelElement}
      </span>
    );
  }
}

export default Checkfield;
