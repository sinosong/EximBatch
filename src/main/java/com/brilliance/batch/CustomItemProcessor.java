package com.brilliance.batch;

import com.brilliance.batch.model.BizCanvas;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<BizCanvas, BizCanvas> {

	@Override
	public BizCanvas process(BizCanvas item) throws Exception {
		
		System.out.println("Processing..." + item);
		return item;
	}

}