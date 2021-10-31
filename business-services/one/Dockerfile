FROM amazoncorretto:11-alpine-jdk
ADD target/one.jar one.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar one.jar"]