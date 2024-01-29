package com.atguigu.gulimall.thirdparty.controller;

import com.atguigu.common.utils.R;
import com.google.gson.Gson;
import com.atguigu.gulimall.thirdparty.config.QiniuConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @Author lowo
 * @Email
 * @Date 2022/4/21
 * @Description atguigu_mall
 */

@Controller
public class QiniuController {

	@Autowired
	QiniuConfig qiniuConfig;

	@RequestMapping("/oss/policy")
	@ResponseBody
	public R policy() {
		Auth auth = qiniuConfig.auth();
		String upToken = qiniuConfig.upToken();
		Map<String, String> respMap = new LinkedHashMap<>();
		respMap.put("upToken", upToken);
		return R.ok().put("data", respMap);
	}

//	@ResponseBody
//	public void test() {
//		Auth auth = qiniuConfig.auth();
//		String upToken = qiniuConfig.upToken();
//		UploadManager uploadManager = qiniuConfig.uploadManager();
//		try {
//			//如果是Windows情况下，格式是 D:\\qiniu\\test.png
//			String localFilePath = "D:\\LOWO\\JavaLearn\\OwnProject\\谷粒商城\\分布式基础\\pics\\0d40c24b264aa511.jpg";
//			//默认不指定key的情况下，以文件内容的hash值作为文件名
//			String key = null;
//			Response response = uploadManager.put(localFilePath, key, upToken);
//			//解析上传成功的结果
//			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//			System.out.println(putRet.key);
//			System.out.println(putRet.hash);
//		} catch (QiniuException ex) {
//			Response r = ex.response;
//			System.err.println(r.toString());
//			try {
//				System.err.println(r.bodyString());
//			} catch (QiniuException ex2) {
//				//ignore
//			}
//		}
//	}

}
