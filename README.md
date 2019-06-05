# Build
mvn clean package && docker build -t myapp/mark1 .

# RUN

docker rm -f mark1 || true && docker run -d -p 8080:8080 -p 4848:4848 --name mark1 myapp/mark1 