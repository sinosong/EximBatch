package com.brilliance.batch.job.processer;

import com.brilliance.batch.model.BizCanvas;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("XmlitemProcessor")
public class XmlitemProcessor implements ItemProcessor<BizCanvas, BizCanvas> {

	@Override
	public BizCanvas process(BizCanvas canvas) throws Exception {

//        System.out.println("Processing..." + canvas.toString());

		return canvas;
	}

}