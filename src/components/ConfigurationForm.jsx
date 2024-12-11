import { useState } from "react";

function ConfigurationForm({ setSubmittedConfig }) {
  const [config, setConfig] = useState({
    vendorDelay: 5000,
    customerDelay: 3000,
    totalTickets: 100,
  });
  const [error, setError] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (config.vendorDelay <= 0 || config.customerDelay <= 0 || config.totalTickets <= 0) {
      setError("All values must be greater than 0.");
      return;
    }
    setError("");
    setSubmittedConfig(config);
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Configuration Settings</h2>
      {error && <p style={{ color: "red", fontWeight: "bold" }}>{error}</p>}
      <label>
        Vendor Delay (ms):
        <input
          type="number"
          value={config.vendorDelay}
          onChange={(e) => setConfig({ ...config, vendorDelay: parseInt(e.target.value) })}
        />
      </label>
      <br />
      <label>
        Customer Delay (ms):
        <input
          type="number"
          value={config.customerDelay}
          onChange={(e) => setConfig({ ...config, customerDelay: parseInt(e.target.value) })}
        />
      </label>
      <br />
      <label>
        Total Number of Tickets:
        <input
          type="number"
          value={config.totalTickets}
          onChange={(e) => setConfig({ ...config, totalTickets: parseInt(e.target.value) })}
        />
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>
  );
}

export default ConfigurationForm;
