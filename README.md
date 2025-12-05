SPRING ADVANCED README.md
---

````md
## ⚙️ SPRING ADVANCED

Spring Boot 기반으로 미리 만들어진 해당 프로젝트에 다양한 오류들을 해결하고 코드품질을 개선하는 실습 프로젝트 입니다.

---

## 🛠 Tech Stack
- Java 17  
- Spring Boot 3.3.3  
- Spring Web 
  Spring Data JPA  
- MySQL 8.4.7  
- Lombok

## ## 🚀 주요 기능

### **프로젝트 실행 오류 해결 (Lv0)**
- 스프링 부트 실행 실패 원인 분석 및 환경 설정 복구  
- Resolver 미등록, @Component 누락, DB 설정 문제 등 초기 설정 오류 해결  

---

### **ArgumentResolver 구현 (Lv1)**
- `@AuthUser`로 JWT 기반 사용자 정보 자동 주입 기능 복원  
- 삭제된 Resolver 로직 재구현  

---

### **코드 리팩토링 (Lv2)**
- Early Return 적용해 불필요한 로직 제거  
- 조건문 간소화로 가독성 개선  
- Validation을 DTO로 이동해 서비스 로직 정리  

---

### **N+1 문제 해결 (Lv3)**
- `@EntityGraph` 도입으로 Todo 목록 조회 성능 최적화  

---

### **테스트 코드 개선 (Lv4)**
- 잘못된 테스트 수정 및 예외 타입/네이밍 정리  
- 서비스 로직 보완으로 깨진 테스트 복구  

---