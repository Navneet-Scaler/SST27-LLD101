# Exercise ex02

How to run:
```bash
cd src
javac Demo02.java.java
java Demo02
```

Tasks:
- Identify the SOLID violation(s)
- Refactor to comply with all SOLID principles
- Keep behavior; add a tiny demo/test

Solution : 
- SOLID Violation(s)
1. Single responsibiltiy Principle - Player is doing, there are three responsibility in one class(decding raw byte in Frame, drawing UI, Caching).
2. Open/Close Principle - To support multiple decoding formats (MP3, MP4), we’d have to change Player.