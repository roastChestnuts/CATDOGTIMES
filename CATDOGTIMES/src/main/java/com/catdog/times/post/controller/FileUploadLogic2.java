package com.catdog.times.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadLogic2 {
	// 파일을 업로드한 후 이 정보를 BoardFileDTO로 변환해서 리턴
	public String uploadFile(MultipartFile multipartFile, String path)
			throws IllegalStateException, IOException {	
			String filename = "";
			if (!multipartFile.isEmpty()) {
				// 클라이언트가 업로드한 파일명
				String originFilename = multipartFile.getOriginalFilename();
				// 서버에서 식별할 수 있도록 파일명을 변경
				String storeFilename = createStoreFilename(originFilename);

				System.out.println(originFilename);
				// File객체를 실제 경로에 저장
				multipartFile.transferTo(new File(path + File.separator + storeFilename));
				filename = storeFilename;
			}
			return filename;
		}		

	// UUID - 32자리의 16진수로 표기(중복확률 매우 희박)
	private String createStoreFilename(String originFilename) {
		int pos = originFilename.lastIndexOf(".");
		String ext = originFilename.substring(pos + 1);
		String uuid = UUID.randomUUID().toString();
		return uuid + "." + ext;
	}
}