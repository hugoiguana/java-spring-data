
## LINKS:
https://www.postgresql.org/docs/current/plpgsql-statements.html
https://www.postgresql.org/docs/current/plpgsql-control-structures.html
https://www.postgresql.org/docs/8.3/xfunc-sql.html

## Mavem commands:
```maven
./mvnw clean package -Dmaven.test.skip=true -f pom.xml
```

## Docker commands:
```maven
docker ps | grep spring-data-
docker ps -a | grep spring-data-
docker images | grep spring-data-
docker stop spring-data-db && docker rm spring-data-db
docker stop spring-data-ms && docker rm spring-data-ms

docker build -t spring-data-ms:0.0.1-SNAPSHOT --build-arg="ENV_IMG=openjdk:22-ea-21-slim-bullseye" --build-arg="JAR_NAME=spring-data-ms-0.0.1-SNAPSHOT" -f docker/Dockerfile.ms.java .

docker run -p 8080:8080 spring-data-ms:0.0.1-SNAPSHOT

docker volume ls
docker volume rm spring-data-db
docker logs spring-data-ms -f
docker network ls
docker network rm spring-data
docker exec -it spring-data-db /bin/sh
docker exec spring-data-ms echo $DB_URL
```

## Docker compose commands:
```docker
docker compose up -d
docker compose up -d spring-data-db
docker compose stop spring-data-db
```

## Postgres DB - Connect on a container:
```bash
docker exec -u root -it spring-data-db psql --host localhost -U app -d spring-data -p 5432

# Show data bases:
\l

# Show Users:
\du;

# Connect to a database:
\connect dbname
\c dbname

# Show relations(tables)
\dt
\dt+
```

## Postgres DB - Get a dump from a container:
```bash
docker exec -it spring-data-db /bin/sh
pg_dump -U app -W -d spring-data > spring-data.sql
docker cp spring-data-db:/spring-data.sql spring-data-dump.sql
```

## Shell commands:
```bash
chmod +X install.sh
bash -c "source install.sh; ms-install"
bash -c "source install.sh; db-install"
bash -c "source install.sh; ms-build-docker-img 0.0.1-SNAPSHOT"
```

## SQL commands:
```sql
select * from test.category;
select * from test.product p where p.id_category = 'e3d00c66-5a34-4429-bbbd-39d1a1cb6a7d';

SELECT * FROM test.func_products_view('e3d00c66-5a34-4429-bbbd-39d1a1cb6a7d') AS t1;
SELECT * FROM test.func_products_view('c93232ed-3593-4ec2-bb2d-0497c60e4075') AS t1;
SELECT * FROM test.func_products_view(null, 'c.name', 'ASC');

SELECT p.id, p.name, p.description, c.id AS category_id, c.name AS category_name
FROM test.product p
JOIN test.category c ON c.id = p.id_category
WHERE p.id_category = 'c93232ed-3593-4ec2-bb2d-0497c60e4075';
```
