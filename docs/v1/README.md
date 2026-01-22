# v1. Spring MVC 개발환경 세팅

## 목표
- JDK 17 기반 개발환경 구성
- MariaDB 설치 및 DBeaver 연결
- Spring MVC + Jetty 실행 및 API PING 확인
- datasource + MyBatis 연동

---

## 진행 내용

### 1) 개발환경 구성
- JDK: 17
- Maven 기반 Spring MVC 프로젝트 생성

### 2) DB 구성 (MariaDB)
- MariaDB 구동 확인
- DBeaver 연결 확인
- DB/계정 생성 및 권한 부여

### 3) Spring MVC 실행 (Jetty)
- Jetty Run 설정 및 서버 구동 로그 확인

### 4) API 테스트
- `/ping` 호출 정상 확인
- `/requests` 호출 정상 확인 (MyBatis 연동 조회 테스트)

---

## 이슈 & 해결

### 1) MariaDB 포트 충돌(3306)
- 원인: 기존 mysqld 프로세스가 3306 포트 점유
- 해결: 점유 프로세스 종료 후 MariaDB 실행

### 2) root 접속 오류 (ERROR 1698)
- 원인: root 계정 인증 방식으로 인해 비밀번호 로그인 불가
- 해결: 프로젝트 전용 계정 생성 후 해당 계정으로 접속
