import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import './FetchWorkers.css';

const FetchWorkers = () => {
  const [workers, setWorkers] = useState([]);
  const navigate = useNavigate(); // Initialize useNavigate

  useEffect(() => {
    const fetchWorkers = async () => {
      try {
        const response = await axios.get('http://localhost:8080/workers/all');
        console.log('Fetched Workers:', response.data); // Debugging line
        setWorkers(response.data);
      } catch (error) {
        console.error('Error fetching workers:', error);
      }
    };

    fetchWorkers();
  }, []);

  const handleBookClick = (workerEmail) => {
    // Simulate booking and show success message
    alert('Booked successfully');
    // Redirect to FarmerDashboard after a short delay
    setTimeout(() => {
      navigate('/farmerdashboard'); // Redirect to FarmerDashboard
    }, 1000); // 1000 milliseconds delay before redirect
  };

  return (
    <div className="worker-list">
      <h2>Available Workers</h2>
      <table>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Contact Number</th>
            <th>No of Group Members</th>
            <th>Skills</th>
            <th>Crop</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {workers.map((worker) => (
            <tr key={worker.email}>
              <td>{worker.firstName}</td>
              <td>{worker.lastName}</td>
              <td>{worker.email}</td>
              <td>{worker.contactNumber}</td>
              <td>{worker.noOfGroupMembers}</td>
              <td>
                {Array.isArray(worker.skills)
                  ? worker.skills.join(', ')
                  : 'No skills listed'}
              </td>
              <td>{worker.crop}</td>
              <td>
                <button className="book-button" onClick={() => handleBookClick(worker.email)}>Book</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FetchWorkers;
