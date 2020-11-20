# Enkelt TODO liste eksempel
Det er laget for å demonstrere enkelt SQL / Java prosjekt for Web

## Java
Skrevet med Java 15.

## Spring Boot
Et konfigurasjons-rammeverk for Java. 
Det er enkelt å inkludere moduler for web-server data mapping, database connections osv.

## Freemarker
Et template-rammeverk for Java / Spring Boot som gjør det enkelt å skrive HTML kode med markup for data integrasjon.

## MySQL
Det er laget med MySQL og skjema ligger i  /todolist/src/main/resources/db/mysql.
Andre database skjemaer kan også legges der og lastes med Flyway, som for øyeblikket er kommentert ut.

## Flyway
Er et rammeverk for migrering av database skjemaer. 
Gjør det enkelt å sette opp in-memory databaser slik som H2 for testing og det automatiserer skjema endringer for bygge pipelines.



