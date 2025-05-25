# 🎓 Student Management System (Java + Swing + MySQL)

A **desktop-based Java application** to manage student records including **adding, editing, deleting, and viewing students**, with a user-friendly GUI using **Java Swing** and **MySQL** as the backend.

---

## 📌 Features

- 🔐 **Login Authentication** (admin credentials)
- 🧑‍💼 **Add Student** with validation (email, phone, etc.)
- ✏️ **Edit Student** details
- ❌ **Delete Student** by phone & email
- 📋 **View Students** in a table with dynamic search
- 📁 **MySQL Database Integration**
- 🎨 Polished GUI with consistent design

---

## 🛠️ Tech Stack

| Layer       | Technology         |
|-------------|--------------------|
| Frontend    | Java Swing (GUI)   |
| Backend     | Java               |
| Database    | MySQL              |
| UI Library  | JDateChooser (for DOB) |

---
## 📁 Project Structure
```
├── Login.java
├── Dashboard.java
├── AddStudent.java
├── DeleteStudent.java
├── EditStudent.java
├── EditStudent2.java
├── ViewStudents.java
└── Con.java
```

## 🔒 Default Login Credentials
**Username: admin**
**Password: 1234**

## ⚠️ Credentials are currently hardcoded. You can enhance it by integrating a users table or using secure password storage.


## 💡 Future Enhancements
- ✅ **Store login details in a secure database table**

- 📊 **Add student marks and report card generation**

- 📆 **Attendance tracking module**

- 🔎 **Advanced filters (by course, gender, etc.)**

- 🌐 **Web version using Java Spring Boot**

## ⚠️ Make sure to create required Database and Tables in your local system


---

## 📦 Download Executable (.jar)

You can download the pre-built `.jar` files from the link below:

🔗 [Download Student Management System JAR Files](https://drive.google.com/drive/folders/1WhUTdWqZrB5ly9YKRvjS0utfRmN_IuEg?usp=sharing)

> 📁 The `.jar` files can be run directly using:
```bash
java -jar StudentManagementSystem.jar
