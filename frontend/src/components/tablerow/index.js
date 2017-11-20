import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {Link} from 'react-router-dom';

class Tablerow extends Component
{
  static defaultProps = {
    fields: [],
    data: {},
    index: null
  };

  static propTypes = {
    fields: PropTypes.array,
    data: PropTypes.object,
    index: PropTypes.number
  };

  constructor(props) {
    super(props);

    this.handleClick = this.handleClick.bind(this);
  }

  handleClick(path) {

  }

  render() {
    const {fields, data, index} = this.props;

    return(
      <div className="table-row data-row">
        {
          fields.map((field) => {
            let value = field.features ? null : data[field.field];
            if (value == null) {
              value = (<div className="features-content">
                {
                  Object.entries(field.features).map(([key, feature]) => {

                    return feature.link
                      ? <Link key={key} to={feature.link.replace('{id}', data.id)} className="feature-item">{feature.title}</Link>
                      : <span key={key} className="feature-item">{feature.title}</span>
                  })
                }
              </div>);
            }
            return (
              <div key={field.key} className="table-cell">{value}</div>
            )
          })
        }
      </div>
    )
  }
}

export default Tablerow;
