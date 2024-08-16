import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTwitter, faFacebook, faInstagram } from '@fortawesome/free-brands-svg-icons';
import '../styles/Footer.css';

function Footer() {
  return (
    <footer className="footer bg-light text-center text-lg-start">
      <div className="container p-4">
        <div className="row">
          <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
            <h5 className="text-uppercase">Services</h5>
            <ul className="list-unstyled mb-0">
              <p>Connect with Farmers</p>
              <p>Connect with Merchants</p>
              <p>Connect with Workers</p>
              <p>Connect with Agronomists</p>
              <p>Instruments on Rent</p>
            </ul>
          </div>
          <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
            <h5 className="text-uppercase">Contact Us</h5>
            <p>Phone: 7769826579</p>
            <p>Email: agroalliance@gmail.com</p>
            <p>Visit us at: Office - ABC, Pune</p>
          </div>
          <div className="col-lg-3 col-md-6 mb-4 mb-md-0">
            <h5 className="text-uppercase">Follow Us</h5>
            <a href="https://twitter.com" className="me-3"><FontAwesomeIcon icon={faTwitter} size="2x" /></a>
            <a href="https://facebook.com" className="me-3"><FontAwesomeIcon icon={faFacebook} size="2x" /></a>
            <a href="https://instagram.com"><FontAwesomeIcon icon={faInstagram} size="2x" /></a>
          </div>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
