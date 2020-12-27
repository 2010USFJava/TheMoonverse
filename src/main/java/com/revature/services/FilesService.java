package com.revature.services;


import java.io.File;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.S3Object;

public class FilesService {
	
	public FilesService() {
		super();
	}

	public void Upload(File file, String name) {
		
		String clientRegion = "us-east-2";
        String bucketName = "moonv";
        String objectKey = name;
        
        String accesskey = "AKIAVJ63A6B5MSZHYKEI";
        String secretkey = "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";
        
        BasicAWSCredentials credentials = new BasicAWSCredentials(accesskey, secretkey);

       

        try {
        	  AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                      .withCredentials(new AWSStaticCredentialsProvider(credentials))
                      .withRegion(clientRegion)
                      .build();  

            // Set the pre-signed URL to expire after one hour.
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 1000 * 60 * 60;
            expiration.setTime(expTimeMillis);

            // Generate the pre-signed URL.
            System.out.println("Generating pre-signed URL.");
            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
                    .withMethod(HttpMethod.PUT)
                    .withExpiration(expiration);
            URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
            
            System.out.println("Test: "+ url.toString());

            // Create the connection and use it to upload the new object using the pre-signed URL.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            //This next line writes the string as an object into the bucket
            out.write(file);
            out.close();

            // Check the HTTP response code. To complete the upload and make the object available, 
            // you must interact with the connection object in some way.
            connection.getResponseCode();
            System.out.println("HTTP response code: " + connection.getResponseCode());

            // Check to make sure that the object was uploaded successfully.
            S3Object object = s3Client.getObject(bucketName, objectKey);
            System.out.println("Object " + object.getKey() + " created in bucket " + object.getBucketName());
        } catch (AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client  
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }
	
	
}
