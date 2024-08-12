import React from 'react';
import '../styles/Footer.css';


function Footer() {
    return (
        <footer>
            <div className="services">
                <h3>Our Services</h3>
                <p>Service 1</p>
                <p>Service 2</p>
                <p>Service 3</p>
            </div>
            <div className="social-media">
                <h3>Follow Us</h3>
                <a href="https://facebook.com">Facebook</a>
                <a href="https://twitter.com">Twitter</a>
                <a href="https://instagram.com">Instagram</a>
            </div>
        </footer>
    );
}

export default Footer;
