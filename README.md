# neo-java

to build and do code coverage run the following command:

```
mvn clean install site;
```

to build, do code coverage, and start the application, run the following command:

```
mvn clean install site; java -jar target/neo-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar;
```

if the blockchain appears to be corrupt, run the following command:
```
java -jar target/neo-java-0.0.1-SNAPSHOT-jar-with-dependencies.jar /validate
```