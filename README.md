# React 프로젝트 배포하는 방법

## React 프로젝트 수정
state.js 파일 수정
```jsx
const serverPath = 'http://[EC2 아이피 주소]:8080/';
```

setUpProxy.js 파일 수정
```jsx
target: 'http://[EC2 아이피 주소]:8080/',
```

## 로컬에서 npm install 명령어로 빌드하고 build 폴더를 EC2에 복사

**build 폴더를 옮기는 명령어**

```bash
scp -i capstone-design-server-key-pair.pem -r build ubuntu@1[EC2 아이피 주소]:~/원하는 폴더 이름
```

## React 프로젝트 백그라운드 실행

```bash
nohup serve -s build -l 80 &
```

---

# Spring Boot 프로젝트 배포하는 방법

## Spring Boot 프로젝트 수정

각 Controller에서`@CrossOrigin(origins = {"http://[EC2 아이피 주소]", "[원하는 도메인 주소]"})` 으로 설정

`WebMvcConfigurer` 에서 `.allowedOrigins("http://[EC2 아이피 주소]:8080") // 허용할 출처`

## 로컬에서 ./gradlew build 명령어로 빌드하고 jar 파일을 EC2에 복사

```bash
./gradlew build

scp -i capstone-design-server-key-pair.pem capstone01-0.0.1-SNAPSHOT-plain.jar ubuntu@[EC2 아이피 주소]:~/원하는 폴더 경로
```

## Spring Boot 백그라운드 실행

```bash
sudo nohup java -jar capstone01-0.0.1-SNAPSHOT-plain.jar &
```
