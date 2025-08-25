# Exercise ex03

How to run:
```bash
cd src
javac Demo03.java.java
java Demo03
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution :
1. Open/Close Principle
- Adding a new shipping type (e.g., “SAME_DAY”) requires changing ShippingCostCalculator - Class is not closed for modification