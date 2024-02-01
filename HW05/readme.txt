School Announcement System (Observer Pattern)




Description:

--------------

This Java application demonstrates the Observer design pattern in a school setting. It allows high authorities to make announcements that are then broadcasted to students, teachers, and other workers in the school.




Classes:

- HighAuthority: Entity responsible for making announcements. Extends Observable class.

- Student, Teacher, Worker: Different groups in the school acting as observers. Each implements the Observer interface.

- Observable: Abstract class defining the structure for observables. Contains methods to add, remove, and notify observers.




Testing:

-----------

The application includes a set of JUnit tests to ensure proper functionality. These tests cover adding/removing observers, publishing announcements, and handling edge cases.