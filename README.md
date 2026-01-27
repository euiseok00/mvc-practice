# 코멘토 백엔드 직무부트캠프 (26-01-17 ~ 26-02-14)

# [1주차] 과제 수행 주간보고 (26-01-17 ~ 26-01-22)

1. 개발환경 셋팅 및 인프라 구축
   
   - 1.1 로컬 개발 환경 구성
- IntelliJ Community 버전 설치 및 설정(완료)
- MariaDB 서버 설치 및 데이터베이스 생성(완료)
- DBeaver 설치 및 MariaDB Connection 연동 테스트(완료)

   - 1.2 프레임워크 환경 설정
- Spring MVC 환경설정 및 기본 API PING 테스트(완료)

<img width="560" height="232" alt="스크린샷 2026-01-20 235121" src="https://github.com/user-attachments/assets/a0802b21-7ec0-4045-b65c-a96facec7e49" />
   
   - 1.3 Datasource 설정 및 MyBatis 연동 작업(진행)
     

<img width="815" height="259" alt="스크린샷 2026-01-21 175219" src="https://github.com/user-attachments/assets/b3d83a93-34b7-40b4-8d6e-379cd727a15b" />


2. 기타 업무 및 학습
   
   - 2.1 협업 도구 활용
- GitHub 개인 계정 생성 및 리포지토리 구성(완료)
- Git 기본 명령어 및 버전 관리 사용 방법 숙지(완료)

3. 수행 현황 요약
- 완료 항목: 1.1, 1.2, 2.1 
- 진행 항목: 1.3 // /resources/ 에러 해결해야함 
- 목표 달성률: 현재까지 90% 달성

4. 질문사항
- 4.1
: 아래 코드에 대한 Cannot resolve location 에러를 어떻게 해결방법에 대한 질문입니다.
에러가 떠도 ping 테스트 및 mybatis 연동 후 구동 테스트는 잘 되는데 이 단계에서는 의도된 것인지 수정해야 할 부분이 있는지 궁금합니다! 

       <mvc:resources mapping="/resources/**" location="/resources/" />

  - 4.1.1 원인 파악
- 현재 src/main/webapp 디렉토리 하위에 resources 폴더가 존재하지 않음
- Spring이 정적 리소스를 찾을 영역이 실제 경로와 일치하지 않아 발생하는 문제로 파악됨

   - 4.1.2 해결 방안 고민
- resources 폴더를 webapp의 하위 폴더에 위치시키려 했으니 멘토님께서 제시하신 최종 폴더 구조와 달라져서 보류
- 경로 설정 변경 1. classpath:/resources/ 2. /WEB-INF/../resources/ -> 변경 후에도 에러 유지

- 4.2 
: 1.3 결과의 소스 데이터를 멘토님이 제시하신 결과를 보고 제가 로컬 mariadb에 쿼리문으로 일일히 insert 하였는데 의도하신 방법이 맞는지 궁금합니다. 아니라면 어떤 방법을 의도하셨는지도 궁금합니다!

<img width="625" height="203" alt="image" src="https://github.com/user-attachments/assets/69a0e82f-2ac1-465b-8026-c278f7fe1c6a" />

# [2주차] 과제 수행 주간보고 (26-01-23 ~ 26-01-29)

-- 사전학습 -- 

■  1. HTTP (HyperText Transfer Protocol)
- 정의 : 서버와 클라이언트가 서로 데이터를 주고받기 위해 사용하는 통신 규약(protocol)
- 데이터 종류 : HTML, TEXT, 이미지, 영상, JSON, XML 등

1.1 통신 구조 

- 클라이언트 - 서버 구조 : 클라이언트가 요청(request)하면 서버가 응답(response)을 함
  
> 브라우저 주소창에 https://example.com/rest/login/202601 입력을 가정 

- DNS 조회 : 브라우저는 example.com이라는 도메인 이름을 숫자로 된 실제 서버 주소(ip)로 변환하기 위해 서버에 요청 전송 
- TCP/IP 연결 (3-Way Handshake) : IP 주소를 찾으면 브라우저와 서버 간의 신뢰성 있는 연결을 위해 통신 통로를 생성
- HTTP 요청 전달 : 연결된 통로를 통해 브라우저가 HTTP 요청 메시를 서버에 전송 
- 서버 로직 처리 : 서버는 요청을 받아 로직을 수행 ex) DB 에서 데이터를 추출하는 로직
- HTTP 응답 생성 및 전송 : 서버가 처리 결과를 JSON 형식으로 http 응답 메시지로 브라우저에 전송 
- 브라우저 렌더링 : 브라우저는 받은 데이터를 사용자 화면에 출력

1.2 특성 

→ 1.2.1 비연결성 : 클라이언트가 서버에게 요청하고 응답을 받으면 즉시 통신 통로 폐쇄
- 장점 : 실제 요청 순간에만 연결을 유지하여 트래픽이 많아도 서버 자원을 효율적으로 사용
- 단점 : 매번 새로운 요청 발생시  TCP/IP 연결 (3-Way Handshake)이 반복되어 오버헤드 발생
- 해결책 : 현대의 HTTP에서는 keep-alive 헤더를 사용하여 일정 시간 동안 연결 유지 

→ 1.2.2 무상태성 : 서버는 클라이언트의 이전 상태를 보존하지 않음 
- 장점 : 서버가 상태를 기억할 필요가 없으므로 어떤 서버가 요청을 처리해도 결과가 동일, 서버를 여러 대 늘려야 할  때 (scale-out) 유리 
- 단점 : 서버가 상태를 모르기 때문에 클라이언트는 매 요청이 필요한 모든 정보를 담아 보내야 함 
- 해결책 : 쿠키, 세션, JWT 등

■  2. RESTful API (Representational State Transfer)
- 웹의 기존 HTTP를 그대로 활용하기 위한 아키텍쳐 스타일
-  HTTP를  기반해서 REST 원칙을 엄격하게 지켜 설계된 API, 이름만 보고 직관적으로 의도를 파악할 수 있게 하기 위함
  
2.1  REST API의 3요소 

→ 2.1.1 자원(Resource) - URI : 모든 것은 자원으로 관리하고 명사를 사용하며 슬래시(/)로 계층 구조를 나타냄 ex) /rest/login/202601

→ 2.1.2 행위(Verb) - HTTP Method : 자원에 대해 무엇을 할지 HTTP 메서드로 표현 
- GET: 조회, POST: 생성, PUT/PATCH: 수정, DELETE: 삭제
- PUT(전체 수정) : 클라이언트가 보낸 데이터로 기존 리소스의 전체를 덮어씀 
- PATCH(부분 수정) : 변경이 필요한 특정 필드만 서버에 전달
  
→ 2.1.3 표현 (Representation) : 클라이언트와 서버가 데이터를 주고받는 형식, 주로 JSON 

■  3. URL 경로를 표현하는 방식 

3.1 PathVariable (경로 변수)
- URL의 일부를 변수(데이터)로 사용하는 방식
- 형태 : /users/100 
- 용도: 필수 데이터 전달 또는 특정 리소스를 직접 지정할 때 사용

3.2 Query String (쿼리 스트링) 
- URL 끝에 ?로 시작하며 key=value 쌍으로 데이터 전달 
- 형태 : /users?id=100
- 용도: 데이터 정렬, 필터링, 검색 등 부가적인 옵션을 설정할 때 사용

3.3 결론 : Resource를 식별해야 한다면 PathVariable을, 데이터의 결과값을 필터링 및 정렬 등을 해야 한다면 Query String을 선택하는 것이 일반적 

-- API 설계서 -- 

[인터페이스_가이드_ 문서_정의석.pdf](https://github.com/user-attachments/files/24884146/_._._.pdf)

-- 향후 계획 --

- 현재 완성된 초안을 바탕으로 세부적인 내용을 보완할 예정입니다.
- 가독성을 높이기 위해 PPT 자료를 시각적으로 깔끔하게 정리할 예정입니다.


