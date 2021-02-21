import Axios from 'axios';
import React, { Component } from 'react';
import baseUrl from '../AppConfig';
import Header from './Header';
import LineChart from './LineChart';
import Selector from './Selector';

class HomePage extends Component {
    constructor() {
        super();
        this.state = {
            countries: [],
            chartData: {}
        }
    }

    componentDidMount = () => {
        Axios
            .get(`${baseUrl}/api/data/countries`)
            .then((res) => this.setState({ countries: res.data }))
            .catch((err) => console.log(err))

        if (window.location.pathname === "/app" || window.location.pathname === "/app/") {
            Axios
                .get(`${baseUrl}/api/data/all-countries`)
                .then((res) => {
                    this.setState({ chartData: res.data })
                })
                .catch((err) => console.log(err))
        } else {
            Axios
                .get(`${baseUrl}/api/data/${(window.location.pathname).split("/")[2]}`)
                .then((res) => {
                    this.setState({ chartData: res.data })
                })
                .catch((err) => console.log(err))
        }

    }

    handleSelect = (e) => {
        e.preventDefault();
        let countryName = e.target.innerHTML;

        if (countryName === "All countries") {
            Axios
                .get(`${baseUrl}/api/data/all-countries`)
                .then((res) => this.setState({ chartData: res.data }))
                .catch((err) => console.log(err))
            this.props.history.push(`/`)
        } else {
            Axios
                .get(`${baseUrl}/api/data/${countryName}`)
                .then((res) => this.setState({ chartData: res.data }))
                .catch((err) => console.log(err))
            this.props.history.push(`/${countryName}`)
        }
    }

    render() {
        return (
            <div className="container-fluid text-center p-0">
                <Header />
                <Selector
                    countries={this.state.countries}
                    handleSelect={this.handleSelect}
                />
                <LineChart
                    chartData={this.state.chartData}
                />
            </div>
        )
    }
}

export default HomePage;