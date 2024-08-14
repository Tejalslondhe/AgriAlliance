import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faInstagram, faTwitter, faFacebook } from '@fortawesome/free-brands-svg-icons';

const Footer = () => {
  return (
    <footer style={styles.footer}>
      <div>
        <h3>Services</h3>
        <ul style={styles.footerList}>
          <li>Crop Consultation</li>
          <li>Market Connect</li>
          <li>Agri Tools Booking</li>
        </ul>
      </div>
      <div>
        <h3>Follow Us</h3>
        <div style={styles.socialIcons}>
          <a href="https://instagram.com" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faInstagram} /></a>
          <a href="https://twitter.com" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faTwitter} /></a>
          <a href="https://facebook.com" target="_blank" rel="noopener noreferrer"><FontAwesomeIcon icon={faFacebook} /></a>
        </div>
      </div>
    </footer>
  );
}

const styles = {
  footer: {
    backgroundColor: '#333',
    color: 'white',
    padding: '20px',
    display: 'flex',
    justifyContent: 'space-between',
  },
  footerList: {
    listStyleType: 'none',
    padding: 0,
  },
  socialIcons: {
    fontSize: '1.5em',
    display: 'flex',
    justifyContent: 'space-between',
    width: '100px',
  }
};

export default Footer;
