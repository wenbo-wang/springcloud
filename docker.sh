#! /bin/sh
docker-compose -f ./docker/mysql.yml up -d
docker-compose -f ./docker/zipkin.yml up -d