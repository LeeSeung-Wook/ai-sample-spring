# AI 코드 규칙 레퍼런스

## 적용 범위
- `src/main/java/com/example/demo/board/**`에 적용
- `src/main/java/com/example/demo/user/**`에 적용
- 신규 도메인 패키지도 동일 규칙 적용

## 구조 규칙
- 패키지는 도메인 단위로 분리 (`board`, `user` 등)
- 도메인마다 아래 6개 파일 구조 유지
  - `<Domain>.java` (엔티티)
  - `<Domain>Controller.java`
  - `<Domain>Service.java`
  - `<Domain>Repository.java`
  - `<Domain>Request.java`
  - `<Domain>Response.java`

## 계층 책임 규칙
- Controller:
  - 라우팅/요청/응답 처리만 담당
  - 비즈니스 로직 작성 금지
- Service:
  - 비즈니스 로직 담당
  - 주입된 repository를 통해서만 DB 작업 수행
- Repository:
  - 영속성 접근만 담당
  - 기본적으로 `JpaRepository<Entity, Integer>` 확장
- DTO 경계:
  - Controller에서 Entity를 직접 반환하지 않음
  - Request/Response DTO를 사용

## DTO 규칙
- Request DTO:
  - `<Domain>Request` 내부 `static class`로 정의
  - 기능 중심 이름 사용 (`Save`, `Login`, `Join` 등)
- Response DTO:
  - `<Domain>Response` 내부 `static class`로 정의
  - 기본 이름: `Min`, `Max`, `Detail`
  - Entity를 생성자 인자로 받아 필요한 값만 매핑

## 엔티티 규칙
- 테이블명은 `_tb`로 끝나야 함
- PK 규칙:
  - `@Id`
  - `@GeneratedValue(strategy = GenerationType.IDENTITY)`
- 연관관계 fetch:
  - 기본 `FetchType.LAZY`
- 생성자/빌더:
  - `@NoArgsConstructor` 유지
  - 객체 생성은 `@Builder` 사용
  - 컬렉션 필드는 빌더 인자로 받지 않음
- 생성 시각:
  - `@CreationTimestamp` 사용

## 트랜잭션 규칙
- Service 클래스 기본값:
  - `@Transactional(readOnly = true)`
- 쓰기 메서드:
  - 메서드 레벨 `@Transactional` 명시

## Lombok 규칙
- 의존성 주입:
  - `final` 필드 + `@RequiredArgsConstructor`
- DTO/엔티티 접근자:
  - 프로젝트 규칙상 `@Data` 사용 가능
- 객체 생성:
  - `@Builder` 우선 사용

## 네이밍 규칙
- 클래스명: `PascalCase`
- 메서드/필드명: `camelCase`
- Repository: `<Domain>Repository`
- Controller: `<Domain>Controller`
- Service: `<Domain>Service`

## AI 검증 체크리스트
- [ ] 패키지/클래스명이 도메인 템플릿을 따른다
- [ ] Controller에 비즈니스 로직이 없다
- [ ] Service에 클래스 레벨 `readOnly = true`가 있다
- [ ] 쓰기 메서드에 트랜잭션이 명시되어 있다
- [ ] Controller 응답이 Entity 직접 반환이 아니라 Response DTO다
- [ ] Request/Response DTO가 중첩 static class 구조다
- [ ] JPA 엔티티 테이블명이 `_tb`를 사용한다
- [ ] JPA 연관관계가 기본 lazy fetch다
- [ ] 생성자/빌더/Lombok 구성이 규칙과 일치한다
