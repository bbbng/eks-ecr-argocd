package actions.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Setter
@ToString
@Entity
public class AttachmentFile {
	@CreatedDate
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attachment_file_no")
	private Long attachmentFileNo;
	
	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "attachment_file_name")
	private String attachmentFileName;
	
	@Column(name = "attachment_original_file_name")
	private String attachmentOriginalFileName;
	
	@Column(name = "attachment_file_size")
	private Long attachmentFileSize; 
	
	@Builder
	public AttachmentFile(long attachmentFileNo, String filePath, String attachmentFileName, 
			String attachmentOriginalFileName, Long attachmentFileSize) {
		this.attachmentFileNo = attachmentFileNo;
		this.filePath = filePath;
		this.attachmentFileName = attachmentFileName;
		this.attachmentOriginalFileName = attachmentOriginalFileName;
		this.attachmentFileSize = attachmentFileSize;
	}
}
