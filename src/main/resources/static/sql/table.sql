/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 130002
 Source Host           : localhost:5432
 Source Catalog        : spring_mvc
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130002
 File Encoding         : 65001

 Date: 18/03/2021 10:48:19
*/


-- ----------------------------
-- Sequence structure for genre_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."genre_id_seq";
CREATE SEQUENCE "public"."genre_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for keywords_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."keywords_id_seq";
CREATE SEQUENCE "public"."keywords_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for genres
-- ----------------------------
DROP TABLE IF EXISTS "public"."genres";
CREATE TABLE "public"."genres" (
  "id" int4 NOT NULL DEFAULT nextval('genre_id_seq'::regclass),
  "name" varchar COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for keywords
-- ----------------------------
DROP TABLE IF EXISTS "public"."keywords";
CREATE TABLE "public"."keywords" (
  "id" int4 NOT NULL DEFAULT nextval('keywords_id_seq'::regclass),
  "name" varchar COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS "public"."movies";
CREATE TABLE "public"."movies" (
  "id" int4 NOT NULL,
  "title" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "released_date" date NOT NULL,
  "trailer" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "runtime" int2 NOT NULL,
  "number_votes" int8 DEFAULT 0
)
;

-- ----------------------------
-- Table structure for movies_genres
-- ----------------------------
DROP TABLE IF EXISTS "public"."movies_genres";
CREATE TABLE "public"."movies_genres" (
  "movie_id" int4 NOT NULL,
  "genre_id" int4 NOT NULL
)
;

-- ----------------------------
-- Table structure for movies_keywords
-- ----------------------------
DROP TABLE IF EXISTS "public"."movies_keywords";
CREATE TABLE "public"."movies_keywords" (
  "movie_id" int4 NOT NULL,
  "keyword_id" int4 NOT NULL
)
;

-- ----------------------------
-- Table structure for ratings
-- ----------------------------
DROP TABLE IF EXISTS "public"."ratings";
CREATE TABLE "public"."ratings" (
  "id" int4 NOT NULL,
  "movie_id" int4 NOT NULL,
  "reviewer_id" int4 NOT NULL,
  "rate" int2 NOT NULL
)
;

-- ----------------------------
-- Table structure for reviewers
-- ----------------------------
DROP TABLE IF EXISTS "public"."reviewers";
CREATE TABLE "public"."reviewers" (
  "id" int4 NOT NULL,
  "username" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."genre_id_seq"
OWNED BY "public"."genres"."id";
SELECT setval('"public"."genre_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."keywords_id_seq"
OWNED BY "public"."keywords"."id";
SELECT setval('"public"."keywords_id_seq"', 2, false);

-- ----------------------------
-- Primary Key structure for table genres
-- ----------------------------
ALTER TABLE "public"."genres" ADD CONSTRAINT "genre_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table keywords
-- ----------------------------
ALTER TABLE "public"."keywords" ADD CONSTRAINT "keywords_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table movies
-- ----------------------------
ALTER TABLE "public"."movies" ADD CONSTRAINT "movies_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ratings
-- ----------------------------
ALTER TABLE "public"."ratings" ADD CONSTRAINT "ratings_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table reviewers
-- ----------------------------
ALTER TABLE "public"."reviewers" ADD CONSTRAINT "reviewer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table movies_genres
-- ----------------------------
ALTER TABLE "public"."movies_genres" ADD CONSTRAINT "genre_fk" FOREIGN KEY ("genre_id") REFERENCES "public"."genres" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."movies_genres" ADD CONSTRAINT "movie_fk" FOREIGN KEY ("movie_id") REFERENCES "public"."movies" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table movies_keywords
-- ----------------------------
ALTER TABLE "public"."movies_keywords" ADD CONSTRAINT "keyword_fk" FOREIGN KEY ("keyword_id") REFERENCES "public"."keywords" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."movies_keywords" ADD CONSTRAINT "movie_fk" FOREIGN KEY ("movie_id") REFERENCES "public"."movies" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table ratings
-- ----------------------------
ALTER TABLE "public"."ratings" ADD CONSTRAINT "movie_fk" FOREIGN KEY ("movie_id") REFERENCES "public"."movies" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."ratings" ADD CONSTRAINT "reviewer_fk" FOREIGN KEY ("reviewer_id") REFERENCES "public"."reviewers" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
