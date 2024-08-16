import React from 'react';

function Workers() {
  return (
    <div className="container">
      <h1>Workers</h1>
      <p>
        This section is dedicated to workers. Sign in or sign up to connect with others in the agricultural community.
      </p>
      <a href="/signin" className="btn btn-primary">Sign In</a>
      <a href="/signup" className="btn btn-secondary ms-2">Sign Up</a>
    </div>
  );
}

export default Workers;
