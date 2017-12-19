import React, {Component} from 'react';
import PropTypes from 'prop-types';

import ReactFC from 'react-fusioncharts';
import FusionCharts from 'fusioncharts';
import charts from 'fusioncharts/fusioncharts.charts';

import StatisticStore from '../../stores/statistics';
import { observer } from 'mobx-react';

charts(FusionCharts);

class StockChart extends Component {
  static defaultProps = {
    product: [],
  };

  static propTypes = {
    product: PropTypes.object,
  }

  constructor(props) {
    super(props);
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (this.props !== nextProps) {
      return true;
    } 

    return false;
  }

  componentDidMount() {
    this.loadData(this.props);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.product.id !== this.props.product.id) {
      this.loadData(nextProps);
    }
  }

  loadData(props) {
    if (props.product.id) {
      StatisticStore.loadPerStock(parseInt(props.product.id));
    }
  }

  render() {
    const {product} = this.props;
    
    const items = StatisticStore.getPerStock();

    let dataSet = [];
    let income = {
      seriesname: "Bevétel",
      data: []
    };
    
    let purchase = {
      seriesname: "Beszerzés",
      renderas: 'line',
      showvalues: 0,
      data: []
    };

    let profit = {
      seriesname: 'Profit',
      renderas: 'area',
      showvalues: 0,
      data: []
    }

    let quantity = {
      seriesname: 'Mennyiség',
      renderas:'line',
      showvalues: 0,
      data:[]
    }

    const year = 2017;

    for (var i = 1; i < 13; i++) {
      const item = items.find((item) => item.month === i && item.year === year);
      
      income.data.push({
        value: item ? item.income : 0
      });
      profit.data.push({
        value: item ? item.profit : 0
      });
      quantity.data.push({
        value: item ? item.quantity : 0
      });
      purchase.data.push({
        value: item ? item.purchase : 0
      });
    }
    dataSet.push(income);
    dataSet.push(profit);
    // dataSet.push(quantity);
    dataSet.push(purchase);

    const dataSource = {
      chart: {
        "caption": `${year} évi eladások`,
        "xaxisname": "Hónap",
        "yaxisname": "Összeg (Ft-ban)",
        "theme": "zune"
      },
      "categories": [
          {
              "category": [
                  {
                      "label": "Január"
                  },
                  {
                      "label": "Február"
                  },
                  {
                      "label": "Március"
                  },
                  {
                      "label": "Április"
                  },
                  {
                      "label": "Május"
                  },
                  {
                      "label": "Június"
                  },
                  {
                      "label": "Július"
                  },
                  {
                      "label": "Augusztus"
                  },
                  {
                      "label": "Szeptember"
                  },
                  {
                      "label": "Október"
                  },
                  {
                      "label": "November"
                  },
                  {
                      "label": "December"
                  }
              ]
          }
      ],
      "dataset": dataSet
    };
    return (
      <div>
        <h2>{product.name}</h2>
        <br />
        {
          StatisticStore.getPerStock().length == 0 ? 
          <div>Még nem vásárloltak ebből a termékből</div> :
          <ReactFC 
            id="multi_chart"
            renderAt="multi_chart_container" 
            type="mscombi2d"
            dataFormat="json"
            width="100%"
            height="400"
            dataSource={dataSource} />
        }
      </div>
    );
  }
}

export default observer(StockChart);
