# Mari_Community_Board
## 기능
- 게시글 조회, 등록, 수정, 삭제가 가능
- 회원제 게시판
- 게시글 페이징
***
### 작성자가 아닐경우
![작성자가 아닐경우](https://github.com/MARI2020201101/Mari_Board_JPA_MyBatis/blob/master/user!%3Dwriter.png)

### 작성자 or 관리자일 경우
![작성자 or 관리자일 경우](https://github.com/MARI2020201101/Mari_Board_JPA_MyBatis/blob/master/user%3D%3Dwriter.png)
***
## 신경 쓴 점
- JPA를 활용하여 1 : n 연관관계 처리
- jUnit을 이용하여 더미 데이터의 신속한 생성
- 템플릿 (thymeleaf) 를 활용하여 레이아웃과 콘텐츠를 분리
- BaseEntity, @EnableJpaAuditing 를 활용하여 중복코드 제거
- gradle을 빌드 도구로서 사용, 보다 깔끔한 디펜던시 파일 설정
- 인터페이스의 default 메소드를 활용하여 중복코드 제거
