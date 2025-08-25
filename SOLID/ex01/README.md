# Exercise ex01

How to run:
```bash
cd src
javac Demo01.java.java
java Demo01
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution : 
- The OrderService is doing too much like sending email and data also. There is voilation of Single Responsibility Principle(SRP). 
- 