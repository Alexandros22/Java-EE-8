FROM airhacks/glassfish
COPY ./target/mark1.war ${DEPLOYMENT_DIR}
