package actions.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import actions.service.S3Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class S3FileController {
	private final S3Service s3Service;
	
	@PostMapping(value = "/api/s3/files")
	public void uploadS3File(@RequestPart("file") MultipartFile file) {
		try {
			s3Service.uploadS3File(file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@GetMapping(value = "/api/s3/files/{fileNo}")
	public ResponseEntity<Resource> downloadS3File(@PathVariable("fileNo") long fileNo) throws Exception {
		return s3Service.downloadS3File(fileNo);
	}
	
	@DeleteMapping(value = "/api/s3/files/{fileNo}")
	public void deleteS3file(@PathVariable("fileNo") long fileNo) {
		// 파일이 존재하는지 db에서 확인 - 직접 구현할 것.
		// s3에서 파일 삭제
		s3Service.deleteS3file(fileNo);
		// db에서 기록 삭제 - 직접 구현할 것.
	}
}
