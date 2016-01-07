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

import org.springframework.cloud.task.configuration.TaskConfigurer;
import org.springframework.cloud.task.repository.TaskExplorer;
import org.springframework.cloud.task.repository.TaskRepository;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by glennrenfro on 11/19/15.
 */
//@Component
public class MyConfigurer  implements TaskConfigurer {

	public MyConfigurer(){
	}

	public TaskRepository getTaskRepository() {
		return new MyTaskRepository();
	}

	@Override
	public PlatformTransactionManager getTransactionManager() {
		return null;
	}

	@Override
	public TaskExplorer getTaskExplorer() {
		return null;
	}

}
