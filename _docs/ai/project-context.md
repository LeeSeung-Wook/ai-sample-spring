# PROJECT CONTEXT

## 1. 프로젝트 개요
- 프로젝트명: demo
- 목적: 블로그 만들기 프로젝트 (사용자, 게시글, 댓글 중심의 CRUD 학습/구현)
- 현재 상태: Spring Boot 기반 기본 골격 및 도메인 모델(User, Board, Reply) 구성 완료

## 2. 전체 아키텍처
- 아키텍처 스타일: 도메인 기반 플랫 패키지 + 계층형 흐름
- 요청 흐름: Controller -> Service -> Repository(JPA) -> H2 DB
- 렌더링 방식: SSR(Mustache 템플릿) + 향후 REST API 분리 확장 구조
- 공통 모듈: `_core/utils/Resp` (API 공통 응답 래퍼)

### 2.1 패키지 구조
- `com.example.demo.board`: 게시글 도메인 (Entity/Controller/Service/Repository/Request/Response)
- `com.example.demo.user`: 사용자 도메인 (Entity/Controller/Service/Repository/Request/Response)
- `com.example.demo.reply`: 댓글 도메인 (Entity/Controller/Service/Repository/Request/Response)
- `com.example.demo._core.utils`: 공통 유틸

### 2.2 도메인 관계
- User(1) - Board(N)
- User(1) - Reply(N)
- Board(1) - Reply(N)
- 연관관계 fetch 전략: LAZY

## 3. 기술 스택
- Language: Java 21
- Framework: Spring Boot 3.4.3
- Build Tool: Gradle
- Web: Spring Web MVC
- Template Engine: Mustache
- ORM/Data Access: Spring Data JPA + Hibernate
- Database: H2 (in-memory)
- Dev Convenience: Spring Boot DevTools, Lombok
- Test: spring-boot-starter-test (JUnit Platform)

## 4. 설정/운영 컨텍스트
- 서버 포트: `8080`
- 인코딩: UTF-8 강제
- OSIV: `false`
- JPA SQL 로그: 활성화
- 배치 페치 크기: `10`
- 세션 기반 인증 컨텍스트 사용 (`HttpSession`)
- 초기 데이터: `src/main/resources/db/data.sql` 로딩

## 5. 현재 구현 범위
- 엔티티: User, Board, Reply
- 리포지토리: 각 도메인별 JpaRepository 구성
- 서비스: 도메인별 서비스 골격 구성
- 컨트롤러: SSR 컨트롤러 골격 구성 (`/home` 진입 가능)
- 뷰: `home.mustache` 기본 페이지

## 6. 개발 규칙 (프로젝트 내부 컨벤션 반영)
- 도메인별 플랫 구조 유지 (레이어별 패키지 분리 금지)
- SSR Controller와 REST ApiController 파일 분리
- REST 응답은 `Resp<T>` 래퍼 사용
- DTO는 Service에서 생성/반환, Controller에 Entity 직접 노출 금지
- 테이블 네이밍: `*_tb`, PK 타입: `Integer`

## 7. 다음 단계 제안
- 게시글/댓글/회원가입-로그인 실제 CRUD 유스케이스 완성
- SSR 페이지(목록/상세/작성/수정) 및 폼 바인딩 추가
- REST API (`/api/...`) 분리 구현 및 예외 처리 표준화
- 인증/인가 흐름(세션 체크 인터셉터 등) 보강
- 통합 테스트 및 도메인별 서비스 테스트 확장
