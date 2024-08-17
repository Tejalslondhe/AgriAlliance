import React from 'react';
import { Container, Button, Row, Col } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import './MerchantDashboard.css';

const MerchantDashboard = () => {
  const navigate = useNavigate();

  const handleAction = (action) => {
    switch (action) {
      case 'deleteProfile':
        navigate('/delete-profile'); // Navigate to a separate form for deleting the profile
        break;
      case 'fetchinstrument':
        navigate('/fetchinstrument');
        break;
      default:
        break;
    }
  };

  return (
    <Container className="merchant-dashboard">
      <h2 className="text-center mb-4">Merchant Dashboard</h2>
      <Row className="mt-3">
        <Col md={6}>
          <Button variant="secondary" onClick={() => handleAction('fetchinstrument')}>Book Instrument on Rent</Button>
        </Col>
        <Col md={6}>
          <Button variant="danger" onClick={() => handleAction('deleteProfile')}>Delete Profile</Button>
        </Col>
      </Row>
    </Container>
  );
};

export default MerchantDashboard;
