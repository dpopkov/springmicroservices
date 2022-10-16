### Update License
```shell script
curl -X PUT -H 'Content-Type: application/json' -d @data.json localhost:8080/v1/organization/20/license
```

### Create License
```shell script
curl -X POST -H 'Content-Type: application/json' -d @data.json localhost:8080/v1/organization/20/license
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
