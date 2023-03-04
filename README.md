# microservices-demo

## Generate ssl cert and key
```
cd docker/nginx
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout ./ssl/demo.key -out ./ssl/demo.crt
```

## Maven build
```
.\mvnw -DskipTests clean install
```

## Run services
```
docker compose up -d
```

## Grafana
To view dashboard navigate to:
```
http://localhost:3000
```


## Example of updating api gateway loggin level via config server
Navigate to service yml file to view current configuration:
```
http://localhost:8888/api-gateway.yml
```

Replace DEBUG level with INFO in api-gateway.yml:
```
docker exec -it config-server /bin/bash

cd root/configurations

sed -i 's/DEBUG/INFO/' api-gateway.yml

exit
```

Refresh configuration of api-gateway:
```
curl -X POST http://localhost:8080/actuator/refresh
```

##
### This project is dedicated to my friend [Rehabili](https://github.com/StipT), a gentleman and a scholar!
