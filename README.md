# OrangeHRM-Website-Automation-with-Selenium-TestNG

## Video Output:
https://user-images.githubusercontent.com/29010350/202970620-16e4db42-dbb7-4186-8107-188a77a6edba.mp4

## Scenario
1. Visit the site: https://opensource-demo.orangehrmlive.com/ 
2. Do log-in with invalid credential
3. Do log-in with valid credential
4. Go to dashboard page
5. Scroll down to bottom
6. Assert the OS version

## Technology and Tool Used
- Selenium Webdriver
- TestNG
- Java
- Gradle
- intellij idea 
- Allure

## How to run this project
- clone this project
- Hit the following command into the terminal:
  ```gradle clean test```
- Generate the report:
  ```
  allure generate allure-results --clean -o allure-report
  ```
- Serve the report:
  ```
  allure serve allure-results
  ```     

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




