// LoginPage.js
import React, { useState } from 'react';
import { Container, Form, Button, Alert } from 'react-bootstrap';
import { useNavigate, useLocation } from 'react-router-dom';
import '../Auth/LoginPage.css'; // Import custom CSS

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const location = useLocation();

  // Get the role from the query parameters
  const role = new URLSearchParams(location.search).get('role') || 'FARMER';

  const handleLogin = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');

    try {
      // Replace with your login API endpoint
      const response = await fetch("http://localhost:8080/auth/signin", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
      });

      const data = await response.json();

      if (response.ok) {
        localStorage.setItem('token', data.token);

        // Redirect to the appropriate dashboard based on the role
        switch (role.toUpperCase()) {
          case 'FARMER':
            navigate('/farmerdashboard');
            break;
          case 'MERCHANT':
            navigate('/merchantdashboard');
            break;
          case 'WORKER':
            navigate('/workerdashboard');
            break;
          case 'DOCTOR':
            navigate('/doctordashboard');
            break;
          default:
            setError('Unknown role');
        }
      } else {
        setError(data.message || 'Login failed');
      }
    } catch (err) {
      setError('An error occurred');
    } finally {
      setLoading(false);
    }
  };

  return (
    <Container className="login-container">
      <h2 className="text-center mb-4">{role} Login</h2>
      {error && <Alert variant="danger">{error}</Alert>}
      <Form onSubmit={handleLogin}>
        <Form.Group controlId="formEmail">
          <Form.Label>Email address</Form.Label>
          <Form.Control
            type="email"
            placeholder="Enter your email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </Form.Group>
        <Form.Group controlId="formPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            placeholder="Enter your password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </Form.Group>
        <Button variant="primary" type="submit" disabled={loading}>
          {loading ? 'Logging in...' : 'Login'}
        </Button>
      </Form>
    </Container>
  );
};

export default LoginPage;
