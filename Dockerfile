FROM amazoncorretto:21-alpine-jdk as build

RUN apk update && apk add unzip && apk add curl
WORKDIR /gradle
RUN curl -L https://services.gradle.org/distributions/gradle-8.7-bin.zip -o gradle-8.7-bin.zip
RUN unzip gradle-8.7-bin.zip
ENV GRADLE_HOME=/gradle/gradle-8.7
ENV PATH=$PATH:$GRADLE_HOME/bin
RUN gradle --version

WORKDIR /app
COPY . /app

RUN gradle build

FROM amazoncorretto:21-alpine-jdk

COPY --from=build /app/build/libs/FeedNac-0.0.1-SNAPSHOT.jar /feednac.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "feednac.jar"]