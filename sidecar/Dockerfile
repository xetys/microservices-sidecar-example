FROM ewolff/docker-java
ADD build/libs/sidecar-1.0-SNAPSHOT.jar .
CMD /usr/bin/java -Xmx400m -Xms400m -jar sidecar-1.0-SNAPSHOT.jar
EXPOSE 8080