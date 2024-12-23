FROM maven:3.8.2-jdk-8-slim AS stage1
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Create an Image
FROM openjdk:8-jdk-alpine
EXPOSE 5000

# Copia l'artefatto compilato dalla fase di costruzione
COPY --from=stage1 /home/app/target/random-quote-app-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta su cui l'app ascolta
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]
