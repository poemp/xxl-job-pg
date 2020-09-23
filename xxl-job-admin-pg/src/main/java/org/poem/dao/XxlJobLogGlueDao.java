package org.poem.dao;

import org.poem.core.model.XxlJobLogGlue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * job log for glue
 *
 * @author xuxueli 2016-5-19 18:04:56
 */
@Mapper
public interface XxlJobLogGlueDao {

    public int save(XxlJobLogGlue xxlJobLogGlue);

    public List<XxlJobLogGlue> findByJobId(@Param("jobId") Long jobId);

    public int removeOld(@Param("jobId") Long jobId, @Param("limit") int limit);

    public int deleteByJobId(@Param("jobId") Long jobId);

}
