# Usa una versione ufficiale dell'immagine OpenJDK basata su Alpine come base
FROM openjdk:17-alpine

# Installa Maven
RUN apk update && apk add maven

# Imposta la directory di lavoro all'interno del container
WORKDIR /app

# Copia il file pom.xml e altri file di configurazione Maven nel container
COPY rentalJar/pom.xml .

# Scarica le dipendenze Maven (questo passo permette di fare cache delle dipendenze)
RUN mvn dependency:go-offline

# Copia il codice sorgente nel container
COPY rentalJar/src ./src

# Esponi la porta 8080
EXPOSE 8080

# Avvia l'applicazione con il plugin Spring Boot Devtools
ENTRYPOINT ["mvn", "spring-boot:run"]
