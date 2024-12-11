function CalculationResults({ submittedConfig }) {
    const { vendorDelay, customerDelay, totalTickets } = submittedConfig;

    // Example calculation: Total time for ticket release
    const totalReleaseTime = vendorDelay * totalTickets;
    const totalCustomerWaitTime = customerDelay * totalTickets;

    return (
        <div style={{ marginTop: "1rem", textAlign: "center" }}>
            <h2>Calculation Results</h2>
            <p><strong>Vendor Delay:</strong> {vendorDelay} ms</p>
            <p><strong>Customer Delay:</strong> {customerDelay} ms</p>
            <p><strong>Total Tickets:</strong> {totalTickets}</p>
            <hr />
            <p><strong>Total Time for Ticket Release:</strong> {totalReleaseTime} ms</p>
            <p><strong>Total Customer Wait Time:</strong> {totalCustomerWaitTime} ms</p>
        </div>
    );
}

export default CalculationResults;
