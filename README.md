# Student-Management-System

Student Management System is a Java-based application designed to efficiently manage student records. It allows administrators to add, update, delete, and view student details including names, roll numbers, grades, and contact information. This project demonstrates the use of Object-Oriented Programming, file handling or database integration, and a user-friendly interface for managing student data. Ideal for schools, colleges, or training centers.

Sure Reb! Here's a short and clear description of how the program works and the purpose of each main function:

🧾 Program Overview:
The Student Management System allows an admin to register learners, add subjects, assign training, record assessments, and view report cards. It simulates a basic academic record management flow using Java OOP and console input.

📌 Key Components and Their Functions:

* addLearner(): Registers a new learner with name and email, assigns a unique ID.
* addSubject(): Adds a new subject (with code and name) to the system.
* assignTraining(): Enrolls a learner in a subject and marks training as completed.
* recordMarks(): Records marks for a learner in a specific subject.
* showReport(): Displays all marks scored by a learner in enrolled subjects.
* getLearnerById(), getSubjectByCode(): Utility methods to find learners and subjects by ID/code.

📦 Flow:

1. Admin interacts via menu options.
2. Learners and subjects are stored in lists.
3. Results are tracked in a Map with learner ID as key.
4. Console-based input/output is used for demonstration.
