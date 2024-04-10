FROM amazoncorretto:21-alpine-jdk as build

WORKDIR /app
COPY . /app

RUN ./gradlew build

FROM amazoncorretto:21-alpine-jdk

COPY --from=build /app/build/libs/FeedNac-0.0.1-SNAPSHOT.jar /feednac.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "feednac.jar"]