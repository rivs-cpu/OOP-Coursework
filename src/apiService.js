import axios from 'axios';

const API_URL = 'http://localhost:8080/api/tickets';

export const getAllTickets = () => axios.get(API_URL);
export const addTicket = (ticket) => axios.post(API_URL, ticket);
export const purchaseTicket = (id) => axios.post(`${API_URL}/purchase/${id}`);
export const deleteTicket = (id) => axios.delete(`${API_URL}/${id}`);

// Fetch logs
export const getLogs = () => axios.get('http://localhost:8080/api/logs');

// Start and stop threads
export const startThreads = () => axios.post('http://localhost:8080/api/scheduler/start');
export const stopThreads = () => axios.post('http://localhost:8080/api/scheduler/stop');