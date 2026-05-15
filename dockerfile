# -------- STAGE 1: BUILD --------
FROM gradle:8.7-jdk17 AS build

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle

RUN gradle dependencies --no-daemon || true

COPY . .

RUN gradle clean bootJar --no-daemon

# -------- STAGE 2: RUNTIME --------
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]