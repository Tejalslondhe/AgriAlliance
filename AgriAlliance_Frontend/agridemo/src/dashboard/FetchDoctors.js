import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import './FetchDoctors.css';

const FetchDoctors = () => {
  const [doctors, setDoctors] = useState([]);
  const navigate = useNavigate(); // Initialize useNavigate

  useEffect(() => {
    const fetchDoctors = async () => {
      try {
        const response = await axios.get('http://localhost:8080/doctors/all');
        console.log('Fetched Doctors:', response.data); // Debugging line
        setDoctors(response.data);
      } catch (error) {
        console.error('Error fetching doctors:', error);
      }
    };

    fetchDoctors();
  }, []);

  const handleBookClick = (doctorEmail) => {
    // Simulate booking and show success message
    alert('Booked successfully');
    // Redirect to FarmerDashboard after a short delay
    setTimeout(() => {
      navigate('/farmerdashboard'); // Redirect to FarmerDashboard
    }, 1000); // 1000 milliseconds delay before redirect
  };

  return (
    <div className="doctors-list">
      <h2>Available Doctors</h2>
      <table>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Contact Number</th>
            <th>Specialization</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {doctors.map((doctor) => (
            <tr key={doctor.email}>
              <td>{doctor.firstName}</td>
              <td>{doctor.lastName}</td>
              <td>{doctor.email}</td>
              <td>{doctor.contactNumber}</td>
              <td>{doctor.specialization}</td>
              <td>
                <button className="book-button" onClick={() => handleBookClick(doctor.email)}>Book</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FetchDoctors;
