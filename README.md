# Real-Time Ticketing System

This is a full-stack real-time ticketing system that includes a frontend (React.js), backend (Spring Boot), and a command-line interface (CLI) implementation. The system supports ticket management with features for real-time synchronization, multi-threaded operations, and user interaction.

---

## Features

### Frontend (React.js)
- **User Interface**: Intuitive layout with sections for configuration, control panel, ticket status, and real-time logs.
- **Interactive Elements**: Forms, buttons, and notifications for seamless interaction.
- **Real-Time Data Updates**: WebSocket/polling support to fetch updates from the backend.

### Backend (Spring Boot)
- **RESTful API**: Endpoints for ticket operations (add, purchase, delete).
- **Concurrency Management**: Thread-safe operations using `ReentrantLock`.
- **Scheduler**: Automatic vendor and customer operations with fixed intervals.
- **Database**: Persistent data storage with JPA and H2/MySQL support.

### CLI
- **Configuration Options**: Customizable system parameters (e.g., ticket capacity, rates).
- **Real-Time Monitoring**: Live status and logs for ticket operations.
- **Producer-Consumer Pattern**: Multi-threaded synchronization for vendors and customers.

---

## Getting Started

### Prerequisites
- **Node.js** (for the frontend)
- **Java 11** (for the backend and CLI)
- **Maven** (for backend dependency management)
- **MySQL** (optional for persistent storage)

---

## Installation and Setup

### Frontend
1. Navigate to the `frontend` directory.
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm run dev
   ```

### Backend
1. Navigate to the `backend` directory.
2. Update `application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ticketing_system?createDatabaseIfNotExist=true
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   ```
3. Build and run the backend:
   ```bash
   mvn spring-boot:run
   ```

### CLI
1. Compile and run the CLI application:
   ```bash
   javac Main.java
   java Main
   ```

---

## Usage

### Frontend
- Navigate to `http://localhost:5173` to access the frontend interface.
- Configure system parameters and start/stop operations via the control panel.

### Backend
- API Endpoints:
  - `GET /api/tickets`: Retrieve all tickets.
  - `POST /api/tickets`: Add a new ticket.
  - `POST /api/tickets/purchase/{id}`: Purchase a ticket.
  - `DELETE /api/tickets/{id}`: Delete a ticket.

### CLI
- Follow the prompts to configure the system.
- Monitor live operations and stop threads when needed.

---

## Project Structure

### Frontend
- `src/components`: Contains React components like `ConfigurationForm`, `ControlPanel`, and `LogDisplay`.
- `src/apiService.js`: Handles API requests to the backend.

### Backend
- `controller/`: REST API controllers.
- `service/`: Business logic for ticket and log operations.
- `model/`: JPA entities.
- `repository/`: Data access layer.

### CLI
- `Main.java`: Entry point of the CLI.
- `SystemConfiguration.java`: Handles user input for system settings.
- `TicketPool.java`: Shared resource for managing tickets.

---

## Technologies Used

### Frontend
- React.js
- Material-UI
- Axios

### Backend
- Spring Boot
- JPA (H2/MySQL)
- Maven

### CLI
- Java Multi-threading

---

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## Contributors
- **[Rivini Mahadurage]** - Developer
