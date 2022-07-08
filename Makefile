.PHONY: build

COMPOSE=./docker-compose.yaml
COMPOSE_DIAGRAM=./docker-compose.diagram.yaml

up:
	docker compose -f $(COMPOSE) up -d

down:
	docker compose -f $(COMPOSE) down -v --remove-orphans

db/migrate:
	./gradlew flywayMigrate

db/diagram:
	docker compose -f $(COMPOSE) -f $(COMPOSE_DIAGRAM) run --rm diagram
