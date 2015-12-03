/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.task.module.sample;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.annotation.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Executes a batch job that logs a timestamp
 *
 * @author Glenn Renfro.
 */
@Configuration
@EnableConfigurationProperties({ SampleTaskProperties.class })
@EnableTask
public class SampleTaskConfiguration {
	@Autowired
	SampleTaskProperties config;

//	@Autowired
//	String dataSource;

	@Bean
	public TimestampLogger getTimeStampLogger() {
		return new TimestampLogger(config.getFormat());
	}

	@Bean
	public SampleB sampleB(){
//		System.out.println("HELLO WORLD THIS WAS ME!  " + dataSource);
		SampleB sampleB = new SampleB();
		sampleB.setMyVal("IT CHANGED");
		return sampleB;
	}
}