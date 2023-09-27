# University Event Management

University Event Management is a Spring Boot application designed to manage student information and university events. It provides a set of RESTful APIs for adding, updating, deleting, and retrieving student and event data. This application uses an H2 database for data storage.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Building the Application](#building-the-application)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Data Models](#data-models)
- [Validation Rules](#validation-rules)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (version 8 or later)
- A development environment or IDE of your choice (e.g., IntelliJ, Eclipse)
- Gradle or Maven for building the project (Gradle recommended)

## Getting Started

### Building the Application

To build the application, follow these steps:

1. Clone this repository to your local machine.

2. Open the project in your preferred IDE.

3. Build the project using Gradle or Maven. For example, with Gradle:

  ## API Endpoints
  ***
 The following API endpoints are available:
  #### Student
* GET /students: Get a list of all students.
* GET /student/{studentId}: Get a student by ID.
* POST /students: Add a new student.
* PUT /student/{studentId}/department: Update a student's department.
* DELETE /students/{studentId}: Delete a student.
  #### Event
* GET /events: Get a list of all events.
* GET /event/{eventId}: Get an event by ID.
* POST /event: Add a new event.
* PUT /event/{eventId}: Update an event.
* DELETE /event/{eventId}: Delete an event.
* GET /event/by-date: Get all events by date.
***
## Data Models
#### Student
* studentId: Unique identifier for the student.
* firstName: First name of the student (capitalized).
* lastName: Last name of the student (capitalized).
* age: Age of the student (between 18 and 25).
* department: Department of the student (ME, ECE, CIVIL, CSE).
#### Event
* eventId: Unique identifier for the event.
* eventName: Name of the event.
* locationOfEvent: Location of the event.
* date: Date of the event.
* startTime: Start time of the event.
* endTime: End time of the event.
***
## Validation Rules
* Age must be between 18 and 25.
* First name must start with a capital letter.
* Department must be one of the following: ME, ECE, CIVIL, CSE.
 ***
 ## Service Classes
#### StudentService
The StudentService class handles business logic related to students, such as validation and data manipulation.
#### EventService
The EventService class handles business logic related to events, including date-based operations.
***
## Controller Classes
#### StudentController
The StudentController class defines API endpoints for managing student data. It interacts with the StudentService for business logic.
#### EventController
The EventController class defines API endpoints for managing event data. It interacts with the EventService for business logic.
