import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './EquipmentRental.css'; // Assuming you will create a CSS file for styling

const EquipmentRental = () => {
  const [formData, setFormData] = useState({
    name: '',
    type: '',
    availabilityStatus: false,
    ratePerDay: ''
  });

  const navigate = useNavigate(); // Hook for navigation

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setFormData({
      ...formData,
      [name]: type === 'checkbox' ? checked : value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/instruments/add', formData);
      alert('Added successfully!');
      setFormData({
        name: '',
        type: '',
        availabilityStatus: false,
        ratePerDay: ''
      });
      navigate('/farmerdashboard'); // Redirect to the dashboard
    } catch (error) {
      console.error('There was an error adding the instrument!', error);
    }
  };

  return (
    <div className="equipment-rental-container">
      <h1>Add New Equipment for Rent</h1>
      <form onSubmit={handleSubmit} className="equipment-rental-form">
        <div className="form-group">
          <label htmlFor="name">Instrument Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="type">Instrument Type:</label>
          <input
            type="text"
            id="type"
            name="type"
            value={formData.type}
            onChange={handleChange}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="availabilityStatus">Available for Rent:</label>
          <input
            type="checkbox"
            id="availabilityStatus"
            name="availabilityStatus"
            checked={formData.availabilityStatus}
            onChange={handleChange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="ratePerDay">Rate Per Day (in ₹):</label>
          <input
            type="number"
            id="ratePerDay"
            name="ratePerDay"
            value={formData.ratePerDay}
            onChange={handleChange}
            required
          />
        </div>

        <button type="submit" className="submit-button">
          Add Equipment
        </button>
      </form>
    </div>
  );
};

export default EquipmentRental;
