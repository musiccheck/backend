-- ============================================
-- song 테이블 삭제 권한 문제 해결 방법
-- ============================================

-- 1. song 테이블의 소유자 확인
SELECT 
    table_name,
    table_schema,
    tableowner
FROM pg_tables
WHERE tablename = 'song'
  AND schemaname = 'public';

-- 또는
SELECT 
    t.tablename,
    pg_get_userbyid(c.relowner) AS owner
FROM pg_tables t
JOIN pg_class c ON c.relname = t.tablename
WHERE t.tablename = 'song'
  AND t.schemaname = 'public';

-- 2. 현재 사용자 확인
SELECT current_user, session_user;

-- ============================================
-- 해결 방법
-- ============================================

-- 방법 1: 관리자(postgres) 계정으로 로그인해서 삭제
-- DBeaver에서 postgres 사용자로 연결한 후:
-- DROP TABLE IF EXISTS song CASCADE;

-- 방법 2: 소유자에게 권한 요청
-- 소유자가 다음 명령어를 실행:
-- GRANT DROP ON TABLE song TO 현재사용자명;

-- 방법 3: 소유자가 직접 삭제
-- 소유자 계정으로 로그인해서:
-- DROP TABLE IF EXISTS song CASCADE;

-- 방법 4: 소유자 변경 (관리자만 가능)
-- ALTER TABLE song OWNER TO 현재사용자명;

