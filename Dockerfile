FROM maven:3.9.6-eclipse-temurin-17
WORKDIR /tests
COPY . .
#RUN mvn clean test-compile
RUN mvn -q -DskipTests compile
CMD mvn test -DsuiteXml=testNG_XML/$TEST_SUITE -Dbrowser=$BROWSER
