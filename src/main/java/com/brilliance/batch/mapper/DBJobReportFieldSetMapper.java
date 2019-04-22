package com.brilliance.batch.mapper;

import com.brilliance.batch.model.BizCanvas;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import java.text.SimpleDateFormat;

public class DBJobReportFieldSetMapper implements FieldSetMapper<BizCanvas> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public BizCanvas mapFieldSet(FieldSet fieldSet) throws BindException {

		System.out.println("......................");
		System.out.println(fieldSet.getValues());

		BizCanvas canvas = new BizCanvas();
//		canvas.setBizCode("11");
        canvas.setFilename(fieldSet.readString(0));
		return canvas;
		
	}

}