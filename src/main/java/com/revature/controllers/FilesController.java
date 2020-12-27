package revature.com;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Controller
public class FilesController {
 
 @PostMapping("/upload")
 public String singleFileUpload(@RequestParam("file") File file, RedirectAttributes redirectAttributes) {

	 String clientRegion = "us-east-2";
     String bucketName = "moonv";
     String objectKey = file.getName();
     
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
         String test = url.toString();
         
         String dataUrl = test.substring(0, test.indexOf('?'));
         System.out.println(dataUrl); 

         // Create the connection and use it to upload the new object using the pre-signed URL.
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         connection.setDoOutput(true);
         connection.setRequestMethod("PUT");
         
         connection.setDoOutput(true);
     	 connection.connect();

     	s3Client.putObject(new PutObjectRequest(bucketName, objectKey, file));
        
     	String s3url = "https://moonv.s3.us-east-2.amazonaws.com/"+objectKey;
         

         
      

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
 
 @GetMapping("/uploadStatus")
 public String uploadStatus(ModelMap m) {
  return "Homepage";
 }
 
 @GetMapping("/upload")  
 public String displayHomePageForAlarm() {
  return "Homepage";
 }

}