FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
RUN sed -i 's/\r$//' gradlew && chmod +x gradlew
COPY . .
RUN ./gradlew clean bootJar -x test --no-daemon

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/build/libs/api-equipos-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "exec java -jar app.jar --server.port=${PORT:-8080}"]