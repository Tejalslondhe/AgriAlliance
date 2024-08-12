import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Header.css'; // Optional for styling

function Header() {
    return (
        <header>
            <nav>
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/about">About Us</Link></li>
                    <li><Link to="/farmers">Farmers</Link></li>
                    <li><Link to="/merchants">Merchants</Link></li>
                    <li><Link to="/workers">Workers</Link></li>
                    <li><Link to="/doctors">Doctors</Link></li>
                    <li><Link to="/contact">Contact Us</Link></li>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
