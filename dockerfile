FROM openjdk:8

RUN mkdir /item

WORKDIR /item

COPY . ./item
ADD . /item

EXPOSE 8083

CMD ["java", "-jar", "target/item-service-2.5.0-SNAPSHOT.jar"]