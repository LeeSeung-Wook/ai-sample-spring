---
name: spring-code-convention
description: 이 프로젝트의 Spring Boot 코드 컨벤션(도메인 패키지 구조, DTO 경계, JPA 엔티티 규칙, 트랜잭션 기본값, 네이밍 규칙)을 강제하고 적용한다. src/main/java/com/example/demo 경로의 Java 코드를 생성/수정/리팩터링/리뷰할 때 사용한다.
---

# 스프링 코드 컨벤션 스킬

이 프로젝트의 Java 백엔드 코드를 변경할 때 항상 이 스킬을 사용한다.

## 로드 순서
1. `../../references/code-rule-ai.md`를 읽는다.
2. 규칙 충돌 시 현재 저장소 코드를 우선 존중하고, 이후 레퍼런스 규칙에 맞게 정렬한다.

## 실행 규칙
1. 도메인 패키지 구조를 유지한다.
   - `<Domain>`, `<Domain>Controller`, `<Domain>Service`, `<Domain>Repository`, `<Domain>Request`, `<Domain>Response`
2. 계층 경계를 유지한다.
   - Controller: HTTP 처리만
   - Service: 비즈니스 로직
   - Repository: 영속성 처리만
3. DTO 경계를 유지한다.
   - Controller에서 Entity를 직접 노출하지 않는다.
4. JPA/Lombok/트랜잭션 규칙은 레퍼런스 문서를 따른다.

## 출력 계약
- 코드 생성 시:
  - `../../references/code-rule-ai.md` 체크리스트를 만족하는 코드만 생성한다.
- 코드 리뷰 시:
  - 위반 사항을 규칙 카테고리별로 정리한다.
  - 각 위반마다 구체적인 수정 패치를 제시한다.

## 최소 리뷰 형식
- `Violation`: 위반 내용 한 줄 요약
- `Location`: 파일 경로 + 라인
- `Rule`: `../../references/code-rule-ai.md`의 규칙명
- `Fix`: 필요한 정확한 코드 변경
