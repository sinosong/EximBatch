package com.brilliance.batch.job.processer;

import com.brilliance.batch.model.BizCanvas;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("XmlitemProcessor")
public class XmlitemProcessor implements ItemProcessor<BizCanvas, BizCanvas> {

	@Override
	public BizCanvas process(BizCanvas item) throws Exception {
		System.out.println(item.toString());
        System.out.println("----------------------------------------");
//		BizCanvas canvas = new BizCanvas();
//        canvas.setFilename();
//        canvas.setExtra(System.currentTimeMillis()+"");
//
//		System.out.println("Processing..." + canvas.toString());
		return item;
	}

}