package com.atguigu.gulimall.thirdparty.config;

import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author lowo
 * @Email
 * @Date 2022/4/21
 * @Description atguigu_mall
 */

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "qiniu")
public class QiniuConfig {

	private String accessKey;

	private String secretKey;

	private String bucket;

	private String path;

	private Long expireSeconds;

	/**
	 * 华南机房
	 */
	@Bean
	public com.qiniu.storage.Configuration qnConfig() {
		return new com.qiniu.storage.Configuration(Region.huanan());
	}

	/**
	 * 构建一个七牛上传工具实例
	 */
	@Bean
	public UploadManager uploadManager() {
		return new UploadManager(qnConfig());
	}

	/**
	 * 认证信息实例
	 *
	 * @return
	 */
	@Bean
	public Auth auth() {
		return Auth.create(accessKey, secretKey);
	}

	/**
	 * 构建并返回upToken给前台进行上传
	 */
	@Bean
	public String upToken() {
		return auth().uploadToken(bucket);
	}

	/**
	 * 构建七牛空间管理实例
	 */
	@Bean
	public BucketManager bucketManager() {
		return new BucketManager(auth(), qnConfig());
	}
}

