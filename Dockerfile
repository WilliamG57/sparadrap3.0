# Étape de build
FROM eclipse-temurin:17-jdk AS build

# Installer Maven
RUN apt-get update && \
    apt-get install -y maven \
    && apt-get clean && rm -rf /var/lib/apt/lists/
  
  # Définir le répertoire de travail dans l'image
WORKDIR /app
  
  # Copier le fichier pom.xml et les sources dans l'image
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
  
  # Exécuter Maven build
  # Le résultat est un fichier JAR construit
RUN mvn -B package --file pom.xml
  
  # Étape de l'image finale
FROM eclipse-temurin:17-jre

  # Port d'écoute par défaut
EXPOSE 8080
  
  # Copier le fichier JAR de l'étape de build à l'image finale
COPY --from=build /app/target/sparadrap-1.0-SNAPSHOT.jar /sparadrap-1.0-SNAPSHOT.jar

# Utilisateur non-root pour l'exécution de l'application
RUN addgroup --system spring && adduser --system --group spring
USER spring:spring

  # Commande pour exécuter l'application
CMD ["java", "-jar", "/sparadrap-1.0-SNAPSHOT.jar"]
