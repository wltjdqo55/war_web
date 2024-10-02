<div align="center">
<h2>[2024] 연세왕국의 전쟁 🎮</h2>
이 프로젝트는 연세 왕국이 마물의 침공에 맞서기 위해 구축한 데이터베이스 시스템입니다.<br><br>용사와 마물 군단의 정보를 관리하며, 각 용사는 기본 능력치와 함께 종족, 아이템, 스킬에 따른 능력치 보정을 받습니다. 마물 군단은 마물 장군의 능력치 보정을 통해 강화됩니다.<br> 또한, 통계와 모의 전투 기능을 제공하여 사용자가 직접 용사와 마물 군단의 전투를 경험할 수 있도록 설계하였습니다.
</div>

&nbsp;

## **📗 목차**  

- ### 포트폴리오 개요
- ### 개발 환경
- ### 주요 기능
- ### 프로젝트 구조

&nbsp;

## **🔲 포트폴리오 개요**

> **기획 및 제작:** 지성배
>
> **분류:** 개인 프로젝트
>
> **개발기간:** 2024.09.06 ~ 2024.09.30
> 
> **문의:** wltjdqo55@gmail.com

&nbsp;

## **🔲 개발 환경**

> **형상관리:** <img src="https://img.shields.io/badge/GITHUB-181717?style=flat-square&logo=github&logoColor=white"/>, <img src="https://img.shields.io/badge/NOTION-000000?style=flat-square&logo=notion&logoColor=white"/>
>
> **프론트엔드:** <img src="https://img.shields.io/badge/HTML-E34F26?style=flat-square&logo=HTML5&logoColor=white"/> <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white"/> <img src="https://img.shields.io/badge/Vue.js-4FC08D?style=flat-square&logo=Vue.js&logoColor=white"/> <img src="https://img.shields.io/badge/Axios-5A29E4?style=flat-square&logo=Axios&logoColor=white"/>
>
> **백엔드:** <img src="https://img.shields.io/badge/JAVA-1572B6?style=flat-square&logo=JAVA&logoColor=white"/> <img src="https://img.shields.io/badge/JPA-1572B6?style=flat-square&logo=JPA&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=flat-square&logo=Spring Securit&logoColor=white"/> <img src="https://img.shields.io/badge/INTELLIJ IDEA-000000?style=flat-square&logo=intellijidea&logoColor=white"/> <img src="https://img.shields.io/badge/POSTMAN-FF6C37?style=flat-square&logo=postman&logoColor=white"/> <img src="https://img.shields.io/badge/DBeaver-382923?style=flat-square&logo=dbeaver&logoColor=white"/> <img src="https://img.shields.io/badge/GRADLE-02303A?style=flat-square&logo=gradle&logoColor=white"/>
>    
> **데이터베이스:** <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=flat-square&logo=PostgreSQL&logoColor=white"/>

&nbsp;

## **🔲 목표**
이번 프로젝트의 주된 목표는 데이터 모델링입니다.<br>직접 데이터베이스를 설계하여 용사, 스킬, 아이템, 종족, 마물 군단, 마물 장군 등 다양한 엔티티 간의 복잡한 관계를 정의하고, OneToOne, OneToMany, ManyToOne, ManyToMany와 같은 다양한 관계형 데이터베이스 모델을 실제 코드로 구현하며, ERD를 시각적으로 표현하는데 의미를 두었습니다.

&nbsp;

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

&nbsp;

## **🔲 ERD**
![ERD](https://github.com/user-attachments/assets/81aa1245-097f-405d-926f-35873c9fe67c)

| 번호 | 엔티티 A       | 엔티티 B | 관계 유형    |
|----|----------------|-------|--------------|
| 1  | 용사           | 스킬    | OneToOne     |
| 2  | 용사           | 아이템   | OneToMany    |
| 3  | 용사           | 종족    | ManyToOne    |
| 4  | 마물군단       | 마물장군  | ManyToMany   |
| 5  | 마물장군       | 종족    | ManyToOne    |

&nbsp;

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

&nbsp;

## **🔲 주요 화면**
<h3>[시작화면 - 사용자, 관리자]</h3>
<img src="https://github.com/user-attachments/assets/a4c2df0a-ebe3-4710-8972-2772c312e54e" alt="사용자 시작화면" style="display:inline-block; width:100%;"/>
<img src="https://github.com/user-attachments/assets/4b4c1d23-e4d2-4eb3-a6aa-c14727c09dcf" alt="관리자 시작화면" style="display:inline-block; width:100%;"/>

- 사용자 화면과 관리자 화면을 분리하였습니다.


- 사용자는 검색기능과 상세정보, 모의전투기능을 제공하며, 등록,수정,삭제, 통계확인의 기능을 사용할 수 없습니다.


- 사용자가 관리자만 볼 수 있는 화면을 API를 입력해서 접속시도시, Interceptor를 통해 세션을 체크한 후 세션이 존재하지 않으면 관리자 로그인 화면으로 이동합니다.
  
&nbsp;

<h3>[목록화면]</h3>
<img src="https://github.com/user-attachments/assets/efe475b3-bda9-4032-8966-f34510d19a85" alt="목록화면" style="display:inline-block; width:100%;"/>

- 검색기능을 수행할 수 있습니다.


- 각각의 목록은 테이블 형태의 동일한 UI로 구현하였고, 관리자일 시 용사 등록 버튼이 보이게 됩니다.

<h3 style="margin-top: 150px;">[상세화면]</h3>
<img src="https://github.com/user-attachments/assets/dd4d3cdf-b373-41e8-a7dd-7e688b5e49b4" alt="상세화면" style="display:inline-block; width:100%;"/>
<img src="https://github.com/user-attachments/assets/0a2819ba-7216-4f04-bd00-937ac1889dd9" alt="상세화면모달" style="display:inline-block; width:100%;"/>

- 상세정보에는 용사의 정보, 능력치와 연결되어 있는 종족, 스킬, 아이템을 확인 할 수 있습니다.


- 능력치를 보여주는 각각의 내용을 클릭시 모달화면을 보여주고, 기본 능력치와 보정(아이템, 스킬, 종족) 능력치를 같이 보여줍니다.

&nbsp;

<h3>[등록화면]</h3>
<img src="https://github.com/user-attachments/assets/4c544b43-e3c0-4d37-81d9-83d0c15efaa0" alt="등록화면" style="display:inline-block; width:100%;"/>
<img src="https://github.com/user-attachments/assets/318ec493-0220-4cf0-9b41-43fd2aa046a0" alt="등록-아이템추가" style="display:inline-block; width:100%;"/>

- 스킬, 종족 선택 -> 스킬 종족은 용사 한명당 1개씩만 연결될 수 있으므로 Select Box로 선택할 수 있게 구현하였습니다.<br>


- 아이템 선택 -> 용사는 여러개의 아이템을 장착할 수 있으므로 Check Box로 구현했고, 다른 용사가 착용중인 아이템을 제외한 나머지를 리스트로 가져왔습니다.

&nbsp;

<h3>[통계화면]</h3>
<img src="https://github.com/user-attachments/assets/88ffd5c1-26e3-49bd-ad15-f7d6a4524cd1" alt="통계화면" style="display:inline-block; width:100%;"/>

- 용사 통계 -> 용사의 총 인원수의 능력치를 모두 합친 결과를 보여줍니다.<br>(용사의 능력치 + 용사가 착용하고 있는 아이템,스킬 능력치 + 종족 능력치)


- 마물군단 통계 -> 마물군단의 능력치를 모두 합친 결과를 보여줍니다.<br>(마물군단의 능력치 + 마물군단을 관리하는 마물장군의 능력치)


- 종족 통계 -> 종족별로 소속된 용사의 수에 따른 총 능력치를 보여줍니다.<br>(종족에 해당하는 용사의 수 * 종족 기본 능력치)

&nbsp;

<h3>[모의전투화면]</h3>
<img src="https://github.com/user-attachments/assets/2b97f566-9475-40c6-8503-e56833dd495a" alt="모의전투1" style="display:inline-block; width:100%;"/>
<img src="https://github.com/user-attachments/assets/7ddf3770-f4c8-4260-87d7-c44eae64a57d" alt="모의전투2" style="display:inline-block; width:100%;"/>

- 용사와 마물군단과의 전투입니다. 용사는 여러명을 선택할 수 있게 CheckBox로 구현했고, 마물군단은 하나의 군단만이 용사를 상대하기 위해 Radio Button으로 구현하였습니다.


- 각각을 선택하고 모의 전투 시작 버튼을 클릭하면 전투결과와 스탯 보정 결과가 보여집니다.


- 용사의 총 공격력, 방어력과 마물군단의 총 공격력, 방어력을 비교해 계산합니다.


- | 조건                         | 결과       |
  |----------------------------|----------|
  | 용사들의 공격력 총합 > 마물군단의 총방어력   | 용사 승     |
  | 마물군단의 총공격력 > 용사들의 방어력 총합   | 마물군단 승   |
  | 양쪽 모두의 공격력이 상대의 방어력을 넘지 못함 | 무승부      |
  | 양쪽 모두의 공격력이 상대의 방어력을 넘음    | 양쪽 모두 전멸 |