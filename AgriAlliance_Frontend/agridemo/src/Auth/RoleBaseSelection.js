// RoleSelectionPage.js
import React from 'react';
import { useNavigate } from 'react-router-dom';
import './RoleBaseSelection.css';

const RoleSelectionPage = () => {
  const navigate = useNavigate();

  const handleRoleSelection = (role) => {
    navigate(`/login?role=${role}`);
  };

  return (
    <div className="role-selection-container">
      <h2>Select Your Role</h2>
      <button onClick={() => handleRoleSelection('FARMER')}>Farmer</button>
      <button onClick={() => handleRoleSelection('MERCHANT')}>Merchant</button>
      <button onClick={() => handleRoleSelection('WORKER')}>Worker</button>
      <button onClick={() => handleRoleSelection('DOCTOR')}>Doctor</button>
    </div>
  );
};

export default RoleSelectionPage;
