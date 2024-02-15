FROM tomcat:10.1.13

COPY ./target/project.war /usr/local/tomcat/webapps/
