FROM amazoncorretto:11-alpine-jdk
ADD target/apigateway.jar apigateway.jar
ENV JAVA_OPTS=""
EXPOSE 8761
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar apigateway.jar"]