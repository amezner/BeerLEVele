import React, {Component} from 'react';
import PropTypes from 'prop-types';
import './table.css';

class Table extends Component {
  static defaultProps = {
    fields: [],
    datas: []
  };

  static propTypes = {
    fields: PropTypes.array,
    datas: PropTypes.array
  }

  render(){
    const {fields, datas} = this.props;

    return (
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
                <div className="table-row data-row" key={`row-${index}`}>
                  {
                  fields.map(function(field){
                    return (<div className="table-cell" key={`${field.key}-${index}`}>{
                      typeof field.field != 'undefined' ? row[field.field] : (
                        typeof field.features == 'undefined' ? null : (
                          Object.keys(field.features).length > 0 ?
                            Object.entries(field.features).map(([key, label]) => {
                              return label.title;
                            }) : null
                        )
                      )
                    }</div>)
                  })
                }
              </div>
              )
            })
          ) : null
        }
      </div>
    )
  }
}

export default Table;
