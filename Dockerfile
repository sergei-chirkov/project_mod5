FROM tomcat

COPY ./target/project.war /usr/local/tomcat/webapps/
COPY ./target/classes/script.sql /docker-entrypoint-initdb.d/


