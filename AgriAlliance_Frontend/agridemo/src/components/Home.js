import React from 'react';
import { Carousel } from 'react-bootstrap';
import agricultureImage1 from '../Images/Agri1.jpg';
import agricultureImage2 from '../Images/Agri2.jpg';
import agricultureImage3 from '../Images/Agri3.jpg';
import farmerImage from '../Images/Farmer1.jpg';
import workerImage from '../Images/Worker1.jpg';
import merchantImage from '../Images/Merchant1.jpg';
import agronomistImage from '../Images/Doctor1.jpg';
import instrumentImage from '../Images/Instr1.jpg';
import '../styles/Home.css'; // Ensure this file exists or adjust as needed

const Home = () => {
  return (
    <main>
      {/* Carousel Section */}
      <section className="hero">
        <Carousel>
          <Carousel.Item>
            <img className="d-block w-100" src={agricultureImage1} alt="Agriculture Image 1" />
            <Carousel.Caption>
              <div className="carousel-content">
                <h3>Welcome to AgriAlliance</h3>
                <p>Your one-stop solution for connecting farmers, merchants, workers, and agronomists.</p>
              </div>
            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img className="d-block w-100" src={agricultureImage2} alt="Agriculture Image 2" />
            <Carousel.Caption>
              <div className="carousel-content">
                <h3>Welcome to AgriAlliance</h3>
                <p>Your one-stop solution for connecting farmers, merchants, workers, and agronomists.</p>
              </div>
            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img className="d-block w-100" src={agricultureImage3} alt="Agriculture Image 3" />
            <Carousel.Caption>
              <div className="carousel-content">
                <h3>Welcome to AgriAlliance</h3>
                <p>Your one-stop solution for connecting farmers, merchants, workers, and agronomists.</p>
              </div>
            </Carousel.Caption>
          </Carousel.Item>
        </Carousel>
      </section>

      {/* Sections for Farmers, Workers, Merchants, Agronomists, Instruments */}
      <section className="sections">
        <div className="section">
          <img className="section-image" src={farmerImage} alt="Farmers" />
          <div className="section-content">
            <h2>Farmers</h2>
            <p>Empowering farmers with the resources they need to succeed.</p>
          </div>
        </div>
        <div className="section reverse">
          <img className="section-image" src={workerImage} alt="Workers" />
          <div className="section-content">
            <h2>Workers</h2>
            <p>Connecting workers with job opportunities in agriculture.</p>
          </div>
        </div>
        <div className="section">
          <img className="section-image" src={merchantImage} alt="Merchants" />
          <div className="section-content">
            <h2>Merchants</h2>
            <p>Facilitating trade between farmers and merchants.</p>
          </div>
        </div>
        <div className="section reverse">
          <img className="section-image" src={agronomistImage} alt="Agronomists" />
          <div className="section-content">
            <h2>Agronomists</h2>
            <p>Providing expert advice to improve farming practices.</p>
          </div>
        </div>
        <div className="section">
          <img className="section-image" src={instrumentImage} alt="Instruments" />
          <div className="section-content">
            <h2>Instruments of Agriculture</h2>
            <p>Offering the latest tools and machinery for rent.</p>
          </div>
        </div>
      </section>
    </main>
  );
};

export default Home;
