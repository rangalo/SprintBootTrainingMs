FROM mherwig/alpine-java-mongo
VOLUME /tmp
ADD target/event-service-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT usr/bin/mongod & exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 8081