package com.catdog.times.route.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadLogic {
	
	
	public String uploadFiles(MultipartFile multipartFile, String path) throws IllegalStateException, IOException {
		String filename ="";
		if(!multipartFile.isEmpty()) {
			String originalFilename = multipartFile.getOriginalFilename();
			String storeFilename = createStoreFilename(originalFilename);
			multipartFile.transferTo(new File(path+File.separator+storeFilename));
			filename = storeFilename;
		}
		
		return filename;
	}
	
	
	private String createStoreFilename(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(pos+1);
		String uuid = UUID.randomUUID().toString();
		return uuid+"."+ext;
	}
	
	
	
	
	
}
