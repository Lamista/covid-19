import React from 'react';
import '../styles/CountriesDropdown.css'

const CountriesDropdown = ({ countries, handleSelect }) => {
    return (
        <div className="dropdown">
            <button className="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                {(window.location.pathname === "/app" || window.location.pathname === "/app/")
                    ? "All countries"
                    : (window.location.pathname).split("/")[2].replaceAll("%20", " ").replaceAll("&nbsp;", " ")}
            </button>
            <div className="dropdown-menu scrollable-menu" aria-labelledby="dropdownMenuButton">
                {(window.location.pathname !== "/app" && window.location.pathname !== "/app/") && <button className="dropdown-item" style={dropdownBtnStyle} onClick={handleSelect}>All countries</button>}
                {countries.map((c) => {
                    return (
                        <button key={c} className="dropdown-item" style={dropdownBtnStyle} onClick={handleSelect}>{c}</button>
                    )
                })}
            </div>
        </div>
    )
}

const dropdownBtnStyle = {
    backgroundColor: "#FFF",
    color: "#000"
}

export default CountriesDropdown;