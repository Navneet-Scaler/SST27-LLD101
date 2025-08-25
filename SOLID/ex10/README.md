# Exercise ex10

How to run:
```bash
cd src
javac Demo10.java.java
java Demo10
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution 
1. SOLID Violation : DIP (Dependency Inversion Principle)
DIP (Dependency Inversion Principle) is violated because ReportService depends directly on the low-level class ConsoleLogger, making it difficult to switch to another logging mechanism like FileLogger or DbLogger without changing the code.