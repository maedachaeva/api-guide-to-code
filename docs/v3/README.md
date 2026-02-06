# v3. SW 활용 현황 통계 API용 SQL
통계 API 구축에 앞서 DB에서 바로 실행 가능한 SQL을 작성하고 결과를 검증했습니다.<br>
집계 기준은 request_info 테이블의 로그인 성공 이벤트(request_code = 'L') 입니다.

<br>

### 공통 집계 기준
- 데이터 소스: statistic.request_info
- 로그인 성공 조건: request_code = 'L'
- 기간 조건: >= 시작일 AND < 종료 경계(종료일 포함을 위해 +1 단위 처리)
- 월/일 단위는 DATE_FORMAT, DATE()로 그룹핑

---

#### 1) 월별 접속자 수 (MAU)
```sql
SELECT
	DATE_FORMAT(create_date, '%Y-%m') AS yearMonth,
    COUNT(DISTINCT user_id) AS uniqueUserCount
 FROM statistic.request_info
 WHERE request_code = 'L'
    AND create_date >= '2025-12-01'
  	AND create_date <  '2026-02-01'
 GROUP BY DATE_FORMAT(create_date, '%Y-%m')
 ORDER BY yearMonth;
```

<br>

#### 2) 일별 접속자 수 (DAU)
```sql
SELECT
  DATE(create_date) AS date,
  COUNT(DISTINCT user_id) AS uniqueUserCount
FROM statistic.request_info
WHERE request_code = 'L'
  AND create_date >= '2026-01-01'
  AND create_date <  DATE_ADD('2026-01-15', INTERVAL 1 DAY)
GROUP BY DATE(create_date)
ORDER BY date;
```

<br>

#### 3) 평균 하루 로그인 수
지정 기간 동안 발생한 로그인 성공 이벤트 총합을 기간 일수로 나눈 평균값을 조회합니다. (동일 사용자의 중복 로그인도 모두 합산)
```sql
SELECT
  '2026-01-01' AS fromDate,
  '2026-01-31' AS toDate,
  ROUND(COUNT(*) / (DATEDIFF('2026-01-31', '2026-01-01') + 1), 1) AS loginCount
FROM statistic.request_info
WHERE request_code = 'L'
  AND create_date >= '2026-01-01'
  AND create_date <  DATE_ADD('2026-01-31', INTERVAL 1 DAY);
```

<br>

#### 4) 지정 기간 내 로그인 수 (휴일 제외 예정)
지정 기간 동안 발생한 로그인 성공 이벤트 총합을 조회합니다. 휴일 제외는 API 구현 단계에서 확장 예정입니다.
```sql
SELECT
  '2026-01-01' AS fromDate,
  '2026-01-31' AS toDate,
  COUNT(*) AS loginCount
FROM statistic.request_info
WHERE request_code = 'L'
  AND create_date >= '2026-01-01'
  AND create_date <  DATE_ADD('2026-01-31', INTERVAL 1 DAY);
```

<br>

#### 5) 부서별 월별 로그인 수
지정 기간 동안 발생한 로그인 성공 이벤트 수를 부서별/월별로 집계합니다. 부서명까지 응답하기 위해 users, department 테이블을 조인합니다.
```sql
SELECT
  d.dept_code AS departmentId,
  d.dept_name AS departmentName,
  DATE_FORMAT(ri.create_date, '%Y-%m') AS yearMonth,
  COUNT(*) AS loginCount
FROM statistic.request_info ri
JOIN statistic.users u
  ON ri.user_id = u.user_id
JOIN statistic.department d
  ON u.dept_code = d.dept_code
WHERE ri.request_code = 'L'
  AND ri.create_date >= '2025-12-01'
  AND ri.create_date <  '2026-02-01'
GROUP BY d.dept_code, d.dept_name, DATE_FORMAT(ri.create_date, '%Y-%m')
ORDER BY d.dept_code, yearMonth;
```
