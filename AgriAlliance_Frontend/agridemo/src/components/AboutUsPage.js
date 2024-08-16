import React from 'react';
import '../styles/AboutUsPage.css';

const AboutUsPage = () => {
  return (
    <div className="about-container">
      <div className="about-hero">
        <h1>About AgriAlliance</h1>
        <p>Connecting the Agriculture Ecosystem for a Better Future</p>
      </div>
      <div className="about-content">
        <section>
          <h2>Our Mission</h2>
          <p>
            At AgriAlliance, our mission is to empower farmers, workers, merchants, and agronomists by providing a
            comprehensive platform that connects them, fosters collaboration, and enhances productivity.
          </p>
        </section>
        <section>
          <h2>Our Vision</h2>
          <p>
            We envision a world where technology bridges the gap in the agricultural sector, leading to a more
            sustainable and prosperous future for everyone involved.
          </p>
        </section>
        <section>
          <h2>Our Team</h2>
          <p>
            AgriAlliance is powered by a diverse team of experts in agriculture, technology, and business, all
            dedicated to driving innovation and supporting the agricultural community.
          </p>
        </section>
        <section>
          <h2>Why Choose Us?</h2>
          <ul>
            <li>Comprehensive platform catering to all agricultural roles</li>
            <li>Secure and user-friendly interface</li>
            <li>Access to expert advice and resources</li>
            <li>Seamless integration of services and tools</li>
          </ul>
        </section>
      </div>
    </div>
  );
};

export default AboutUsPage;
