import React from 'react';
import CountriesDropdown from './CountriesDropdown';

const Selector = ({ countries, handleSelect }) => (
    <div>
        <div className="row mt-4">
            <p className="col-6 text-right">Select a country: </p>
            <div className="col-6 text-left">
                <CountriesDropdown
                    countries={countries}
                    handleSelect={handleSelect}
                />
            </div>
        </div>
    </div >
)

export default Selector;