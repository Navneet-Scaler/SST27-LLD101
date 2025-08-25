# Exercise ex09

How to run:
```bash
cd src
javac Demo09.java.java
java Demo09
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution 1
1. SOLID Violation : Dependency Inversion Principle (DIP)
Dependency Inversion Principle (DIP) is violated here because OrderController depends directly on the concrete class SqlOrderRepository, creating a hard dependency so it cannot work with a different repository (like InMemoryOrderRepository or NoSqlOrderRepository) without modifying the code.