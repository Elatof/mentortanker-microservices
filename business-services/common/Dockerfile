FROM amazoncorretto:11-alpine-jdk
ADD target/common.jar common.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar common.jar"]