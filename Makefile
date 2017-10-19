install:
	@docker-compose pull

run:
	@docker-compose up -d

stop:
	@docker-compose stop

run-frontend:
	@docker-compose up -d
	@(cd frontend && yarn start)
	docker-compose stop
