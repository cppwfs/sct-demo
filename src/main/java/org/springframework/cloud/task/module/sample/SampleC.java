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

import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.cloud.task.repository.TaskExplorer;
import org.springframework.cloud.task.repository.dao.JdbcTaskExecutionDao;
import org.springframework.cloud.task.repository.support.SimpleTaskExplorer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 * Represents a component that is not marked as a task.  It should run but not be picked
 * up by the aspect.
 */
@Component
public class SampleC implements CommandLineRunner {

	@Autowired
	TimestampLogger mylog;

	@Autowired
	DataSource dataSource;

	@Override
	public void run(String... args) {
		mylog.logTimestamp();
		TaskExplorer taskExplorer = new SimpleTaskExplorer(new JdbcTaskExecutionDao(dataSource));
		Page<TaskExecution> page = taskExplorer.findAll(new PageRequest(0,2));
		System.out.println(page.getTotalElements());
		Iterator<TaskExecution> iter = page.iterator();
		while (iter.hasNext()){
			TaskExecution te = iter.next();
			System.out.println(te);
		}
	}

}
