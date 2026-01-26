# 코멘토 백엔드 직무부트캠프 (26-01-17 ~ 26-02-14)

[주간보고] 1주차 과제 수행 보고 (26-01-17 ~ 26-01-22)

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



