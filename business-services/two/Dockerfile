FROM amazoncorretto:11-alpine-jdk
ADD target/two.jar two.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar two.jar"]