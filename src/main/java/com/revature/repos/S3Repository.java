package com.revature.repos;


import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface S3Repository {
	
	public void uploadFile(String keyName, MultipartFile file);
	

}
