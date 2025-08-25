# Exercise ex07

How to run:
```bash
cd src
javac Demo07.java.java
java Demo07
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution : 
1. SOLID Violation : Interface Segregation Principle (ISP)
Interface Machine violates the Interface Segregation Principle because it forces implementors like BasicPrinter to support print, scan, and fax, even though a simple printer doesn’t need scan or fax, leading to UnsupportedOperationException.