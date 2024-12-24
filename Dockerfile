FROM maven:3.8.5-openjdk-17-slim AS stage1

WORKDIR /home/app
COPY . /home/app/
RUN mvn package -DskipTests

# Create an Image
FROM openjdk:17-jdk-alpine
# Copia l'artefatto compilato dalla fase di costruzione
COPY --from=stage1 /home/app/target/random-quote-app-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta su cui l'app ascolta
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
