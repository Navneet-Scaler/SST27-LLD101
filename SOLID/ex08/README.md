# Exercise ex08

How to run:
```bash
cd src
javac Demo08.java.java
java Demo08
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution : 
1. SOLID Violation : Interface Segregation Principle (ISP)
Interface Vehicle violates the Interface Segregation Principle because it is too broad, assuming all vehicles must support startEngine(), pedal(), and recharge(), even though not every vehicle has all these capabilities.