# Exercise ex04

How to run:
```bash
cd src
javac Demo04.java.java
java Demo04
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution : 
1. Open/Close Principle : 
Adding a new provider (eg “CRYPTO”) requires editing the switch statement in PaymentService not extensible without modification.