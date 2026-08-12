import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    axios.get("http://localhost:3000/employees")
    .then((response) => {
      setEmployees(response.data);
    })
    .catch((err) => {
      setError(err.message);
    })
    .finally(() => {
      setLoading(false);
    });
  }, []);

  if (loading) {
    return <div className="app-container"><h2 className="title">Loading Employees...</h2></div>;
  }

  if (error) {
    return <div className="app-container"><h2 className="title">Error: {error}</h2></div>;
  }

  return (
    <div className="app-container">
      <h1 className="title">Employee Details</h1>

      <div className="employee-grid">
        {employees.map((employee) => (
          <div key={employee._id || employee.employeeID} className="employee-card">
            <h2 className="employee-name">{employee.name}</h2>
            <h3 className="employee-designation">{employee.designation}</h3>

            <div className="employee-details">
              <p className="detail-item">
                <strong>ID:</strong> <span>{employee.employeeID}</span>
              </p>
              <p className="detail-item">
                <strong>Age:</strong> <span>{employee.age}</span>
              </p>
              <p className="detail-item">
                <strong>Experience:</strong> <span>{employee.experience} yrs</span>
              </p>
              <p className="detail-item">
                <strong>Salary:</strong> <span>₹{employee.salary}</span>
              </p>
              <p className="detail-item">
                <strong>Joining Date:</strong> <span>{new Date(employee.joiningDate).toLocaleDateString()}</span>
              </p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;