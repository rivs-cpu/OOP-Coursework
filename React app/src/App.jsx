import { useState } from "react";
import Header from './components/Header.jsx';
import Footer from './components/Footer.jsx';
import ConfigurationForm from './components/ConfigurationForm.jsx';
import CalculationResults from './components/CalculationResults.jsx';
import LogDisplay from './components/LogDisplay.jsx';
import { startThreads, stopThreads } from './apiService'; // Import start and stop functions

function App() {
    const [isRunning, setIsRunning] = useState(false);
    const [submittedConfig, setSubmittedConfig] = useState(null);

    const handleStart = async () => {
        setIsRunning(true);
        await startThreads(); // Start backend threads
    };

    const handleStop = async () => {
        setIsRunning(false);
        setSubmittedConfig(null);
        await stopThreads(); // Stop backend threads
    };

    return (
        <div>
            <Header />
            <main>
                <div style={{ textAlign: "center", margin: "1rem" }}>
                    {!isRunning && <button onClick={handleStart}>Start</button>}
                    {isRunning && <button onClick={handleStop}>Stop</button>}
                </div>
                {isRunning && !submittedConfig && (
                    <ConfigurationForm setSubmittedConfig={setSubmittedConfig} />
                )}
                {submittedConfig && <CalculationResults submittedConfig={submittedConfig} />}
                <LogDisplay />
            </main>
            <Footer />
        </div>
    );
}

export default App;