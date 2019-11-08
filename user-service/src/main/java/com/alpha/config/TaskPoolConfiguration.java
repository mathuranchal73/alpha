package com.alpha.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class TaskPoolConfiguration implements AsyncConfigurer {
	
	private static final int MAX_POOL_SIZE = 1;
	private static final int CORE_POOL_SIZE = 1;
	private static final int QUEUE_CAPACITY = 1;
	
	@Override
	@Bean(name = "asyncExecutor")
	public Executor getAsyncExecutor() {
		
		ThreadPoolTaskExecutor threadPoolTaskExecutor= new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
		threadPoolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
		threadPoolTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		threadPoolTaskExecutor.setThreadNamePrefix("Custom-Executor");
		threadPoolTaskExecutor.initialize();
		
		return threadPoolTaskExecutor;
		
	}

}
