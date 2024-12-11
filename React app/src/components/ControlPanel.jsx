import axios from 'axios';

function ControlPanel() {
  const startVendor = () => axios.post('/api/vendor/start');
  const stopVendor = () => axios.post('/api/vendor/stop');
  const startCustomer = () => axios.post('/api/customer/start');
  const stopCustomer = () => axios.post('/api/customer/stop');

  return (
    <div>
      <h2>Control Panel</h2>
      <button onClick={startVendor}>Start Vendor</button>
      <button onClick={stopVendor}>Stop Vendor</button>
      <button onClick={startCustomer}>Start Customer</button>
      <button onClick={stopCustomer}>Stop Customer</button>
    </div>
  );
}

export default ControlPanel;
