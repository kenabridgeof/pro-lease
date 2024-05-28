package com.atguigu;

import io.minio.*;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: App
 * Package: com.atguigu
 */
public class App {

	public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

		try {
		//构造MinIO Client
		MinioClient minioClient = MinioClient.builder()
				.endpoint("http://192.168.88.228:9000")
				.credentials("minioadmin", "minioadmin")
				.build();

		//创建hello-minio桶
		boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket("hello-minio").build());

		if (!bucketExists) {
			//创建hello-minio桶
			minioClient.makeBucket(MakeBucketArgs.builder().bucket("hello-minio").build());
			//设置hello-minio桶的访问权限
			String policy = """
                        {
                          "Statement" : [ {
                            "Action" : "s3:GetObject",
                            "Effect" : "Allow",
                            "Principal" : "*",
                            "Resource" : "arn:aws:s3:::hello-minio/*"
                          } ],
                          "Version" : "2012-10-17"
                        }""";
			minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket("hello-minio").config(policy).build());
		} else {
			System.out.println("Bucket 'hello-minio' already exists.");
		}



		//上传图片
			minioClient.uploadObject(UploadObjectArgs.builder()
					.bucket("hello-minio")
					.object("宿命之剑.jpg")
					.filename("D:\\Download\\宿命之剑.jpg")
					.build());

		System.out.println("上传成功");

		} catch (Exception e) {
			System.out.println("Error occurred: " + e);
		}




	}
}
