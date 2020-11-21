package com.mango.datasource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据源
 */
@Component
@Data
@ConfigurationProperties(prefix = "mango.backup.datasource")  
public class BackupDataSourceProperties {
	
	private String host;
	private String userName;
	private String password;
	private String database;

}  