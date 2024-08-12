import React from 'react';
import '../styles/Home.css';

const Home = () => {
    return (
        <div className="home-container">
            <h1>Welcome to AgriAlliance</h1>
            <h2>Connecting Farmers, Merchants, Workers, and Doctors</h2>
            <div className="home-content">
                <div className="home-section farmers">
                    <div className="overlay">
                        <h3>Farmers</h3>
                        <p>Learn about the latest farming techniques and resources.</p>
                    </div>
                </div>
                <div className="home-section merchants">
                    <div className="overlay">
                        <h3>Merchants</h3>
                        <p>Explore the best deals and products for agriculture.</p>
                    </div>
                </div>
                <div className="home-section workers">
                    <div className="overlay">
                        <h3>Workers</h3>
                        <p>Find opportunities and tools for agricultural work.</p>
                    </div>
                </div>
                <div className="home-section doctors">
                    <div className="overlay">
                        <h3>Agri Doctors</h3>
                        <p>Get expert advice on agricultural health and practices.</p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Home;
