-- song 테이블 삭제 명령어
-- DBeaver에서 실행하세요

-- 1. 외래키 제약조건이 있다면 먼저 확인
-- SELECT * FROM information_schema.table_constraints 
-- WHERE table_name = 'song';

-- 2. song 테이블을 참조하는 외래키가 있다면 먼저 삭제
-- ALTER TABLE "like" DROP CONSTRAINT IF EXISTS like_song_id_fkey;

-- 3. song 테이블 삭제
DROP TABLE IF EXISTS song CASCADE;

-- CASCADE 옵션은 song 테이블을 참조하는 모든 객체(외래키, 인덱스 등)도 함께 삭제합니다.
-- 주의: 이 명령어는 되돌릴 수 없습니다!

