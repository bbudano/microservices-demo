# microservices-demo

### Generate ssl cert and key
```
cd docker/nginx

sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout ./ssl/demo.key -out ./ssl/demo.crt
```


### This project is dedicated to my friend [Rehabili](https://github.com/StipT), a gentleman and a scholar!