FROM centos:7
MAINTAINER Hachiko Service Team

USER root

ENV CATALINA_HOME /usr/local/tomcat
ENV TOMCAT_BASE_VERSION 9
ENV TOMCAT_VERSION 9.0.5
ENV HOME_DIR /home/securo
ENV WEB_APP_LOG /var/log/securo

# Install prepare infrastructure
RUN yum -y update && \
  yum -y install unzip

# Install JDK 1.0.8
RUN yum -y install java-1.8.0-openjdk

#Install tomcat ${TOMCAT_VERSION}
RUN curl -q -O https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_BASE_VERSION}/v${TOMCAT_VERSION}/bin/apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
  tar zxf apache-tomcat-${TOMCAT_VERSION}.tar.gz && \
  rm apache-tomcat-${TOMCAT_VERSION}.tar.gz
RUN mkdir -p ${CATALINA_HOME} && \
    mv apache-tomcat-${TOMCAT_VERSION}/* ${CATALINA_HOME} && \
    rm -rf ${CATALINA_HOME}/webapps/

# Deploy war file
COPY target/securo.war ${CATALINA_HOME}/webapps/ROOT.war

EXPOSE 8080

# Make web app log directory
RUN mkdir -p ${WEB_APP_LOG}

# Add group hachiko and user securo
RUN groupadd -g 75001 hachiko && \
  useradd -d /home/securo -g hachiko -u 75001 securo && \
  chmod a+x ${CATALINA_HOME}/bin/catalina.sh

# Deploy entry point script
COPY run.sh ${HOME_DIR}/run.sh

RUN chmod a+x ${HOME_DIR}/run.sh

# Set user access permissions
RUN chown securo:hachiko -R ${CATALINA_HOME} && \
    chmod g-w,o-rwx ${CATALINA_HOME}
RUN chown securo:hachiko -R ${HOME_DIR} && \
    chmod g-w,o-rwx ${HOME_DIR}
RUN chown securo:hachiko -R ${WEB_APP_LOG} && \
    chmod o-rwx ${WEB_APP_LOG}

USER securo

WORKDIR ${CATALINA_HOME}

ENTRYPOINT ["sh", "/home/securo/run.sh"]
