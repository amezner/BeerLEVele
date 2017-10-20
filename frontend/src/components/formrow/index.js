import React, { Component } from 'react';

class Formrow extends Component {
  render() {
    return (
      <div className="form-row">
        {this.props.children}
      </div>
    );
  }
}

export default Formrow;
