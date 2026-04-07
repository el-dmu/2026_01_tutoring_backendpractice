# 🏛 2026-1 백엔드실습 튜터링

본 저장소는 동양미래대학교 컴퓨터소프트웨어공학과 **'백엔드실습'** 과목 튜터링 실습 코드를 관리하는 공간입니다.

---

## 👥 튜터 및 튜티 소개

| 역할 | 이름 | GitHub |
| :--- | :--- | :--- |
| **Tutor** | **최정규** | [**@JeongGyul**](https://github.com/JeongGyul) |
| Tutee | 최진서 | [@choijinseo04-collab](https://github.com/choijinseo04-collab) |
| Tutee | 박다윗 | [@DavidPark04](https://github.com/DavidPark04) |
| Tutee | 임상혁 | [@SH0315](https://github.com/SH0315) |

---

## 🌲 브랜치 규칙
- **브랜치 명**: `week00_이름(영어)`
- 매 주차 새로운 실습을 진행할 때마다 해당 주차 브랜치를 생성하여 작업합니다.
- **예시**: `week01_JeongGyu`, `week02_JeongGyu`

## 📂 폴더 구조
- 본인 **이름(영어)** 폴더 내부에 프로젝트를 생성합니다.
- 해당 프로젝트에서 실습을 진행해주시면 됩니다.

```
├── JeongGyu (본인 이름)
│   └── StudyServlet (프로젝트 폴더)
│       ├── src
│       ├── pom.xml
│       └── ...
├── README.md
```

## ✅ Pull Request 규칙
- **PR 제목**: `[week00] 이름 n주차 실습`
- **내용**: 튜터링 및 실습 진행 간에 느낀 점 한마디

### 👥 Reviewer & Assignee
- **Reviewer**: `JeongGyul` (튜터만 지정)
- **Assignee**: 본인(작성자) 지정

📍 **Merge 규칙**: 튜터의 코드 리뷰가 완료된 후, **튜터가 최종 Merge** 합니다. (개별 Merge 절대 금지)

---

## ✅ 커밋 메시지 규칙
모든 커밋은 아래의 타입을 준수하여 작성해 주세요.  
`ex) feat: 로그인 서블릿 구현`

| 타입      | 설명 |
|-----------|------|
| feat      | 새로운 기능 추가 |
| fix       | 버그 수정 |
| docs      | 문서 수정 (README, 주석 등) |
| style     | 코드 스타일 변경 (포맷, 세미콜론 등) |
| refactor  | 리팩토링 (기능 변화 없음) |
| test      | 테스트 코드 추가 / 수정 |
| chore     | 빌드 설정, 패키지 관리 등 기타 작업 |
| build     | 빌드 관련 파일 수정 |
| revert    | 이전 커밋 되돌리기 |

---

## 🛠 환경 설정 (Standard)
- **IDE**: IntelliJ IDEA Ultimate
- **JDK**: Java 17 버전 이상
- **WAS**: Apache Tomcat 10.1.x (Jakarta EE)
- **DB**: MySQL 8.0