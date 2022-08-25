package com.mphasis.web.SpringBootWebDemo.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.web.SpringBootWebDemo.mvc.HomeController;

@RestController
public class FIleMultiPartUpload {

	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String consumeFileData(@RequestParam("fileToUpload") MultipartFile file) {
		String result = "File was uploaded successfully";

		System.out.println(file.getOriginalFilename());
		try {
			File convertFile = new File(file.getOriginalFilename());
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();

		} catch (IOException iex) {
			result = "Error " + iex.getMessage();
		}
		
			return result;
		
	}


	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile() throws IOException  {
		String fileName = "Screenshot 2022-02-20 at 10.05.21 PM.png";
			File file = new File(fileName);

		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object>
		responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
				MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
}
