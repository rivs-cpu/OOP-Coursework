import { useEffect, useState } from "react";
import { getLogs } from "../apiService";

function LogDisplay() {
  const [logs, setLogs] = useState([]);

  // useEffect(() => {
  //   fetchLogs();
  // }, []);

  // const fetchLogs = async () => {
  //   try {
  //     const response = await getLogs();
  //     setLogs(response.data);
  //   } catch (error) {
  //     console.error('Error fetching logs:', error);
  //   }
  // };

  useEffect(() => {
    fetchLogs();
  }, []);

  const fetchLogs = async () => {
    try {
      const response = await getLogs();
      console.log(response.data); // Verify the data structure
      setLogs(response.data);
    } catch (error) {
      console.error("Error fetching logs:", error);
    }
  };

  return (
    <div>
      <h2>Log Display</h2>
      <div className="log-display">
        <ul>
          {logs.map((log, index) => (
            <li key={index}>{log}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default LogDisplay;
