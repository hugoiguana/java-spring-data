ms-build:
	@echo "Building ms-product"
	./mvnw clean package -f pom.xml

ms-build-no-test:
	@echo "Building ms-product"
	./mvnw clean package -Dmaven.test.skip=true -f pom.xml

docker-compose-up:
	docker compose up -d

docker-compose-stop:
	docker compose stop

docker-clean:
	docker compose down
	docker volume rm spring-data-db-volume
