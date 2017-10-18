# BeerLEVele
BeerLEVele Project - RFT LEV

Használati útmutató:

Le kell húzni a megfelelő preparált docker imageket:

docker pull danida/beer_stock_for_rft_levelezo:sql_ready_for_use
docker pull danida/beer_stock_for_rft_levelezo:glassfish_ready_for_use

Ezzel a parancscsal meg lehet nézni hogy lejöttek-e a megfelelő imagek:

docker image ls

Elindítod az konténereket a letöltött imageekből:

sudo docker run -d -p 4848:4848 -p 8080:8080 danida/beer_stock_for_rft_levelezo:glassfish_ready_for_use
sudo docker run --name mysql -e MYSQL_ROOT_PASSWORD=admin -d danida/beer_stock_for_rft_levelezo:sql_ready_for_use

Ez után a böngészőben látható lesz az index oldal az alábbi url-en:

http://localhost:8080/RFT_BEERLEVELE-war/ 
