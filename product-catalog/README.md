```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name":"iPhone X","stock":100,"price":450.12}' \
  http:/localhost:8080/products

cf cs p-rabbitmq standard queue
cf cs p-redis shared-vm cache
```