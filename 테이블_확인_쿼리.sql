-- ============================================
-- 테이블 확인 쿼리 (DBeaver에서 실행)
-- ============================================

-- 1. 전체 테이블 목록 확인 (song이 있는지 확인)
SELECT table_schema, table_name 
FROM information_schema.tables
WHERE table_schema = 'public' 
ORDER BY table_name;

-- 2. song 또는 Song (대소문자 구분 없이) 검색
SELECT table_schema, table_name 
FROM information_schema.tables
WHERE table_schema = 'public' 
  AND LOWER(table_name) LIKE '%song%'
ORDER BY table_name;

-- 3. PostgreSQL 시스템 카탈로그에서 직접 확인
SELECT schemaname, tablename 
FROM pg_tables 
WHERE schemaname = 'public'
  AND tablename LIKE '%song%'
ORDER BY tablename;

-- 4. 모든 public 스키마의 테이블 목록 (확인용)
SELECT 
    table_schema,
    table_name,
    table_type
FROM information_schema.tables
WHERE table_schema = 'public'
ORDER BY table_name;

