# Micro Cart - Microservice Reference Architecture

## Prerequisites

1. Create Services
```
cf cs p-service-registry standard registry
cf cs p-config-server standard config-server -c "{ \"git\": { \"uri\": \"https://github.com/prasanjeevi/config-store\", \"label\": \"master\"  } }"
cf cs p-circuit-breaker-dashboard standard monitor

cf cs p.mysql db-small product-mysql
cf cs p-rabbitmq standard queue

cf cs p-redis shared-vm cache
```

2. Clone, Build & Push
```
git clone https://github.com/prasanjeevi/micro-cart
cd micro-cart

cd product-catalog
gradle clean assemble
cd ..

cd order
gradle clean assemble
cd ..

cd frontend
gradle clean assemble
cd ..

cf push
```