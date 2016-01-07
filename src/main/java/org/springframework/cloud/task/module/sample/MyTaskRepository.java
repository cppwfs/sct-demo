/*
 *
 *  * Copyright 2015 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.springframework.cloud.task.module.sample;

import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.cloud.task.repository.TaskRepository;

/**
 * Created by glennrenfro on 11/19/15.
 */
//@Component
public class MyTaskRepository implements TaskRepository {

	@Override
	public void update(TaskExecution taskExecution) {
		System.out.println("LOCAL UPDATE: "+taskExecution.getTaskName());
	}

	@Override
	public void createTaskExecution(TaskExecution taskExecution) {
		System.out.println("LOCAL CREATE: "+taskExecution.getTaskName());
	}

//	@Override
	public long getNextExecutionId() {
		return 0;
	}

}
