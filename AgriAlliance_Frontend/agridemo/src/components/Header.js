import React from 'react';
import { NavLink } from 'react-router-dom';
import '../styles/Header.css'

function Header() {
  return (
    <nav className="navbar navbar-expand-lg custom-navbar">
      <div className="container-fluid">
        <NavLink className="navbar-brand" to="/">
          AgriAlliance
        </NavLink>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            <li className="nav-item">
              <NavLink className="nav-link" to="/">
                Home
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/farmers">
                Farmers
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/merchants">
                Merchants
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/workers">
                Workers
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/agronomists">
                Agronomists
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink className="nav-link" to="/contact">
                Contact Us
              </NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Header;
