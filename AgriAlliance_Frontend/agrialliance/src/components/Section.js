import React from 'react';

const Section = ({ title, description, imageUrl, signInUrl, signUpUrl }) => {
  return (
    <section style={{ ...styles.section, backgroundImage: `url(${imageUrl})` }}>
      <div style={styles.overlay}>
        <h2>{title}</h2>
        <p>{description}</p>
        <div>
          <a href={signInUrl} style={styles.button}>Sign In</a>
          <a href={signUpUrl} style={styles.button}>Sign Up</a>
        </div>
      </div>
    </section>
  );
}

const styles = {
  section: {
    height: '50vh',
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    position: 'relative',
    color: 'white',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    textAlign: 'center',
    marginBottom: '20px',
  },
  overlay: {
    backgroundColor: 'rgba(0, 0, 0, 0.5)',
    padding: '20px',
  },
  button: {
    margin: '10px',
    padding: '10px 20px',
    color: 'white',
    backgroundColor: '#4CAF50',
    textDecoration: 'none',
    borderRadius: '5px',
  }
};

export default Section;
