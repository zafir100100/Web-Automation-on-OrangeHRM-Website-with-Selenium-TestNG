# OrangeHRM-Website-Automation-with-Selenium-TestNG

## Video Output:
https://user-images.githubusercontent.com/29010350/202970620-16e4db42-dbb7-4186-8107-188a77a6edba.mp4

## Scenerio
1. Visit the site: https://opensource-demo.orangehrmlive.com/ 
2. Assert the dashboard 
3. Create 2 new employees (create login details showed on class) 
4. Search the employees with their Id and assert that 2 employees are found 
5. Then login with the last employee credential 
6. Update some employee info (e.g Nationality, Date of Birth) 
7. Now go to my info page and assert the edited info 
8. Finally logout your profile 

## Technology and Tool Used
- Selenium Webdriver
- TestNG
- Java
- Gradle
- intellij idea 
- Allure


## How to run this project
- clone this project
- hit the following command into the terminal:
  - gradle clean test
- Generate the report:
  ```
  allure generate allure-results --clean -o allure-report
  ```
- Serve the report:
  ```
  allure serve allure-results
  ```     
 

## Prerequisite
- TestNG,Selenium Webdriver,Java-8 or higher dependencies must be installed

## Test Case
https://docs.google.com/spreadsheets/d/1sgdJhgJvCln8mgWNCwwlEcox8TOVxQJKA7i6QfJAueI/edit?usp=sharing

## Allure report Link
https://drive.google.com/file/d/1KZMQVfcieIaAM3bEw7Q_kNNSHL3RrjJ3/view?usp=sharing


## Gradle report Link
https://drive.google.com/file/d/1VekbGwzi4FekXbFt9tNWhQpyWcXQ7F4W/view?usp=sharing

## Allure report Screenshots:
![Screenshot (70)](https://user-images.githubusercontent.com/29010350/202966487-aadd8618-43fb-4bf8-9553-d372a6605bb4.png)
![Screenshot (71)](https://user-images.githubusercontent.com/29010350/202966495-8be3d4ec-1f5c-478f-9bbe-a43509b14b99.png)
![Screenshot (72)](https://user-images.githubusercontent.com/29010350/202966510-cc1bf699-a60d-4058-a5c2-13d91f3608bf.png)

## Gradle report Screenshots:
![Screenshot (73)](https://user-images.githubusercontent.com/29010350/202966546-b954e2ff-1823-4745-9f87-03eeded453e4.png)




