Запуск контейнеров
```shell
docker compose up -d
docker compose ps -a
```
docker compose stop
docker container prune -f
docker volume prune -f


docker run -it -p 5672:5672 -p 15672:15672 --hostname my-rabbit --name some-rabbit1 rabbitmq:management

```
docker exec -it kafka /bin/bash 

docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' container_id

/bin/connect-standalone  /etc/kafka/connect-standalone.properties /home/conf/CamelAmqpSinkConnector.properties 


curl -X POST --data-binary "@kafka-to-rabbit.json" -H "Content-Type: application/json" http://localhost:8083/connectors