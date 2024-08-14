import React from 'react';

const Hero = () => {
  return (
    <section style={styles.hero}>
      <h1>Welcome to AgriAlliance</h1>
      <p>Your one-stop platform connecting Farmers, Merchants, Workers, and Agri Doctors.</p>
    </section>
  );
}

const styles = {
  hero: {
    background: `url('/path/to/your/background-image.jpg') center/cover no-repeat`,
    height: '70vh',
    color: 'white',
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    textAlign: 'center',
    padding: '0 20px',
  }
};

export default Hero;
