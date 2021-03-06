/*
 * Copyright 2015 the original author or authors.
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

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Glenn Renfro
 */
@ConfigurationProperties
public class SampleTaskProperties {
	/**
	 * The timestamp format, "yyyy-MM-dd HH:mm:ss.SSS" by default.
	 */
	private String format = "yyyy-MM-dd HH:mm:ss.SSS";

	@NotBlank(message = "format must not be empty nor null")
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
