package com.revature.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.services.AWSBucketService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials ="true")
@RestController
@RequestMapping("/file")
public class FilesController {
	
	@Autowired
	private AWSBucketService s3service;
	
	private String endpoint;
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String keyName = file.getOriginalFilename();
		s3service.uploadFile(keyName, file);
		endpoint = "https://moonv.s3.us-east-2.amazonaws.com" + "/" + keyName;
		System.out.println("ENDPOINT: " + endpoint);
		return endpoint;
	}

}
