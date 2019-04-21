package com.brilliance.batch;

import com.brilliance.batch.model.BizCanvas;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("XmlitemProcessor")
public class XmlitemProcessor implements ItemProcessor<String, BizCanvas> {

	@Override
	public BizCanvas process(String item) throws Exception {
		BizCanvas canvas = new BizCanvas();
        canvas.setFilename(item);
        canvas.setExtra(System.currentTimeMillis()+"");

		System.out.println("Processing..." + canvas.toString());
		return canvas;
	}

}