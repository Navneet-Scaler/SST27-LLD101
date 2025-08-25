# Exercise ex05

How to run:
```bash
cd src
javac Demo05.java.java
java Demo05
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution : 
1. Liskov Substitution Principle (LSP) Violation : 
In this design, class Square is not a proper subtype of class Rectangle, because the method areaAfterResize(Rectangle r) assumes independent setWidth() and setHeight() methods, but Square overrides them to always keep width = height, breaking the expected behavior.