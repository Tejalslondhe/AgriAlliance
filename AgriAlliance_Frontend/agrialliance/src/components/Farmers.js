import React from 'react';
import { Link } from 'react-router-dom';

function Farmers() {
    return (
        <div>
            <h1>Farmers</h1>
            <Link to="/signup/farmer">Sign Up</Link>
            <Link to="/signin">Sign In</Link>
        </div>
    );
}

export default Farmers;
