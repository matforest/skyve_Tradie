# Creates the minimum environment to package and run this Skyve application.
# Note that this uses an in-memory database and is only useful for demonstration/development.
FROM bizhubaustralia/skyve-wildfly:latest

ENV LANG en_US.UTF-8

USER root
RUN mkdir /content
RUN chown jboss:jboss /content

USER jboss
ADD tradie.war /opt/jboss/wildfly/standalone/deployments/tradie.war
ADD tradie.json /opt/jboss/wildfly/standalone/deployments
ADD tradie-ds.xml /opt/jboss/wildfly/standalone/deployments
RUN touch /opt/jboss/wildfly/standalone/deployments/tradie.war.dodeploy

ENV SKYVE_CONTENT='/content/' \
    SKYVE_DATASTORE_DIALECT='org.skyve.impl.persistence.hibernate.dialect.H2SpatialDialect' \
    DATABASE_URL='tradie_db' \
    SKYVE_SECURITY_DOMAIN_NAME='tradie' \
    SKYVE_JNDI_NAME='tradieDB'

ENTRYPOINT [ "entrypoint.sh" ]