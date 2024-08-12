import React from 'react';
import { Link } from 'react-router-dom';

function Doctors() {
    return (
        <div>
            <h1>Doctors</h1>
            <Link to="/signup/doctor">Sign Up</Link>
            <Link to="/signin">Sign In</Link>
        </div>
    );
}

export default Doctors;
