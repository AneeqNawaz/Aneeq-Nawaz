FROM maven:3.9.6-eclipse-temurin-21

# Install dependencies
RUN apt-get update && apt-get install -y adb && apt-get clean

WORKDIR /usr/src/app

COPY . .

RUN chmod +x ./entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]
