package com.brilliance.batch;

import com.brilliance.batch.model.Report;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Report, Report> {

	@Override
	public Report process(Report item) throws Exception {
		
		System.out.println("Processing..." + item);
		return item;
	}

}