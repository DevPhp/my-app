FROM openjdk:10-jre-slim
ADD rba-1.0.0.jar /app/rba-1.0.0.jar
CMD ["java", "-jar", "-Dspring.profiles.active=production" ,"/app/rba-1.0.0.jar"]