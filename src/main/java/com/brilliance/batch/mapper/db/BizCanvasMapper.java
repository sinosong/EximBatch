package com.brilliance.batch.mapper.db;


import org.apache.ibatis.annotations.Param;

public interface BizCanvasMapper{

    String getMaxWorkDate(@Param("endDate") String endDate);

}
