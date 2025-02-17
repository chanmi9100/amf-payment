# AMF 결제 도메인 구현

## httpie
http 도구설치: pip install httpie

- 쿠폰 등록
http :8080/coupons amount="10000"

- 결제 등록
http :8080/payments amount=30000 reservationId="A02"

- 쿠폰에 결제 정보 수정
http PATCH :8080/coupons/21 payments="http://localhost:8080/payments/22"
http PATCH :8080/coupons/21 payment_id=22 // 이건 불가능, 도메인 구조상

# 시작하기

## Base Project 다운로드 및 실행
먼저, 새로운 브라우저 탭을 열고, base project 를 gitpod 로 접속합니다
https://gitpod.io/#https://github.com/msa-school/ddd-petstore-level5-layered

GidPod 내에 터미널을 열고(왼쪽 상단의 햄버거 버튼 > Terminal > New Terminal), 프로젝트가 잘 컴파일 되는지 확인합니다:
```
mvn spring-boot:run
```

## 미션
- JPA를 통한 Database Input/Output Adapter 자동생성
- Spring Data REST 를 통한 REST API Input/Output Adaptor 자동생성

## 미션2
- maria db 를 이용하여 연결:
- maria db server 를 기동하기 (docker)
```
 docker run  -d -p 3306:3306 -e MARIADB_ROOT_PASSWORD=admin  mariadb:latest 
```
- 접속 및 DB 생성
```
root@251ce07fd6fc:/# mysql --user=root --password=$MARIADB_ROOT_PASSWORD
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 4
Server version: 10.7.3-MariaDB-1:10.7.3+maria~focal mariadb.org binary distribution

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> 
MariaDB [(none)]> 
MariaDB [(none)]> create database petstore
    -> ;
Query OK, 1 row affected (0.000 sec)

MariaDB [(none)]> 

```
- application.yaml 의 설정
```
spring:
  jpa:
    hibernate:
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
      ddl-auto: update
    properties:
      hibernate:
        show_sql: true
        format_sql: true
        dialect: org.hibernate.dialect.MySQL57Dialect
  datasource:
    url: jdbc:mysql://localhost:3306/petstore
    username: root
    password: admin
    driverClassName: com.mysql.cj.jdbc.Driver
```
- 데이터 확인
```
MariaDB [(none)]> use petstore
Reading table information for completion of table and column names
You can turn off this feature to get a quicker startup with -A

Database changed
MariaDB [petstore]> show tables;
+--------------------+
| Tables_in_petstore |
+--------------------+
| Pet                |
| hibernate_sequence |
+--------------------+
2 rows in set (0.000 sec)

MariaDB [petstore]> 
MariaDB [petstore]> 
MariaDB [petstore]> select * from Pet;
+----------+----+------------+--------+------+
| pet_type | id | appearance | energy | name |
+----------+----+------------+--------+------+
| dog      |  1 |          0 |      3 | ??   |
+----------+----+------------+--------+------+
1 row in set (0.000 sec)

```

## 다음: 도메인 영역의 확장 (Single Model, Big Ball Of Mud)
- Store 업무 영역의 추가
- 비대한 Monolith
- https://github.com/msa-school/ddd-petstore-level7-big-ball-of-mud


## Kafka 의 접속
### Docker Compose 이용 (도커 있을 때 강추)
- Kafka 의 실행 (Docker Compose)
```
cd kafka
docker-compose up -d     # docker-compose 가 모든 kafka 관련 리소스를 받고 실행할 때까지 기다림
```
- Kafka 정상 실행 확인
```
$ docker-compose logs kafka | grep -i started    

kafka-kafka-1  | [2022-04-21 22:07:03,262] INFO [KafkaServer id=1] started (kafka.server.KafkaServer)
```
- Kafka consumer 접속
```
docker-compose exec -it kafka /bin/bash   # kafka docker container 내부 shell 로 진입

[appuser@e23fbf89f899 bin]$ cd/bin
[appuser@e23fbf89f899 bin]$ ./kafka-console-consumer --bootstrap-server localhost:9092 --topic petstore
```