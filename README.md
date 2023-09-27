# <h1 align ="center"> University Event Management</h1>

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
* `GET /students`: Get a list of all students.
* `GET /student/{studentId}`: Get a student by ID.
* `POST /students`: Add a new student.
* `PUT /student/{studentId}/department`: Update a student's department.
* `DELETE /student/id/{id}`: Delete a student.
  #### Event
* `GET /events`: Get a list of all events.
* `GET /event/id/{id}`: Get an event by ID.
* `POST /event`: Add a new event.
* `PUT /event/{eventId}`: Update an event.
* `DELETE /event/{eventId}`: Delete an event.
* `GET /event/by-date`: Get all events by date.
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
``` java
@Service

public class Studentservice {
    @Autowired
    Istudentrepo iStudentrepo;







    public String addStudents(List<Student> newstudents) {
    iStudentrepo.saveAll(newstudents);
    return newstudents.size()+ "student added";
    }

    public List<Student> getAllStudents() {
        return  iStudentrepo.findAll();
    }

    public Student getStudentById(Long id) {
        return iStudentrepo.findById(id).get();
    }


    public String deleteStudentById(Long id) {
         iStudentrepo.deleteById(id);
         return "student removed";
    }

    public Student updateStudentDepartment(Long studentId, Department newDepartment) {
        Student existingStudent = iStudentrepo.findById(studentId).orElse(null);

        if (existingStudent != null) {
            existingStudent.setDepartment(newDepartment);
            return  iStudentrepo.save(existingStudent);
        } else {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }
    }
}
```
#### EventService
The EventService class handles business logic related to events, including date-based operations.
``` java
@Service

public class Eventservice {
    @Autowired
    IEventrepo iEventrepo;

    public String addEvents(List<Event> newevents) {
        iEventrepo.saveAll(newevents);
        return newevents.size()+" event added";
    }

    public String removeEventsByIds(List<Long> ids) {
         iEventrepo.deleteAllById(ids);
         return " event removed";
    }

    public List<Event> getAllEventsByDate(LocalDate localDate) {
        return iEventrepo.findAllByDate(localDate);
```
***
## Controller Classes
#### StudentController
The StudentController class defines API endpoints for managing student data. It interacts with the StudentService for business logic.
``` java
@RestController
@Validated

public class Studentcontroller {
    @Autowired
    Studentservice studentservice;
    //1.add students
    @PostMapping("students")
    public String addstudents(@RequestBody @Valid List<Student> newstudents)
    {
          return   studentservice.addStudents(newstudents);

    }
    //2.get allstudents
    @GetMapping("students")
    public List<Student> getallstudents()
    {
        return studentservice.getAllStudents();
    }
    //3.get student by id
    @GetMapping("students/id/{id}")

        public Student getstudentsbyid( @PathVariable @Valid Long  id)
        {
            return studentservice.getStudentById(id);

        }
        //4.detete student
    @DeleteMapping("student/id/{id}")
    public String deletestudent(@PathVariable @Valid Long id){
     return  studentservice.deleteStudentById(id);
    }
    //5. update student department
    @PutMapping("/{studentId}/updateDepartment/{department}")
    public Student updatestudentdepartment(
            @PathVariable Long studentId,
            @PathVariable Department newDepartment
    ) {
        return studentservice.updateStudentDepartment(studentId, newDepartment);
    }




}
```
#### EventController
The EventController class defines API endpoints for managing event data. It interacts with the EventService for business logic.
``` java
RestController
@Validated

public class Eventcontroller {
    @Autowired
    Eventservice eventservice;
    //1.add events
    @PostMapping("events")
    public String addevents(@RequestBody @Valid List<Event> newevents)
    {
        return eventservice.addEvents(newevents);
    }
    ///2. delete events
    @DeleteMapping("remove/ids")
    public String deleteeventsbyids(List<Long> ids)
    {
        return eventservice.removeEventsByIds(ids);
    }
    //3. get all events by date by custom finder
    @GetMapping("eventby/Date")
    public List<Event> getEventsByDate(@RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date); // Convert the date string to LocalDate
        return eventservice.getAllEventsByDate(localDate);
    }
}
```
