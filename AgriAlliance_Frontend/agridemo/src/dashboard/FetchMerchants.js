import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import './FetchMerchants.css';

const FetchMerchants = () => {
  const [merchants, setMerchants] = useState([]);
  const navigate = useNavigate(); // Initialize useNavigate

  useEffect(() => {
    const fetchMerchants = async () => {
      try {
        const response = await axios.get('http://localhost:8080/merchants/all');
        console.log('Fetched Merchants:', response.data); // Debugging line
        setMerchants(response.data);
      } catch (error) {
        console.error('Error fetching merchants:', error);
      }
    };

    fetchMerchants();
  }, []);

  const handleBookClick = (merchantEmail) => {
    // Simulate booking and show success message
    alert('Booked successfully');
    // Redirect to FarmerDashboard after a short delay
    setTimeout(() => {
      navigate('/farmerdashboard'); // Redirect to FarmerDashboard
    }, 1000); // 1000 milliseconds delay before redirect
  };

  return (
    <div className="merchant-list">
      <h2>Available Merchants</h2>
      <table>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Contact Number</th>
            <th>Crop</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {merchants.map((merchant) => (
            <tr key={merchant.email}>
              <td>{merchant.firstName}</td>
              <td>{merchant.lastName}</td>
              <td>{merchant.email}</td>
              <td>{merchant.contactNumber}</td>
              <td>{merchant.crop}</td>
              <td>
                <button className="book-button" onClick={() => handleBookClick(merchant.email)}>Book</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FetchMerchants;
