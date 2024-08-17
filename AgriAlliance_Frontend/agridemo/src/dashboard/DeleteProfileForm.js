// DeleteProfileForm.js
import React, { useState } from 'react';
import { Container, Form, Button, Alert } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const DeleteProfileForm = () => {
  const [email, setEmail] = useState('');
  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');
  const navigate = useNavigate();

  const handleDelete = async (e) => {
    e.preventDefault();
    setError('');
    setSuccess('');

    try {
      await axios.delete(`http://localhost:8080/farmers/delete/${email}`);
      setSuccess('Profile deleted successfully.');
      navigate('/login');
    } catch (error) {
      setError('Failed to delete profile. Please try again.');
    }
  };

  return (
    <Container className="mt-5">
      <h2>Delete Profile</h2>
      {error && <Alert variant="danger">{error}</Alert>}
      {success && <Alert variant="success">{success}</Alert>}
      <Form onSubmit={handleDelete}>
        <Form.Group controlId="formEmail">
          <Form.Label>Email Address</Form.Label>
          <Form.Control
            type="email"
            placeholder="Enter your email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </Form.Group>
        <Button variant="danger" type="submit" className="mt-3">
          Delete Profile
        </Button>
      </Form>
    </Container>
  );
};

export default DeleteProfileForm;
