import React from 'react';
import { Container, Button, Row, Col } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './FarmerDashboard.css';

const FarmerDashboard = () => {
  const navigate = useNavigate();

  const handleConnect = async (type) => {
    const urls = {
      workers: 'http://localhost:8080/workers/all',
      merchants: 'http://localhost:8080/merchants/all',
      agronomists: 'http://localhost:8080/doctors/all',
    };

    try {
      const response = await axios.get(urls[type]);
      if (response.data) {
        console.log('Data fetched successfully:', response.data);
        navigate(`/${type}-list`, { state: response.data });
      }
    } catch (error) {
      console.error('Error fetching data:', error.response ? error.response.data : error.message);
      alert('An error occurred while fetching data. Please try again.');
    }
  };

  const handleAction = (action) => {
    switch (action) {
      case 'deleteProfile':
        navigate('/delete-profile'); // Navigate to a separate form for deleting the profile by email
        break;
      case 'fetchinstrument':
        navigate('/fetchinstrument');
        break;
      case 'equipmentRental':
        navigate('/equipment-rental');
        break;
      default:
        break;
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
          <Button variant="secondary" onClick={() => handleAction('fetchinstrument')}>Book Instrument on Rent</Button>
        </Col>
        <Col md={4}>
          <Button variant="secondary" onClick={() => handleAction('equipmentRental')}>Farm Equipment Rental</Button>
        </Col>
        <Col md={4}>
          <Button variant="danger" onClick={() => handleAction('deleteProfile')}>Delete Profile</Button>
        </Col>
      </Row>
    </Container>
  );
};

export default FarmerDashboard;
