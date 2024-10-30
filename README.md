# Event-Management-System

This project is an Event Management System, consisting of a Spring Boot backend and a React frontend. The backend handles API requests, while the frontend provides a user interface to manage events and attendees.

## Prerequisites

- Java 17 or higher
- Node.js 14 or higher
- npm (comes with Node.js)
- MySQL database
- Maven (for building the Spring Boot project)

## Backend Setup (Spring Boot)

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/event-management-system.git
cd event-management-system
```

### 2. Configure the Database

Update the `application.properties` file located in `src/main/resources` with your database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```


### 3. Build and Run the Backend

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The backend should now be running on `http://localhost:8080`.

## Frontend Setup (React)

### 1. Navigate to the Frontend Directory

```bash
cd frontend
```

### 2. Install Dependencies

```bash
npm install
```

### 3. Start the Frontend

```bash
npm start
```

The frontend should now be running on `http://localhost:3000`.

## API Endpoints

The backend provides the following API endpoints:

- **GET /api/events**: Fetch all events
- **POST /api/events**: Add a new event
- **PUT /api/events/{id}**: Update an event by its ID
- **DELETE /api/events/{id}**: Delete an event by its ID
- **POST /api/events/{eventId}/attendees**: Register an attendee to an event

## Running the Application

1. Start the backend by running the Spring Boot application.
2. Start the frontend by running the React application.
3. Open your browser and navigate to `http://localhost:3000` to interact with the Event Management System.

## Notes

- Ensure your database server is running before starting the backend.
- You can modify the database configuration in the `application.properties` file to suit your setup.
- The frontend uses Axios to make API requests to the backend.


