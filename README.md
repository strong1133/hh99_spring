</br>

<h1 align="center" style="color:red"> ⛴ 항해99 ⛴ SJ_Blog :zap: </h1>

</br></br>

## 🌏 http://mypl.shop/

-> aws ec2호스팅 중이며 해당 url은 학습진행에 따라 다른 서비스로 바뀔수 있음
</br>

## 🤠 Part

총 1인

- 정석진 : 프론트, 백엔드

## :rocket:기능

- Spring Security를 통한 로그인 및 회원가입, Oauth2를 이용한 소셜 로그인
- 게시글 CRUD
- 게시글 상세 조회 페이지
- 게시글에 대한 각각 댓글 및 댓글 CRUD

</br>

## 🦄 프로젝트 썸네일

<p align="center">
<img src="https://github.com/strong1133/hh99_spring/blob/main/thumnail/%EB%A1%9C%EA%B7%B8%EC%9D%B8%ED%99%94%EB%A9%B4.png?raw=true" width="70%"></img>
</p>

<p align="center">
<img src="https://github.com/strong1133/hh99_spring/blob/main/thumnail/%EB%A9%94%EC%9D%B8.png?raw=true" width="70%"></img>
</p>

</br>

## :orange_book: 개발일지

:heavy_check_mark: Velog TIL  
추후 작성 예정

</br>

## :mag: 요약

- 스프링을 이용한 서버 구축과 CRUD 기능을 적용한 블로그 만들기
- 스프링 시큐리티를 이용해 구축한 블로그에 회원 서비스 도입 및 소셜 로그인 기능 도입
- 게시글 id값을 url을 통해 넘김으로써 각 게시글에 대한 상세페이지 구현
- 각 게시글에 댓글 CRUD 구현

</br>

## :closed_book: 기술

#### :orange_book: backend

- JAVA
- Spring Boot
- JPA
- RDB
- Spring Security

#### :orange_book: frontend

- HTML
- CSS
- JavaScript
- JQuery
- thymeleaf

#### :orange_book: Hosting

- AWS: EC2
- ubuntu
- RDS

</br>

## :package: 개발 환경

- IntelliJ
- ubuntu, aws

</br>

## 📸 Schreenshot

#### :heavy_check_mark: 메인 화면

<p align="center">
<img src="https://github.com/strong1133/hh99_spring/blob/main/thumnail/%EB%A9%94%EC%9D%B8.png?raw=true" width="90%"></img>
</p>

</br>

#### :heavy_check_mark: 로그인

<p align="center">
<img src="https://github.com/strong1133/hh99_spring/blob/main/thumnail/%EB%A1%9C%EA%B7%B8%EC%9D%B8%ED%99%94%EB%A9%B4.png?raw=true" width="90%"></img>
</p>

</br>

#### :heavy_check_mark: 회원가입

<p align="center">
<img src="https://github.com/strong1133/hh99_spring/blob/main/thumnail/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%ED%99%94%EB%A9%B4.png?raw=true" width="90%"></img>
</p>

</br>

#### :heavy_check_mark: 게시물 작성

<p align="center">
<img src="hhttps://github.com/strong1133/hh99_spring/blob/main/thumnail/%EA%B8%80%EC%9E%91%EC%84%B1.png?raw=true" width="90%"></img>
</p>

</br>

#### :heavy_check_mark: 게시글 상세 조회

<p align="center">
<img src="https://github.com/strong1133/hh99_spring/blob/main/thumnail/%EC%83%81%EC%84%B8%ED%8E%98%EC%9E%8A.png?raw=true" width="90%"></img>
</p>

</br>

#### :heavy_check_mark: 카카오톡 로그인

<p align="center">
<img src="https://github.com/strong1133/hh99_spring/blob/main/thumnail/%EC%B9%B4%EC%B9%B4%EC%98%A4%ED%86%A1.png?raw=true" width="100%"></img>
</p>

</br>

## 💽 이모저모

- 추가 예정

</br>

### 👑 After 프로젝트

- 사실 몇가지 허점이 존재한다.
- 이를테면 관리자 도구로 현재 접속 유저 네임을 강제로 바꿔주면 본인확인 검증이 뚫린다.
- 이유는 서버쪽에서 하지 않고 JS에서 처리했기 때문
- 꼼수(?)를 부리다가 보안상 허점이 생기고 말았다. 이 문제는 서버딴에서 정규식검사하듯 체크하는 부분을 만들면 고쳐질것 같다.
- JWT 로그인 방식으로 바꿔 보고싶다!
  </br>
