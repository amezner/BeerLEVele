# BeerLEVele
BeerLEVele Project - RFT LEV

Követelmények:
- [docker-compose](https://docs.docker.com/compose/install/)

### A project indítása:

#### Ha a make parancs elérhető
```terminal
make run
```

#### Ha nem érhető el a make parancs
```terminal
docker-compose up
```

### A project leállítása:
```terminal
$ make stop

# ha nincs make parancs
$ docker-compose stop
```

#### React frontend indítás fejlesztéshez:
- [az alábbi leírásban láthatjátok](frontend/README.md)
- Vagy az alábbi parancs:
```terminal
make run-frontend
```

Ez után a böngészőben látható lesz az index oldal az alábbi url-en:

http://localhost:8080/RFT_BEERLEVELE-war/
