import React, { useState } from 'react';
import axios from 'axios';
import { useLocation, useNavigate } from 'react-router-dom';
import './BookInstrument.css'; // Optional, if you want to style this component

const BookInstrument = () => {
  const { state } = useLocation();
  const navigate = useNavigate();
  const instrumentId = state?.instrumentId;

  const [bookingData, setBookingData] = useState({
    instrumentId: instrumentId || '',
    farmerEmail: '',
    bookingDate: '',
    returnDate: ''
  });

  const handleChange = (e) => {
    setBookingData({
      ...bookingData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post('http://localhost:8080/instruments/book', bookingData, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      alert('Instrument booked successfully!');
      navigate('/dashboard'); // Redirect to a dashboard or another page
    } catch (error) {
      console.error('Error booking instrument:', error);
      alert('Error booking instrument. Please try again.');
    }
  };

  return (
    <div className="booking-form">
      <h2>Book Instrument</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Instrument ID:</label>
          <input
            type="text"
            name="instrumentId"
            value={bookingData.instrumentId}
            readOnly
          />
        </div>
        <div>
          <label>Farmer Email:</label>
          <input
            type="email"
            name="farmerEmail"
            value={bookingData.farmerEmail}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Booking Date:</label>
          <input
            type="date"
            name="bookingDate"
            value={bookingData.bookingDate}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>Return Date:</label>
          <input
            type="date"
            name="returnDate"
            value={bookingData.returnDate}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Book</button>
      </form>
    </div>
  );
};

export default BookInstrument;
