import React, {Component} from 'react';
import ReactDOM from 'react-dom';

import ReactFC from 'react-fusioncharts';
import FusionCharts from 'fusioncharts';
import charts from 'fusioncharts/fusioncharts.charts';
import TM from 'fusioncharts/themes/fusioncharts.theme.zune';

import StatisticStore from '../../stores/statistics';
import { observer } from 'mobx-react';

charts(FusionCharts);

class MonthStatistic extends Component {
  componentDidMount() {
    this.loadData(this.props);
  }

  loadData(props) {
    StatisticStore.loadPerMonth();
  }

  render() {
    const items = StatisticStore.getPerMonth();

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
        "caption": `${year} évi összesített adatok`,
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
      <div className="content-width thin">
        <div className="content-section">
          <h1>Éves adatok</h1>
          {
            StatisticStore.getPerMonth().length == 0 ? 
            <div></div> :
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
      </div>
    );
  }
}

export default observer(MonthStatistic);
