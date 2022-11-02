### Update License
```shell script
curl -X PUT -H 'Content-Type: application/json' -d @data-update.json localhost:8080/v1/organization/anyId/license
```

### Create License
```shell script
curl -X POST -H 'Content-Type: application/json' -d @data-create.json localhost:8080/v1/organization/anyId/license
```

### Get License
```shell script
curl -X GET localhost:8080/v1/organization/Bellsoft/license/76949233-206b-4c1a-bf42-1c5ead7ecd4a
```

## Using Internationalization

### Update License
```shell script
curl -X PUT -H 'Content-Type: application/json' -H 'Accept-Language: es' -d @data.json localhost:8080/v1/organization/20/license
```

### Create License
```shell script
curl -X POST -H 'Content-Type: application/json' -H 'Accept-Language: es' -d @data.json localhost:8080/v1/organization/20/license
```

### Delete License
```shell script
curl -X DELETE -H 'Accept-Language: es' localhost:8080/v1/organization/20/license/1234
```
