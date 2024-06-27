<!DOCTYPE html>
<html lang="en">
<body>
<h1>Spring MVC Calculator</h1>
<p>Spring MVC Calculator is a web application built using Spring Framework for basic arithmetic calculations.</p>

<h2>Table of Contents:</h2>
<ul>
    <li><a href="#introduction">Introduction</a></li>
    <li><a href="#features">Features</a></li>
    <li><a href="#setup">Setup</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#technologies">Technologies Used</a></li>
    <li><a href="#contributing">Contributing</a></li>
</ul>

<h2 id="introduction">Introduction:</h2>
<p>Spring MVC Calculator is a web application built using Spring Boot for basic arithmetic calculations. This project implements a simple calculator application using Spring MVC architecture. It allows users to perform arithmetic operations such as addition, subtraction, multiplication, and division. Additionally, the application incorporates robust validation features to enhance user experience and security. These validations include:</p>
<ul>
    <li>Arithmetic Operations: Users can perform various arithmetic operations, including addition, subtraction, multiplication, and division.</li>
    <li>User Authentication: The application enforces validation for login credentials, providing feedback for incorrect username or password entries.</li>
    <li>Registration Validation: During registration, the system validates input data, including username uniqueness, email uniqueness, and email format.</li>
    <li>Password Validation: The registration process includes password validation to ensure security, such as enforcing minimum length requirements and complexity rules.</li>
    <li>Negative Number Handling: The calculator includes validation to handle negative numbers, ensuring accurate and secure arithmetic calculations.</li>
</ul>

<h2 id="features">Features:</h2>
<ul>
    <li>User authentication and authorization</li>
    <li>Perform basic arithmetic calculations</li>
    <li>User-specific calculations history</li>
    <li>CRUD operations on calculations (admin only)</li>
</ul>

<h2 id="setup">Setup:</h2>
<p>To run this project locally, make sure you have Java, Maven, and a database program (such as XAMPP) installed on your system. Follow these steps:</p>
<ol>
    <li>Clone this repository to your local machine.</li>
    <li>Navigate to the project directory.</li>
    <li>Start your database program and ensure it's running.</li>
    <li>Once your database program is running, proceed to start the application.</li>
    <li>Once the application is running, open a web browser and go to <a href="http://localhost:8080">http://localhost:8080</a>.</li>
</ol>

<h2 id="usage">Usage:</h2>
<ol>
    <li>Register or login to your account.</li>
    <li>Use the calculator interface to perform arithmetic calculations.</li>
    <li>View your calculation history.</li>
    <li>Administrators can manage calculations (view, update, delete) of all users.</li>
    <li>Administrators can view all registered users.</li>
</ol>
<p><strong style="color: red;">IMPORTANT: Default new registered user role is USER. If you want to change the role to ADMIN (for more experiences like CRUD operations on calculator records or to see registered users), you have to change the ENUM ROLE radio button in the database.</strong></p>

<h2 id="technologies">Technologies Used:</h2>
<ul>
    <li>Java</li>
    <li>Spring Boot 3</li>
    <li>Spring Security 6</li>
    <li>Spring Data JPA</li>
    <li>Hibernate</li>
    <li>MySQL</li>
    <li>Thymeleaf</li>
    <li>HTML/CSS</li>
</ul>

<h2 id="contributing">Contributing:</h2>
<p>Contributions are welcome! If you find any bugs or have suggestions for improvement, please feel free to open an issue or submit a pull request.</p>
</body>
</html>
