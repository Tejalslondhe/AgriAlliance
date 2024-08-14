import React from 'react';
import { Carousel } from 'react-bootstrap';
import './App.css';
import agricultureImage from './Images/Agriculture.jpg';
import farmerImage from './Images/Farmer1.jpg';
import workerImage from './Images/Worker1.jpg';
import merchantImage from './Images/Merchant1.jpg';
import doctorImage from './Images/Worker2.jpg';

function App() {
  return (
    <div className="App">
      {/* Header */}
      <header className="header">
        <nav>
          <ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#about">About Us</a></li>
            <li><a href="#farmers">Farmers</a></li>
            <li><a href="#merchants">Merchants</a></li>
            <li><a href="#workers">Workers</a></li>
            <li><a href="#doctors">Doctors</a></li>
            <li><a href="#contact">Contact Us</a></li>
          </ul>
        </nav>
      </header>

      {/* Hero Section with Swapping Images */}
      <section className="hero">
        <Carousel>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src={agricultureImage}
              alt="First slide"
            />
            <Carousel.Caption>
              <h1>Welcome to AgriAlliance</h1>
              <p>Your one-stop solution for connecting farmers, merchants, workers, and agri doctors.</p>
            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src={farmerImage}
              alt="Second slide"
            />
            <Carousel.Caption>
              <h1>Welcome to AgriAlliance</h1>
              <p>Your one-stop solution for connecting farmers, merchants, workers, and agri doctors.</p>
            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img
              className="d-block w-100"
              src={workerImage}
              alt="Third slide"
            />
            <Carousel.Caption>
              <h1>Welcome to AgriAlliance</h1>
              <p>Your one-stop solution for connecting farmers, merchants, workers, and agri doctors.</p>
            </Carousel.Caption>
          </Carousel.Item>
        </Carousel>
      </section>

      {/* Farmers Section */}
      <section id="farmers" className="section">
        <div className="section-content">
          <img src={farmerImage} alt="Farmers" className="section-image" />
          <div className="section-text">
            <h2>Farmers</h2>
            <p>Empowering farmers with the tools and resources they need to succeed.</p>
            <div className="buttons">
              <button className="signin-btn">Sign In</button>
              <button className="signup-btn">Sign Up</button>
            </div>
          </div>
        </div>
      </section>

      {/* Workers Section */}
      <section id="workers" className="section">
        <div className="section-content">
          <img src={workerImage} alt="Workers" className="section-image" />
          <div className="section-text">
            <h2>Workers</h2>
            <p>Connecting workers with job opportunities in the agricultural sector.</p>
            <div className="buttons">
              <button className="signin-btn">Sign In</button>
              <button className="signup-btn">Sign Up</button>
            </div>
          </div>
        </div>
      </section>

      {/* Merchants Section */}
      <section id="merchants" className="section">
        <div className="section-content">
          <img src={merchantImage} alt="Merchants" className="section-image" />
          <div className="section-text">
            <h2>Merchants</h2>
            <p>Facilitating trade and commerce between merchants and farmers.</p>
            <div className="buttons">
              <button className="signin-btn">Sign In</button>
              <button className="signup-btn">Sign Up</button>
            </div>
          </div>
        </div>
      </section>

      {/* Doctors Section */}
      <section id="doctors" className="section">
        <div className="section-content">
          <img src={doctorImage} alt="Doctors" className="section-image" />
          <div className="section-text">
            <h2>Agri Doctors</h2>
            <p>Connecting agri doctors with farmers to provide essential guidance.</p>
            <div className="buttons">
              <button className="signin-btn">Sign In</button>
              <button className="signup-btn">Sign Up</button>
            </div>
          </div>
        </div>
      </section>

      {/* Footer */}
      <footer className="footer">
        <div className="footer-content">
          <div className="services">
            <h3>Services</h3>
            <ul>
              <li><a href="#service1">Service 1</a></li>
              <li><a href="#service2">Service 2</a></li>
              <li><a href="#service3">Service 3</a></li>
            </ul>
          </div>
        </div>
      </footer>
    </div>
  );
}

export default App;
