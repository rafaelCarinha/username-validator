# INTERTEC :username-validator

Project Created using:

-Spring Boot <br />
-H2 Embedded Database <br />
-Lombok <br />
-Java 8 <br />
-Junit <br />

Run Tests: mvn test <br />
Run Project: mvn spring-boot:run <br />

Some url examples: <br />
curl -i -X POST -H "Content-Type:text/plain" -d "cannabis" http://localhost:8080/user <br />
curl -i -X POST -H "Content-Type:text/plain" -d "rafael" http://localhost:8080/user <br />

curl http://localhost:8080/users <br />

curl http://localhost:8080/forbiddenWords <br />

On startup, the project reads forbiddenWords.txt file (Words can be added freely on this file): <br />
cannabis <br />
abuse <br />
crack <br />
damn <br />
drunk <br />
grass <br />

And saves forbidden words on H2 embedded database. <br />

When POST method called, the class UserService checks: <br />
-if username is not forbidden, not null or empty, or not under 6 characters <br />

If none of the forbidden rules are present, saves userName on H2 embedded database. <br />
Otherwise, returns a Map<Boolean, List<String>>, with the possible words that can be used. <br />
