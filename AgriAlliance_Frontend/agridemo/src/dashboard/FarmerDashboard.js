import React from 'react';
import { Container, Button, Row, Col } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './FarmerDashboard.css';

const FarmerDashboard = () => {
  const navigate = useNavigate();
  const token = localStorage.getItem('token'); // Retrieve the JWT token from local storage

  const handleConnect = async (type) => {
    // Define the URL mappings for each type
    const urls = {
      workers: 'http://localhost:8080/workers/all',
      merchants: 'http://localhost:8080/merchants/all',
      agronomists: 'http://localhost:8080/agronomists/all', // Ensure this endpoint is correct
    };

    if (!token) {
      alert('No token found. Please log in again.');
      return;
    }

    try {
      // Fetch data from the respective URL based on the type
      const response = await axios.get(urls[type], {
        headers: {
          Authorization: `Bearer ${token}` // Include the token in the request headers
        }
      });
      if (response.data) {
        console.log('Data fetched successfully:', response.data);
        // Navigate to the respective list page with the fetched data
        navigate(`/${type}-list`, { state: response.data });
      }
    } catch (error) {
      console.error('Error fetching data:', error.response ? error.response.data : error.message);
      // Handle specific errors
      if (error.response && error.response.status === 403) {
        alert('Access Denied: You do not have permission to access this resource.');
      } else {
        alert('An error occurred while fetching data. Please try again.');
      }
    }
  };

  const handleAction = async (action) => {
    if (!token) {
      alert('No token found. Please log in again.');
      return;
    }

    try {
      switch (action) {
        case 'editProfile':
          navigate('/edit-profile');
          break;
        case 'deleteProfile':
          await axios.delete('http://localhost:8080/farmers/delete/{email}', {
            headers: {
              Authorization: `Bearer ${token}` // Include the token in the request headers
            }
          });
          navigate('/login');
          break;
        case 'bookInstrument':
          navigate('/book-instrument');
          break;
        case 'equipmentRental':
          navigate('/equipment-rental');
          break;
        default:
          break;
      }
    } catch (error) {
      console.error('Error performing action:', error.response ? error.response.data : error.message);
      alert('An error occurred while performing the action. Please try again.');
    }
  };

  return (
    <Container className="farmer-dashboard">
      <h2 className="text-center mb-4">Farmer Dashboard</h2>
      <Row>
        <Col md={4}>
          <Button variant="primary" onClick={() => handleConnect('workers')}>Connect to Workers</Button>
        </Col>
        <Col md={4}>
          <Button variant="primary" onClick={() => handleConnect('merchants')}>Connect to Merchants</Button>
        </Col>
        <Col md={4}>
          <Button variant="primary" onClick={() => handleConnect('agronomists')}>Connect to Agronomists</Button>
        </Col>
      </Row>
      <Row className="mt-3">
        <Col md={4}>
          <Button variant="secondary" onClick={() => handleAction('bookInstrument')}>Book Instrument on Rent</Button>
        </Col>
        <Col md={4}>
          <Button variant="secondary" onClick={() => handleAction('equipmentRental')}>Farm Equipment Rental</Button>
        </Col>
        <Col md={4}>
          <Button variant="danger" onClick={() => handleAction('deleteProfile')}>Delete Profile</Button>
        </Col>
      </Row>
      <Row className="mt-3">
        <Col md={6}>
          <Button variant="success" onClick={() => handleAction('editProfile')}>Edit Your Profile</Button>
        </Col>
      </Row>
    </Container>
  );
};

export default FarmerDashboard;
