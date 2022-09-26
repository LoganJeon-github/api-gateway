# 역할
API Gateway는  Request를 포워딩해주는 역할을 담당한다. 다량의 Request가 올 경우 Request 처리를 각 서버에 분산시키기 위하여 사용한다.

# Port
- 9080


# 사용법

application.yml file에 URL을 추가함

```yaml

  routes:
    broker-api:
      # (APIGatewayURL)/broker/** 는 localhost:9898/** 로 연결된다.
      path: /broker/** 
      url: localhost:9898
      stripPrefix: true

    #하단은 예시
    example-api:
      path: /example-api/**
      url: localhost:123456
      stripPrefix: true
      # (APIGatewayURL)/example-api/** 는 localhost:123456/** 로 연결된다.
    
```

## stripPrefix
> API Gateway의 URL은 http://localhost:9080 으로 한다

- 위의 예시에서 `path:`에 적어준 `/broker/`, `/example-api/` 와 같은 것을 prefix라고 한다.
- API Gateway를 경유하여 다른 서버에 접속할 때 URL의 prefix를 유지할지 제거할지에 대한 옵션이다.

### true일 때

```yaml
    broker-api:
      path: /broker/** 
      url: localhost:9898
      stripPrefix: true
  ```
- http://localhost:9080/broker 로 접속하면 https://localhost:9898 으로 간다.

### false일때 
```yaml
    broker-api:
      path: /broker/** 
      url: localhost:9898
      stripPrefix: false
  ```
- http://localhost:9080/broker 로 접속하면 https://localhost:9898/broker 으로 간다.


### 사용법 
- Broker에서 개발한 API를 Api Gateway에서 사용하는 방법
- curl 등으로 Request를 보낼 때 Broker의 URL을 사용하여 Request를 보낸다. 이를 API Gateway를 경유하여 보내도록 하는 방법을 설명한다.