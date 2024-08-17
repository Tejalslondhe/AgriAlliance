import React, { useState } from 'react';
import { Container, Form, Button, Alert } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const CROP_OPTIONS = [
  'CEREALS', 'PULSES', 'SUGARCANE', 'FRUITS', 'OILSEEDS',
  'HORTICULTURE', 'BEVERAGE_CROPS', 'RUBBER', 'FIBER_CROPS'
];

const SKILL_OPTIONS = [
  'AGRICULTURE', 'FARMING', 'HARVESTING', 'PLANTING', 'IRRIGATION',
  'MACHINERY_OPERATION', 'PEST_CONTROL', 'LIVESTOCK_MANAGEMENT',
  'SOIL_CARE', 'CROP_CARE'
];

const SPECIALIZATION_OPTIONS = [
  'CROP_SCIENCE', 'SOIL_SCIENCE', 'PLANT_PATHOLOGY', 'AGRICULTURAL_ENTOMOLOGY',
  'AGRICULTURAL_ECONOMICS', 'HORTICULTURE', 'IRRIGATION_ENGINEERING',
  'AGRONOMY', 'AGRICULTURAL_ENGINEERING', 'PEST_MANAGEMENT'
];

const RegistrationPage = () => {
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    contactNumber: '',
    aadharNo: '',
    role: 'FARMER',
    specialization: '',
    crop: '',
    noOfGroupMembers: 0,
    skills: ''
  });

  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleRoleChange = (e) => {
    setFormData({
      ...formData,
      role: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError('');

    const urlMap = {
      FARMER: 'http://localhost:8080/auth/farmers/signup',
      MERCHANT: 'http://localhost:8080/auth/merchants/signup',
      WORKER: 'http://localhost:8080/auth/workers/signup',
      DOCTOR: 'http://localhost:8080/auth/doctors/signup'
    };

    try {
      const response = await axios.post(urlMap[formData.role], formData);

      if (response.status === 200 || response.status === 201) {
        navigate('/login');
      } else {
        setError('Registration failed');
      }
    } catch (err) {
      setError('An error occurred');
    } finally {
      setLoading(false);
    }
  };

  return (
    <Container className="registration-container">
      <h2 className="text-center mb-4">Register</h2>
      {error && <Alert variant="danger">{error}</Alert>}
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formFirstName">
          <Form.Label>First Name</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter your first name"
            name="firstName"
            value={formData.firstName}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group controlId="formLastName">
          <Form.Label>Last Name</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter your last name"
            name="lastName"
            value={formData.lastName}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group controlId="formEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            placeholder="Enter your email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group controlId="formContactNumber">
          <Form.Label>Contact Number</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter your contact number"
            name="contactNumber"
            value={formData.contactNumber}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group controlId="formPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            placeholder="Enter your password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group controlId="formAadharNo">
          <Form.Label>Aadhar No</Form.Label>
          <Form.Control
            type="text"
            placeholder="Enter your Aadhar number"
            name="aadharNo"
            value={formData.aadharNo}
            onChange={handleChange}
            required
          />
        </Form.Group>
        <Form.Group controlId="formRole">
          <Form.Label>Role</Form.Label>
          <Form.Control
            as="select"
            name="role"
            value={formData.role}
            onChange={handleRoleChange}
          >
            <option value="FARMER">FARMER</option>
            <option value="MERCHANT">MERCHANT</option>
            <option value="WORKER">WORKER</option>
            <option value="DOCTOR">DOCTOR</option>
          </Form.Control>
        </Form.Group>
        {formData.role === 'DOCTOR' && (
          <Form.Group controlId="formSpecialization">
            <Form.Label>Specialization</Form.Label>
            <Form.Control
              as="select"
              name="specialization"
              value={formData.specialization}
              onChange={handleChange}
              required
            >
              <option value="">Select Specialization</option>
              {SPECIALIZATION_OPTIONS.map((option) => (
                <option key={option} value={option}>{option}</option>
              ))}
            </Form.Control>
          </Form.Group>
        )}
        {formData.role === 'MERCHANT' && (
          <Form.Group controlId="formCrop">
            <Form.Label>Crop</Form.Label>
            <Form.Control
              as="select"
              name="crop"
              value={formData.crop}
              onChange={handleChange}
              required
            >
              <option value="">Select Crop</option>
              {CROP_OPTIONS.map((option) => (
                <option key={option} value={option}>{option}</option>
              ))}
            </Form.Control>
          </Form.Group>
        )}
        {formData.role === 'WORKER' && (
          <>
            <Form.Group controlId="formNoOfGroupMembers">
              <Form.Label>No. of Group Members</Form.Label>
              <Form.Control
                type="number"
                placeholder="Enter number of group members"
                name="noOfGroupMembers"
                value={formData.noOfGroupMembers}
                onChange={handleChange}
                required
              />
            </Form.Group>
            <Form.Group controlId="formSkills">
              <Form.Label>Skills</Form.Label>
              <Form.Control
                as="select"
                name="skills"
                value={formData.skills}
                onChange={handleChange}
                required
              >
                <option value="">Select Skill</option>
                {SKILL_OPTIONS.map((option) => (
                  <option key={option} value={option}>{option}</option>
                ))}
              </Form.Control>
            </Form.Group>
            <Form.Group controlId="formCrop">
              <Form.Label>Crop</Form.Label>
              <Form.Control
                as="select"
                name="crop"
                value={formData.crop}
                onChange={handleChange}
                required
              >
                <option value="">Select Crop</option>
                {CROP_OPTIONS.map((option) => (
                  <option key={option} value={option}>{option}</option>
                ))}
              </Form.Control>
            </Form.Group>
          </>
        )}
        <Button variant="primary" type="submit" disabled={loading}>
          {loading ? 'Registering...' : 'Register'}
        </Button>
      </Form>
    </Container>
  );
};

export default RegistrationPage;
