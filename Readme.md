
  #  Student Management System
## Description
  Student management system using persistence layer to store students data in the database and fetching students data by APIs.
  
## Features: 
- Add (Create) student data in the database by using JpaRepository
- Fetch (Read) students data by calling API endpoint
- Delete (Delete) student data by id, if student id matches in the database
- Update (Update) Student data by id, if student id exists in the database
- Fetch (Read by id) Student data by id, if student id exists in the database
- Partial update (Patch) student data by id, if student id matches then update your field you want
- Add Validation whenever user doesn't follow validation rule then throw error and pop-up message what user did wrong

## Project Structure:
- Student Controller - Manage API requests
- Student Entity - Create data fields table in the database
- Student Dto (Data transfer object) - Transfer data to entity class which interacts with the database
- Student Repository - Using JpaRepository interface function to store/save data in the database
- Student Service - Transfer data from Dto to Entity and Entity to Dto. create feature by adding business logic
- Student TestCase - Using (@Test) annotation to execute test which is passed my machine

## How To Run Application:
- Run main springboot application and then use your postman to fetch data of student by using APIs endpoint