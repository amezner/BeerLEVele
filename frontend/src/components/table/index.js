import React, {Component} from 'react';
import PropTypes from 'prop-types';
import './table.css';

class Table extends Component {
  static defaultProps = {
    fields: [],
    datas: {}
  };

  static propTypes = {
    fields: PropTypes.array,
    datas: PropTypes.object
  };

  render(){
    const {fields, datas, rowClass} = this.props;

    return (
      <div className="table-outer">
        <div className="table">
          <div className="table-row header-row">
            {
              fields.map(function(label, index){
                return (<div key={`header-${index}`} className="table-cell">{label}</div>);
              })
            }
          </div>
          {
            (datas.length > 0) ? (
              datas.map(function(row, index){
                return React.createElement(rowClass, {
                  data:row,
                  key:'row-'+index
                });
              })
            ) : null
          }
        </div>
      </div>
    )
  }
}

export default Table;
