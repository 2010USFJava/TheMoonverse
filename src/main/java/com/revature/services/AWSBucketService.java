package com.revature.services;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.revature.repos.S3Repository;

@Service
public class AWSBucketService implements S3Repository {
	
	@Autowired
	private AmazonS3 s3Client;
	
	private String bucketName = "moonv";
	
	private String endpoint;
	
	private String objectKey;
	

	@Override
	public void uploadFile(String keyName, MultipartFile file) {
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(file.getSize());
		try {
			s3Client.putObject(bucketName, keyName, file.getInputStream(), metadata);
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		} catch (SdkClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endpoint = "https://moonv.s3.us-east-2.amazonaws.com" + "/" + keyName;
		objectKey = keyName;
		System.out.println("Endpoint in s3service: " + endpoint);
		System.out.println("objectkey in s3service: " + objectKey);
		
	}
	
	

}
