package com.brilliance.batch.mapper.db;


import com.brilliance.batch.model.BizCanvas;

import java.util.List;

public interface BizCanvasMapper{

    List<BizCanvas> getMaxWorkDate(String workdate, String bizcode);

}
