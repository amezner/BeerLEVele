import React, {Component} from 'react';
import PropTypes from 'prop-types';
import './table.css';
import TableRow from '../tablerow';

class Table extends Component {
  static defaultProps = {
    fields: [],
    datas: []
  };

  static propTypes = {
    fields: PropTypes.array,
    datas: PropTypes.array
  };

  render(){
    const {fields, datas} = this.props;
    
    return (
      <div className="table-outer">
        <div className="table">
          <div className="table-row header-row">
            {
              fields.map(function(field){
                return (<div key={field.key} className="table-cell">{field.label}</div>);
              })
            }
          </div>
          {
            (datas.length > 0) ? (
              datas.map(function(row, index){
                return (
                  <TableRow key={`row-${index}`} data={row} index={index} fields={fields} />
                )
              })
            ) : null
          }
        </div>
      </div>
    )
  }
}

export default Table;
