import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './FetchInstrument.css';

const FetchInstrument = () => {
  const [instruments, setInstruments] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchInstruments = async () => {
      try {
        const response = await axios.get('http://localhost:8080/instruments/all');
        console.log('Fetched Instruments:', response.data); // Debugging line
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
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Rate per Day</th>
            <th>Type</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {instruments.map((instrument) => (
            <tr key={instrument.id} className="instrument-item">
              <td>{instrument.name}</td>
              <td>${instrument.ratePerDay}</td> {/* Ensure this matches the field name */}
              <td>{instrument.type}</td>
              <td>
                <button className="book-button" onClick={() => handleBookClick(instrument.id)}>Book</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FetchInstrument;
