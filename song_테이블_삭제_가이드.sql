-- ============================================
-- song 테이블 삭제 가이드 (DBeaver에서 실행)
-- ============================================

-- 1단계: 테이블 목록 확인 (song 테이블이 있는지 확인)
SELECT table_schema, table_name 
FROM information_schema.tables
WHERE table_schema = 'public' 
  AND table_name = 'song'
ORDER BY table_name;

-- 2단계: song 테이블을 참조하는 외래키 제약조건 확인
SELECT
    tc.table_name AS foreign_table_name,
    kcu.column_name AS foreign_column_name,
    ccu.table_name AS referenced_table_name,
    ccu.column_name AS referenced_column_name,
    tc.constraint_name
FROM information_schema.table_constraints AS tc
JOIN information_schema.key_column_usage AS kcu
    ON tc.constraint_name = kcu.constraint_name
    AND tc.table_schema = kcu.table_schema
JOIN information_schema.constraint_column_usage AS ccu
    ON ccu.constraint_name = tc.constraint_name
    AND ccu.table_schema = tc.table_schema
WHERE tc.constraint_type = 'FOREIGN KEY'
    AND ccu.table_name = 'song';

-- 3단계: song 테이블을 참조하는 외래키가 있다면 먼저 삭제
-- (예: like 테이블이 song_id로 song을 참조하는 경우)
-- 아래 쿼리로 제약조건 이름을 확인한 후 삭제하세요
SELECT constraint_name
FROM information_schema.table_constraints
WHERE table_name = 'like'
  AND constraint_type = 'FOREIGN KEY'
  AND constraint_name LIKE '%song%';

-- 제약조건 삭제 (제약조건 이름을 위에서 확인한 이름으로 변경)
-- ALTER TABLE "like" DROP CONSTRAINT IF EXISTS like_song_id_fkey;

-- 4단계: song 테이블 삭제
-- ⚠️ 주의: 이 명령어는 되돌릴 수 없습니다!
DROP TABLE IF EXISTS song CASCADE;

-- CASCADE 옵션은 song 테이블을 참조하는 모든 객체(외래키, 인덱스 등)도 함께 삭제합니다.
-- 안전하게 하려면 CASCADE 없이 실행하고, 외래키가 있다면 에러가 나므로 위의 3단계를 먼저 실행하세요.

-- 5단계: 삭제 확인 (song 테이블이 없어졌는지 확인)
SELECT table_schema, table_name 
FROM information_schema.tables
WHERE table_schema = 'public' 
  AND table_name = 'song';

-- 결과가 없으면 삭제 성공!

