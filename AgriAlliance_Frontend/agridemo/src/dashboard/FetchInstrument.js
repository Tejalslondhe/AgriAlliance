import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './FetchInstrument.css'; // Optional, if you want to style this component

const FetchInstrument = () => {
  const [instruments, setInstruments] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchInstruments = async () => {
      try {
        const response = await axios.get('http://localhost:8080/instruments/all');
        setInstruments(response.data);
      } catch (error) {
        console.error('Error fetching instruments:', error);
      }
    };

    fetchInstruments();
  }, []);

  const handleBookClick = (instrumentId) => {
    navigate('/book-instrument', { state: { instrumentId } });
  };

  return (
    <div className="instrument-list">
      <h2>Available Instruments</h2>
      <ul>
        {instruments.map((instrument) => (
          <li key={instrument.id}>
            <div>
              <strong>{instrument.name}</strong>
              <p>{instrument.description}</p>
              <button onClick={() => handleBookClick(instrument.id)}>Book</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default FetchInstrument;
