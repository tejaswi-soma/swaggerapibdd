Feature: user wants to check  employee crud operation 

  @postTest
  Scenario Outline: user wants to Add employee record
    When user sends POST HTTP request
    Then  user adds  emp_id <id>, first_name <firstName>, last_name <lastName> and email <email>
    
  
  Examples:
  |  id   |   firstName   |    lastName    |            email                |
  |  3    |  Barbie       |     girl       |   barbie.girl@gmail.com         |
  |  4    |    chota      |     bean       |   chota.bean@gmail.com          |
  
  
  @deleteTest
  Scenario Outline: user wants to check delete operation
  Given user launches the application and sends a delete request
  When  user gives emp_id <id> to delete a record
  Then recevies HttpStatus as OK
  
  Examples:
  |  id  |
  |   5  |
  
  
  @geyByIdTest
  Scenario Outline: user checks for GET By ID operation
  Given user launches the application and send getById request
  When  user gives emp_id <id> to see a particular record
  Then  user recevies the empid <id>,firstName <firstName>,lastName <lastName>,email <email>
  
  Examples:
  | id  | firstName | lastName     |  email                  |
  |  1  | testUser  | testLastName |  abc@gmail.com          |
  |  2  |  Teju     | soma         | teju.soma@gmail.com     |