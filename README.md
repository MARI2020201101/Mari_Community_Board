# :small_blue_diamond:Mari_Community_Board
## 기능
- 게시글 조회, 등록, 수정, 삭제가 가능
- 회원제 게시판
- 게시글 페이징
***
### 글 등록 페이지
![글 등록 페이지](https://github.com/MARI2020201101/Mari_Community_Board/blob/master/register-page.png)

### 등록 완료 페이지 (리스트로 redirect)
![등록 완료 페이지](https://github.com/MARI2020201101/Mari_Community_Board/blob/master/register-result.png)
***
## 신경 쓴 점
- JPA를 활용하여 1 : n 연관관계 처리
- View영역의 DTO클래스와 Database영역의 Entity클래스를 분리하여 이상현상 방지
- Java8문법을 활용한 클린 코드 작성
- jUnit을 이용하여 더미 데이터의 신속한 생성
- 템플릿 (thymeleaf) 를 활용하여 레이아웃과 콘텐츠를 분리
- BaseEntity, @EnableJpaAuditing 를 활용하여 중복코드 제거
- gradle을 빌드 도구로서 사용, 보다 깔끔한 디펜던시 파일 설정
- 인터페이스의 default 메소드를 활용하여 중복코드 제거
- RedirectAttributes 의 addFlashAttribute 메소드를 활용하여 글 등록시에만 모달 창이 나타나도록 설계
