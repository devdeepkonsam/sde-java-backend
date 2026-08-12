import { useState } from "react";
import { useEffect } from "react";
import axios from "axios"


function App() {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    axios.get("http://localhost:5000/api/students")
      .then((response) => {
      setStudents(response.data);
    })
    .catch((err) => {
      setError(err.message);
    })
    .finally(() => {
      setLoading(false);
    });
  }, []);
  if (loading) {
    return <h1>loadig Students</h1>
  }
  if (error) {
    return <h2> Error : {error}</h2>
  }

  return (
    <>
      <div>
        <h1>Student List</h1>
        {students.map((student) => (
          <div key={student._id}>
            <h2>{student.name}</h2>
            <h3>{student.course}</h3>
            <p>{student.age}</p>
          </div>
        ))}
      </div>
    </>
  );
}

export default App;