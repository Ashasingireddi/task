package com.datashifting.reverse;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

import com.datashifting.model.EmployeDetails;





@Configuration
@EnableBatchProcessing
public class DbToCsvConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private DataSource dataSource;
	@Bean
	public JdbcCursorItemReader<EmployeDetails> reader()
	{
		 JdbcCursorItemReader<EmployeDetails> reader=new  JdbcCursorItemReader<EmployeDetails>();
		 reader.setDataSource(dataSource);
		 reader.setSql("select id,name,address,email,password from employe_details");
		 reader.setRowMapper(new RowMapper<EmployeDetails>() {
			
			@Override
			public EmployeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeDetails dbToCsvModel=new EmployeDetails();
				dbToCsvModel.setId(rs.getInt("id"));
				dbToCsvModel.setName(rs.getString("name"));
				dbToCsvModel.setAddress(rs.getString("address"));
				dbToCsvModel.setEmail(rs.getString("email"));
				dbToCsvModel.setPassword(rs.getString("password"));
				return dbToCsvModel;
			}
		});
		 return reader;
		 
		 
	}
	@Bean
	public FlatFileItemWriter<EmployeDetails> writer()
	{
		FlatFileItemWriter<EmployeDetails> writer=new  FlatFileItemWriter<EmployeDetails>();
		writer.setResource(new FileSystemResource("C://Users//sganta3//Documents/empdata.csv"));
		DelimitedLineAggregator<EmployeDetails> aggregator=new DelimitedLineAggregator<>();
		BeanWrapperFieldExtractor<EmployeDetails> fieldExtractor=new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(new String[] {"id","name","address","email","password"});
		aggregator.setFieldExtractor(fieldExtractor);
		writer.setLineAggregator(aggregator);
		return writer;
		
		 
	}
	@Bean
	public Step executeStep()
	{
		 return stepBuilderFactory.get("executeStep").<EmployeDetails,EmployeDetails>chunk(10).reader(reader()).writer(writer()).build();
		
	}
	@Bean
	public Job processJob()
	{
		return jobBuilderFactory.get("processJob").incrementer(new RunIdIncrementer()).flow(executeStep()).end().build();
	}
	

}
