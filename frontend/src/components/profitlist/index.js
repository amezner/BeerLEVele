import React, {Component} from 'react';
import { observer } from 'mobx-react';
import StatisticStore from '../../stores/statistics';
import PropTypes from 'prop-types';
import Table from '../table';
import AuthStore from '../../stores/authorization';
import { NotificationManager } from 'react-notifications';
import ProfitRow from '../profitrow';

class ProfitList extends Component {
  static defaultProps = {
    tableFields: ['Számlaszám', 'Vevő neve', 'Profit']
  };

  static propTypes = {
    tableFields: PropTypes.array
  };

  componentDidMount() {
    if (AuthStore.hasPermission('profitperinvoice')) {
      StatisticStore.loadProfit();
    } else {
      NotificationManager.warning('Ehhez a modulhoz nincs joga!', 'Hoppá!');
      this.props.history.push('/productlist');
    }
  }

  render() {
    return (
      <div className="content-width">
        <div className="content-section">
          <h1>Profit</h1>
          <Table fields={this.props.tableFields} datas={StatisticStore.getProfits()} rowClass={ProfitRow} />
        </div>
      </div>
    );
  }
}

export default observer(ProfitList);
