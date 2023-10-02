import { useParams, Link } from 'react-router-dom';
import React from 'react';

function ConfirmDelete() {
  const { id } = useParams(); // Get the agent ID from the URL

  // Function to confirm deletion
  // placeholder code, Esin does not want window.confirm
  function confirmDeletion(agentId) {
    const confirmDeletion = window.confirm(`Are you sure you want to delete the agent with ID: ${agentId}?`); 

    if (confirmDeletion) {
      // Send a DELETE request to the API
      fetch(`http://localhost:8080/api/agent/${agentId}`, {
        method: 'DELETE'
      })
        .then(response => {
          if (response.ok) {
            // Agent deleted successfully, you can navigate back to the agent list using a Link
          } else {
            console.error('Failed to delete agent');
          }
        })
        .catch(error => {
          console.error(error);
        });
    }
  }

  return (
    <div>
      <h1>Delete Agent</h1>
      <p>Are you sure you want to delete this agent?</p>
      <button
        onClick={() => confirmDeletion(id)}
        className="btn btn-danger me-2"
      >
        Delete
      </button>
      <Link to="/list" className="btn btn-secondary">Cancel</Link>
    </div>
    
  );
}

export default ConfirmDelete;