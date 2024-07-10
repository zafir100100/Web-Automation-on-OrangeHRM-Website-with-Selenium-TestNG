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

## Allure report Screenshots:
![Screenshot (70)](https://user-images.githubusercontent.com/29010350/202966487-aadd8618-43fb-4bf8-9553-d372a6605bb4.png)
![Screenshot (71)](https://user-images.githubusercontent.com/29010350/202966495-8be3d4ec-1f5c-478f-9bbe-a43509b14b99.png)
![Screenshot (72)](https://user-images.githubusercontent.com/29010350/202966510-cc1bf699-a60d-4058-a5c2-13d91f3608bf.png)

## Gradle report Screenshots:
![image](https://github.com/zafir100100/Web-Automation-on-OrangeHRM-Website-with-Selenium-TestNG/assets/55599023/d3309015-93f2-45dd-ace5-a6d28cfa2e0b)
![image](https://github.com/zafir100100/Web-Automation-on-OrangeHRM-Website-with-Selenium-TestNG/assets/55599023/13e62cb3-b9c8-4566-97be-d2d571b4a27d)
![image](https://github.com/zafir100100/Web-Automation-on-OrangeHRM-Website-with-Selenium-TestNG/assets/55599023/a560b839-e693-4427-808c-8cb99d2bc7ed)
![image](https://github.com/zafir100100/Web-Automation-on-OrangeHRM-Website-with-Selenium-TestNG/assets/55599023/d7f62017-9825-4135-9f42-78471ee3e285)
![image](https://github.com/zafir100100/Web-Automation-on-OrangeHRM-Website-with-Selenium-TestNG/assets/55599023/97fbabcf-3cc1-46cb-afb6-18ab1babe58e)











