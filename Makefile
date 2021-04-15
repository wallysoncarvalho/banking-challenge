IMAGE_TAG := desafio-wallyson
CONTAINER_NAME := dd-wallyson

up:
	docker build --tag desafio-wallyson .
	docker run --name $(CONTAINER_NAME) -p 8090:8090 -p 8091:8091 $(IMAGE_TAG)

down:
	docker stop $(CONTAINER_NAME)
	docker rm $(CONTAINER_NAME)
	docker image rm $(IMAGE_TAG)