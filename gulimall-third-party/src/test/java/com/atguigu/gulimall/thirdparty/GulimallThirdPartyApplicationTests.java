package com.atguigu.gulimall.thirdparty;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallThirdPartyApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testUpload() {

		//构造一个带指定 Region 对象的配置类
		Configuration cfg = new Configuration(Region.huanan());
		//...其他参数参考类注释

		UploadManager uploadManager = new UploadManager(cfg);
		//...生成上传凭证，然后准备上传
		String accessKey = "r7CokD201FMGErGOGyCBcmo1qZYcIJwsWLBPgKQP";
		String secretKey = "k8Fd0G2mdFj440DDBm-PCqZurFdoHellJYXuZu_4";
		String bucket = "atguigu-mall";
		//如果是Windows情况下，格式是 D:\\qiniu\\test.png
		String localFilePath = "D:\\LOWO\\JavaLearn\\OwnProject\\谷粒商城\\分布式基础\\pics\\0d40c24b264aa511.jpg";
		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = null;

		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);

		try {
			Response response = uploadManager.put(localFilePath, key, upToken);
			//解析上传成功的结果
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			System.out.println(putRet.key);
			System.out.println(putRet.hash);
		} catch (QiniuException ex) {
			Response r = ex.response;
			System.err.println(r.toString());
			try {
				System.err.println(r.bodyString());
			} catch (QiniuException ex2) {
				//ignore
			}
		}

	}

}
