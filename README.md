Task Manager API

This is a simple Spring Boot app for managing your tasks. You can add new tasks, see all tasks, update them, or delete if not needed — all using REST APIs.

How to Run

First, clone this repo and run it locally on your machine:

git clone https://github.com/Gaoher-1207/160923733288-GaoherAli.git
cd 160923733288-GaoherAli
./mvnw spring-boot:run
better to use POSTMAN , and the commands are given below !!!

After that, open your browser or Postman and hit http://localhost:8080/tasks.

What You Can Do

Create a task with title, description, and status

Get list of all tasks or fetch one by ID

Update any task details you want

Delete a task when it’s done or not required

Remember, this app keeps data in memory only — so if you restart the app, data will get lost.

API Details
Method	URL	Description
POST	/tasks	Add new task
GET	/tasks	Get all tasks
GET	/tasks/{id}	Get task by ID
PUT	/tasks/{id}	Update task by ID
DELETE	/tasks/{id}	Delete task by ID
Sample JSON for Creating/Updating Task
{
  "taskTitle": "Finish Assignment",
  "taskDetails": "Complete the backend service by tonight",
  "taskStatus": "PENDING"
}
