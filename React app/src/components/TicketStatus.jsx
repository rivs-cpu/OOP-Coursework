import { useState, useEffect } from "react";
import { getAllTickets } from './apiService';

function TicketStatus() {
  const [tickets, setTickets] = useState([]);

  useEffect(() => {
    fetchTickets();
  }, []);

  const fetchTickets = async () => {
    try {
      const response = await getAllTickets();
      setTickets(response.data);
    } catch (error) {
      console.error('Error fetching tickets:', error);
    }
  };

  return (
    <div>
      <h2>Ticket Status</h2>
      <ul>
        {tickets.length > 0 ? (
          tickets.map((ticket) => (
            <li key={ticket.id}>
              {ticket.event} - {ticket.available ? "Available" : "Sold Out"}
            </li>
          ))
        ) : (
          <p>No tickets available. Configure the system to generate tickets.</p>
        )}
      </ul>
    </div>
  );
}

export default TicketStatus;
