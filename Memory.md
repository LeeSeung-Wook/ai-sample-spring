# Memory

## 목적
- 이 문서는 현재까지 대화에서 나온 요청과 실제 수행 작업을 빠르게 복기하기 위한 요약 메모다.

## 사용자 요청 요약
1. `board`, `user` 폴더 구조를 확인해서 코드 컨벤션 문서 생성 요청
2. `.person` 문서를 기반으로 `.ai`용 문서 체계(스킬/에이전트/워크플로우) 생성 요청
3. 위 AI 문서를 한글로 재작성 요청
4. `reply_tb` 테이블(필드: `id`, `comment`, 연관관계: `user`, `board`) 및 컨벤션 기반 폴더 구조 생성 요청
5. 지금까지 질문/작업 내역을 프로젝트 최상단 `Memory.md`로 정리 요청

## 수행 작업 요약

### 1) 코드 컨벤션 문서 생성
- 생성 파일:
  - `docs/person/code-rule.md`
- 내용:
  - 도메인 패키지 구조, 계층 책임, DTO/Entity/트랜잭션/Lombok/네이밍 규칙 정리

### 2) AI 문서 체계 구축
- 생성/정리 파일:
  - `_docs/.ai/references/code-rule-ai.md`
  - `_docs/.ai/skills/spring-code-convention/SKILL.md`
  - `_docs/.ai/agent/backend-convention-agent.md`
  - `_docs/.ai/workflow/code-convention-workflow.md`
- 내용:
  - `.person/code-rule.md`를 AI 실행 기준으로 재구성
  - 체크리스트/역할/실행 절차 중심 문서화

### 3) AI 문서 한글화
- 위 4개 AI 문서를 한국어 중심으로 재작성
- 인코딩 이슈를 피하기 위해 파일 저장 인코딩도 정리

### 4) `reply` 도메인 추가 (컨벤션 기반 6종 구조)
- 생성 파일:
  - `src/main/java/com/example/demo/reply/Reply.java`
  - `src/main/java/com/example/demo/reply/ReplyController.java`
  - `src/main/java/com/example/demo/reply/ReplyService.java`
  - `src/main/java/com/example/demo/reply/ReplyRepository.java`
  - `src/main/java/com/example/demo/reply/ReplyRequest.java`
  - `src/main/java/com/example/demo/reply/ReplyResponse.java`
- 엔티티 반영:
  - 테이블명 `reply_tb`
  - 필드 `id`, `comment`, `createdAt`
  - `User`, `Board`와 `@ManyToOne(fetch = FetchType.LAZY)` 연관관계

### 5) 초기 데이터(`data.sql`) 정리
- 수정 파일:
  - `src/main/resources/db/data.sql`
- 반영:
  - `user_tb`, `board_tb`, `reply_tb` 더미 데이터 구성
  - SQL 초기화 에러(BOM 이슈) 해결을 위해 인코딩 정리

## 검증 기록
- `gradlew test` 실행
  - 중간에 `data.sql` BOM으로 실패 1회
  - 인코딩 수정 후 `BUILD SUCCESSFUL` 확인

## 현재 상태
- `reply` 도메인 기본 골격과 DB 초기 데이터 반영 완료
- `.person`/`.ai` 문서 체계 모두 구성 완료
