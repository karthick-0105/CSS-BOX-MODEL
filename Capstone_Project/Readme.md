# **🏥 Hospital Management System – Spring Boot (Capstone Project)**

The Hospital Management System is a Java Full Stack web application developed to automate and manage hospital operations efficiently. It provides a secure, role-based system for Admin, Doctor, and Patient users, enabling smooth appointment scheduling, approval workflows, and centralized hospital management.

This project is designed to replace manual hospital processes with a digital solution that improves efficiency, transparency, and data accuracy.

**Drive Link:https://drive.google.com/drive/folders/1nmASd-ZB52DREtfL-8ihqKzLYxb8JwRI?usp=drive_link**

## **📌 Project Overview**

* **Project Type:** Java Full Stack Web Application

* **Architecture:** RESTful, Layered Architecture

* **Roles Supported:** Admin, Doctor, Patient

* **Core Focus: **Appointment management & hospital workflow automation

## **✨ Key Features**

### **👤 Authentication & Role Management**

* Secure login system for Admin, Doctor, and Patient

* Role-based access control

* New patient registration functionality

### 🧑‍⚕️ **Patient Module**

* Patient registration and login

* View hospital departments and doctors

* Book appointments with preferred doctor, date, and time slot
 
* View appointment status and doctor remarks

### **🛠️ Admin Module**

* Manage doctors and patients

* View and approve/reject appointment requests

* Monitor appointment status

* Analytics dashboard for hospital insights

### **🩺 Doctor Module**

* Update availability status

* View appointments approved by admin

* Accept or reject appointments with reason

* Communicate appointment decisions to patients

### **🔄 Appointment Workflow**

* Patient → Admin Approval → Doctor Approval

* Real-time appointment status updates

* Emergency and normal appointment priority support

### **🧪 API Testing**

* REST APIs tested using Postman

* Full CRUD operations verified

* JSON-based request and response handling

## **🛠️ Tech Stack**
| Layer | Technology |
|------|------------|
| Backend | Java 17, Spring Boot |
| Frontend | HTML5, CSS3, JavaScript |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA (Hibernate) |
| Server | Embedded Tomcat |
| Build Tool | Maven |
| Testing Tool | Postman |
| IDE | Spring Tool Suite (STS) |


## **🏗️ Project Architecture**

* **Controller Layer:** Handles HTTP requests (REST APIs)

* **Service Layer:** Business logic implementation

* **Repository Layer:** Database operations using JPA

* **Database Layer:** MySQL for persistent storage

The application follows a clean MVC + Layered Architecture, ensuring scalability and maintainability.

## **⚙️ Setup & Installation**
### **1️⃣ Prerequisites**

* Java JDK 17

* Maven

* MySQL Server

* Spring Tool Suite (STS) or Eclipse

* Postman (for API testing)

### **2️⃣ Database Configuration**

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=9095

### **3️⃣ Run the Application**
mvn spring-boot:run


Access the application at:
👉 http://localhost:9095/index.html

## **🔍 API Testing (Postman)**

GET /patients – Fetch all patients

POST /patients – Create new patient

POST /appointments – Book appointment

GET /appointments – View appointment list

PUT /appointments/{id} – Update appointment status

All APIs return JSON responses and follow REST standards.

## **🚀 Future Enhancements**

* Spring Security + JWT authentication

* Online payment gateway integration

* Email & SMS notifications

* Electronic Medical Records (EMR)

* Advanced analytics dashboards

* Mobile application (React Native / Flutter)

* Cloud deployment (AWS / Azure)

## **🎓 Learning Outcomes**

* Hands-on experience with Java Full Stack development

* REST API design and testing

* Role-based system implementation

* Real-world workflow automation

* Database design and integration

## **📌 Conclusion**

This project demonstrates a practical and real-world implementation of hospital workflow automation using modern Java technologies. It serves as a strong capstone project and reflects industry-relevant development practices.

### Created by Karthick C

### B.Tech – Information Technology
