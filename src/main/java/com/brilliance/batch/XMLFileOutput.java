package com.brilliance.batch;

import com.brilliance.batch.model.Report;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*@Configuration
public class XMLFileOutput extends StaxEventItemWriter {

    @Bean
    public StaxEventItemWriter<Report> StaxEventItemWriter() throws Exception {
        System.out.println("---------------------------------------------------");
        XStreamMarshaller marshaller = new XStreamMarshaller();
        @SuppressWarnings("rawtypes")
        Map<String, Class> aliases = new HashMap<String, Class>();
        aliases.put("Report", Report.class);
        marshaller.setAliases(aliases);

        StaxEventItemWriter<Report> writer = new StaxEventItemWriter<Report>();
        writer.setRootTagName("Reports");
        writer.setMarshaller(marshaller);
        File path = new File("D:" + File.separator + "Report.xml").getAbsoluteFile();
        System.out.println("file is create in :" + path);
        writer.setResource(new FileSystemResource(path));
        writer.afterPropertiesSet();
        return writer;

    }
}*/
