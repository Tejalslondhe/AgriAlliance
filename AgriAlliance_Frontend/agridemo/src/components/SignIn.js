import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import '../styles/SignIn.css'; // Ensure this file exists or adjust as needed

const SignIn = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const location = useLocation();
  const queryParams = new URLSearchParams(location.search);
  const category = queryParams.get('category') || 'FARMER'; // Default to FARMER if no category

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    console.log('Form data:', formData); // Debugging line to check form data

    try {
      // Determine endpoint based on role
      const endpoint = `/api/${category.toLowerCase()}/signin`;

      // Send POST request to the backend
      const response = await fetch(endpoint, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const data = await response.json();

      // Handle success response
      console.log('Sign-in successful:', data);
      // Optionally, redirect to a dashboard or show a success message
      // e.g., window.location.href = '/dashboard'; or use navigate() from react-router

    } catch (error) {
      // Handle error response
      console.error('Sign-in error:', error);
      // Optionally, show an error message to the user
    }
  };

  return (
    <div className="signin-container">
      <h1>Sign In</h1>
      <p>Welcome to the {category.charAt(0).toUpperCase() + category.slice(1)} section. Please sign in to continue.</p>
      <form onSubmit={handleSubmit} className="signin-form">
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit" className="signin-btn">Sign In</button>
        <div className="links">
          <a href="/signup">Not yet registered? Sign Up</a>
          <a href="/forgot-password">Forgot Password?</a>
        </div>
      </form>
    </div>
  );
};

export default SignIn;
