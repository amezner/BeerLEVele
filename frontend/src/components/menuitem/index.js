import React, {Component} from 'react';
import {Link} from 'react-router-dom';

class MenuItem extends Component {
  render(){
    const {propMap, node} = this.props.data;
    const nodeTitle = node[propMap.displayName];
    return (
      <Link 
        to={node[propMap.url] || '#'} 
        className={ `rpm-node-link rpm-inline-block ${node[propMap.linkClasses] || ''}` }
        onClick={(e) => {
          this.props.onNodeClick(e, this.props.data);
        }}>
        {nodeTitle}
      </Link>
    );
  }
}

export default MenuItem;
