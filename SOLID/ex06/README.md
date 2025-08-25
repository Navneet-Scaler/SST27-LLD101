# Exercise ex06

How to run:
```bash
cd src
javac Demo06.java.java
java Demo06
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution : 
1. SOLID Violation : Liskov Substitution Principle (LSP)
Class Penguin is not a proper subtype of class Bird, because the method Aviary.release(Bird b) assumes every Bird can fly(), but Penguin cannot, breaking the expected behavior.