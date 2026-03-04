# 코드 컨벤션

## 1. 패키지 구조 규칙
- 도메인 기준으로 패키지를 분리한다. (예: `board`, `user`)
- 각 도메인은 아래 기본 구성을 맞춘다.
  - `도메인명` 엔티티 (`Board`, `User`)
  - `도메인명Controller`
  - `도메인명Service`
  - `도메인명Repository`
  - `도메인명Request`
  - `도메인명Response`

## 2. 계층 책임 규칙
- `Controller`는 요청/응답 처리와 라우팅만 담당한다.
- `Service`는 비즈니스 로직을 담당한다.
- `Repository`는 DB 접근만 담당한다.
- Entity를 Controller에 직접 노출하지 않고, DTO(`Request`/`Response`)를 통해 전달한다.

## 3. DTO 규칙
- 요청 DTO는 `도메인명Request` 내부 `static class`로 작성한다.
- 요청 DTO 클래스명은 기능명 중심으로 작성한다. (예: `Save`, `Login`, `Join`)
- 응답 DTO는 `도메인명Response` 내부 `static class`로 작성한다.
- 응답 DTO 클래스명은 기본적으로 `Min`, `Max`, `Detail`을 사용한다.
- 응답 DTO는 Entity를 인자로 받아 필요한 값만 매핑한다.

## 4. Entity 규칙
- 테이블명은 `*_tb` 형식으로 지정한다. (예: `user_tb`, `board_tb`)
- PK는 `@Id` + `@GeneratedValue(strategy = GenerationType.IDENTITY)`를 사용한다.
- 연관관계는 기본적으로 `FetchType.LAZY`를 사용한다.
- 컬렉션은 생성자(`@Builder` 대상)에서 받지 않는다.
- 생성 시각은 `@CreationTimestamp`를 사용한다.
- Hibernate/JPA 매핑을 위해 `@NoArgsConstructor`를 유지한다.

## 5. Service/트랜잭션 규칙
- Service 클래스에는 기본적으로 `@Transactional(readOnly = true)`를 선언한다.
- 쓰기 작업 메서드는 별도로 `@Transactional`을 명시한다.

## 6. Lombok 사용 규칙
- 의존성 주입은 `@RequiredArgsConstructor` + `final` 필드를 사용한다.
- DTO/Entity의 단순 getter/setter는 `@Data` 사용을 기본으로 한다.
- 객체 생성은 `@Builder`를 사용한다.

## 7. 네이밍 규칙
- 클래스명: PascalCase
- 메서드/필드명: camelCase
- Repository 인터페이스명: `도메인명Repository`
- Controller/Service 클래스명: `도메인명Controller`, `도메인명Service`
