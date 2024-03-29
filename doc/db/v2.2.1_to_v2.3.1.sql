ALTER TABLE "xxl_job_info"
    ADD COLUMN "schedule_type" varchar(50),
  ADD COLUMN "schedule_conf" varchar(128),
  ADD COLUMN "misfire_strategy" varchar(50) DEFAULT 'DO_NOTHING';

COMMENT ON COLUMN "xxl_job_info"."schedule_type" IS '调度类型';

COMMENT ON COLUMN "xxl_job_info"."schedule_conf" IS '调度配置，值含义取决于调度类型';

COMMENT ON COLUMN "xxl_job_info"."misfire_strategy" IS '调度过期策略';


ALTER TABLE "xxl_job_group"
    ADD COLUMN "update_time" date;

COMMENT ON COLUMN "xxl_job_group"."update_time" IS '更新时间';

update "xxl_job_info" set schedule_type = 'CRON' where schedule_type is null ;
update "xxl_job_info" set schedule_conf = job_cron where schedule_conf is null;

ALTER TABLE  "xxl_job_info"
DROP COLUMN "job_cron";

ALTER TABLE "xxl_job_log"
    ALTER COLUMN "executor_fail_retry_count" SET DEFAULT 0;

ALTER TABLE "xxl_job_log"
    ALTER COLUMN "alarm_status" SET DEFAULT 0;