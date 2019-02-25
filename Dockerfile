FROM tomcat:8-jre8

ADD target/springmvc.war /usr/local/tomcat/webapps/

EXPOSE 8080


ENTRYPOINT ["catalina.sh","run"]