FROM tomcat:10.1.13

COPY ./target/project_mod5.war /usr/local/tomcat/webapps/
