#!/bin/sh

docker-machine create --virtualbox-memory "4096" --driver virtualbox ms
eval "$(docker-machine env ms)"
cp sidecar/build/libs/sidecar-1.0.jar RailsApplication/bin
docker-compose build
