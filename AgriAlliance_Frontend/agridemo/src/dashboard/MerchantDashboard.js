import React from 'react';
import { Container, Button, Row, Col } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './MerchantDashboard.css'; // Optional, if you want to style this component

const MerchantDashboard = () => {
  const navigate = useNavigate();
  const token = localStorage.getItem('token'); // Retrieve the JWT token from local storage

  const handleConnect = async (type) => {
    const urls = {
      farmers: 'http://localhost:8080/farmers/all',
    };

    if (!token) {
      alert('No token found. Please log in again.');
      return;
    }

    try {
      const response = await axios.get(urls[type], {
        headers: {
          Authorization: `Bearer ${token}` // Include the token in the request headers
        }
      });
      if (response.data) {
        console.log('Data fetched successfully:', response.data);
        navigate(`/${type}-list`, { state: response.data });
      }
    } catch (error) {
      console.error('Error fetching data:', error.response ? error.response.data : error.message);
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
          await axios.delete('http://localhost:8080/merchants/delete/{email}', {
            headers: {
              Authorization: `Bearer ${token}` // Include the token in the request headers
            }
          });
          navigate('/login');
          break;
        case 'addInstrument':
          navigate('/add-instrument');
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
    <Container className="merchant-dashboard">
      <h2 className="text-center mb-4">Merchant Dashboard</h2>
      <Row>
        <Col md={4}>
          <Button variant="primary" onClick={() => handleConnect('farmers')}>Connect to Farmers</Button>
        </Col>
      </Row>
      <Row className="mt-3">
        <Col md={4}>
          <Button variant="secondary" onClick={() => handleAction('addInstrument')}>Add Instrument on Rent</Button>
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

export default MerchantDashboard;
