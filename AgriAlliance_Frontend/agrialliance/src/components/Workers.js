import React from 'react';
import { Link } from 'react-router-dom';

function Workers() {
    return (
        <div>
            <h1>Workers</h1>
            <Link to="/signup/worker">Sign Up</Link>
            <Link to="/signin">Sign In</Link>
        </div>
    );
}

export default Workers;
