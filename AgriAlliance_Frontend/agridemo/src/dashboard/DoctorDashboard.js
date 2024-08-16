import React from 'react';
import { Container, Button, Row, Col } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './DoctorDashboard.css';

const DoctorDashboard = () => {
  const navigate = useNavigate();

  const handleConnect = async (type) => {
    try {
      const response = await axios.post(`http://localhost:8080/${type}`, {});
      // Handle response if needed
    } catch (error) {
      console.error('Error connecting:', error);
    }
  };

  const handleAction = (action) => {
    switch (action) {
      case 'editProfile':
        navigate('/edit-profile');
        break;
      case 'deleteProfile':
        // Call backend to delete profile
        axios.delete('http://localhost:8080/doctors/delete/{email}')
          .then(() => navigate('/login'))
          .catch(error => console.error('Error deleting profile:', error));
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
  };

  return (
    <Container className="doctor-dashboard">
      <h2 className="text-center mb-4">Doctor Dashboard</h2>
      <Row>
        <Col md={4}>
          <Button variant="primary" onClick={() => handleConnect('farmers')}>Connect to Farmers</Button>
        </Col>
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

export default DoctorDashboard;
