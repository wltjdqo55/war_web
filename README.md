<div align="center">
<h2>[2024] 연세왕국의 전쟁 🎮</h2>
이 프로젝트는 연세 왕국이 마물의 침공에 맞서기 위해 구축한 데이터베이스 시스템입니다.<br><br>용사와 마물 군단의 정보를 관리하며, 각 용사는 기본 능력치와 함께 종족, 아이템, 스킬에 따른 능력치 보정을 받습니다. 마물 군단은 마물 장군의 능력치 보정을 통해 강화됩니다.<br> 또한, 통계와 모의 전투 기능을 제공하여 사용자가 직접 용사와 마물 군단의 전투를 경험할 수 있도록 설계하였습니다.
</div>

## **📗 목차**
- ### 포트폴리오 개요
- ### 개발 환경
- ### 주요 기능
- ### 프로젝트 구조


## **🔲 포트폴리오 개요**

> **기획 및 제작:** 지성배
>
> **분류:** 개인 프로젝트
>
> **개발기간:** 2024.09.06 ~ 2024.09.30
> 
> **문의:** wltjdqo55@gmail.com

## **🔲 개발 환경**

> **형상관리:** <img src="https://img.shields.io/badge/GITHUB-181717?style=flat-square&logo=github&logoColor=white"/>, <img src="https://img.shields.io/badge/NOTION-000000?style=flat-square&logo=notion&logoColor=white"/>
>
> **프론트엔드:** <img src="https://img.shields.io/badge/HTML-E34F26?style=flat-square&logo=HTML5&logoColor=white"/> <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white"/> <img src="https://img.shields.io/badge/Vue.js-4FC08D?style=flat-square&logo=Vue.js&logoColor=white"/> <img src="https://img.shields.io/badge/Axios-5A29E4?style=flat-square&logo=Axios&logoColor=white"/>
>
> **백엔드:** <img src="https://img.shields.io/badge/JAVA-1572B6?style=flat-square&logo=JAVA&logoColor=white"/> <img src="https://img.shields.io/badge/JPA-1572B6?style=flat-square&logo=JPA&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Securit&logoColor=white"/> <img src="https://img.shields.io/badge/INTELLIJ IDEA-000000?style=flat-square&logo=intellijidea&logoColor=white"/> <img src="https://img.shields.io/badge/POSTMAN-FF6C37?style=flat-square&logo=postman&logoColor=white"/> <img src="https://img.shields.io/badge/DBeaver-382923?style=flat-square&logo=dbeaver&logoColor=white"/> <img src="https://img.shields.io/badge/GRADLE-02303A?style=flat-square&logo=gradle&logoColor=white"/>
>    
> **데이터베이스:** <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=flat-square&logo=PostgreSQL&logoColor=white"/>


## **🔲 주요 기능**

#### 1. 사용자 인터페이스 및 프론트엔드 개발(Vue,js, HTML, CSS 사용)

#### 2. 관리자 인증 및 권한 관리 (Spring Security) - Bcryptpasswordencoder 사용

#### 3. Restful API 설계 및 구현

#### 4. 데이터베이스 연동 및 ORM (JPA, queryDSL 사용)

#### 5. 관리자 로그인 시 세션 등록 및 세션 시간 부여

#### 6. interceptor 구현 - 일반 사용자는 관리자 페이지 접속 불가(관리자 URL 접속시 관리자 로그인 화면으로 이동)

#### 7. 용사, 아이템, 스킬, 종족, 마물군단, 마물장군의 CRUD 및 통계, 모의전투 기능 구현

#### 8. 일반 사용자 기능 
- **데이터 검색 기능 제공**
    - 용사 정보 검색
    - 스킬 정보 검색
    - 종족 정보 검색
    - 아이템 정보 검색
    - 마물 군단 정보 검색
    - 마물 장군 정보 검색
  

- **상세 정보 표출 기능 제공**
    - 검색 결과에서 선택하여 상세 정보 표출
    - 용사 정보: 초기 status와 보정 status 나란히 표시
    - 마물 군단 정보: 초기 status와 보정 status 나란히 표시
    - 보정된 status 클릭 시 계산 내용 팝업

#### 9. 관리자 기능
- **로그인/로그아웃**
    - Administrator 테이블로 ID/Password 관리
    - ID/Password 입력 및 체크
    - 로그인 후 모든 화면에 로그아웃 링크 표시
    - 세션 정보 유지


- **데이터 검색/등록/수정/삭제 기능**
    - 용사, 스킬, 종족, 아이템, 마물 군단, 마물 장군 정보 관리
    - (Optional) 관리자 정보 관리
    - 등록/수정 시 선택 가능한 데이터 표시

#### 10. 전투 분석가 기능
- **전체 데이터 통계 확인 기능**
    - 현재 용사 및 마물 군단 통계 정보 제공


- **모의 전투 기능 제공**
    - 여러 용사와 하나의 마물 군단 선택하여 전투 결과 시뮬레이션
    - 전투 결과에 대한 계산 내용 표출
    - (Optional) 선택한 마물 군단과 천적 용사에 대한 버프 적용


## **🔲 ERD**
![ERD](https://github.com/user-attachments/assets/81aa1245-097f-405d-926f-35873c9fe67c)

| 번호 | 엔티티 A       | 엔티티 B | 관계 유형    |
|----|----------------|-------|--------------|
| 1  | 용사           | 스킬    | OneToOne     |
| 2  | 용사           | 아이템   | OneToMany    |
| 3  | 용사           | 종족    | ManyToOne    |
| 4  | 마물군단       | 마물장군  | ManyToMany   |
| 5  | 마물장군       | 종족    | ManyToOne    |

## **🔲 프로젝트 구조 - MVC2 디자인 패턴**
````
├─main
│  ├─generated
│  │  └─kingdom
│  │      └─warPrj
│  │          └─entity
│  │              └─entity
│  ├─java
│  │  └─kingdom
│  │      └─warPrj
│  │          ├─account
│  │          ├─config
│  │          ├─controller
│  │          ├─entity
│  │          │  ├─dto
│  │          │  ├─entity
│  │          │  └─vo
│  │          ├─eNum
│  │          ├─interceptor
│  │          ├─repasitory
│  │          │  ├─jpa
│  │          │  └─queryDSL
│  │          └─service
│  └─resources
│      ├─static
│      │  ├─common
│      │  │  ├─css
│      │  │  └─html
│      │  ├─css
│      │  ├─dist
│      │  │  ├─image
│      │  │  ├─jquery
│      │  │  └─js
│      │  └─plugins
│      │      ├─axios
│      │      └─vueJs
│      └─templates
│          ├─account
│          ├─battle
│          ├─error
│          ├─monster
│          │  ├─general
│          │  └─legion
│          ├─skill
│          ├─soldier
│          ├─species
│          └─storage
└─test
    └─java
        └─kingdom
            └─warPrj
````
## **🔲 주요 화면**
<h4>[시작화면 - 사용자, 관리자]</h4>
<img src="https://github.com/user-attachments/assets/a4c2df0a-ebe3-4710-8972-2772c312e54e" alt="사용자 시작화면" style="display:inline-block; width:45%; margin-right: 10px;"/>
<img src="https://github.com/user-attachments/assets/4b4c1d23-e4d2-4eb3-a6aa-c14727c09dcf" alt="관리자 시작화면" style="display:inline-block; width:45%;"/>

- 사용자 화면과 관리자 화면을 분리하였습니다.
- 사용자는 검색기능과 상세정보, 모의전투기능을 제공하며, 등록,수정,삭제, 통계확인은 할 수 없습니다.
- 사용자가 관리자만 볼 수 있는 화면을 API를 입력해서 접속시도시, Interceptor를 통해 세션을 체크한 후 세션이 존재하지 않으면 관리자 로그인 화면으로 이동합니다.
  <img src="https://github.com/user-attachments/assets/0c96c4f9-a5ce-4459-beb4-e4c5e5ae5525" alt="인터셉터GIF" style="display:inline-block; width:100%;"/> 
<h4 style="margin-top: 60px;">[목록화면]</h4>

