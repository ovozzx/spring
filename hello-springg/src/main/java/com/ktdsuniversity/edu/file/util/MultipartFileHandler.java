package com.ktdsuniversity.edu.file.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.file.vo.FileVO;

/**
 * service, controller 등 역할이 아닌데 bean에 필요하면 @Component 달면 됨
 * Bean Container에 담긴 객체는
 * yml의 설정을 참조 받을 수 있다 == yml의 설정을 읽어올 수 있다.
 */
@Component // @Component => 전부 bean 컨테이너에 적재함. service, controller 등도 여기에 포함 (상속받은 거)
public class MultipartFileHandler {
	
	@Value("${app.multipart.whitelist}") // SpEL. application.yml의 설정을 읽어오는 Annotation (:로 구분)
	private List<String> whitelist; // yml에서 ,로 구분된 데이터는 List로 받아올 수 있음

	@Value("${app.multipart.base-dir.windows}")
	private String windowsBaseDirectory;

	@Value("${app.multipart.base-dir.macos}")
	private String macBaseDirectory;
	
	@Value("${app.multipart.obfuscation.enable}")
	private boolean obfuscationEnable;
	
	@Value("${app.multipart.obfuscation.hide-ext.enable}")
	private boolean hideExtEnable;
	
	public FileVO upload(MultipartFile file) {
		// os별 분기처리
		/**
		 * Windows: Windows 10
		 * Macos: Mac OS X
		 */
		String os = System.getProperty("os.name");
		/**
		 * Windows: C:\Users\User
		 * Macos: /Users/...
		 */
		String userHome = System.getProperty("user.home");
		
		String filename = file.getOriginalFilename();
		if(this.obfuscationEnable) {
			filename = this.makeObfuscationName(file.getOriginalFilename());
			
		}
		
		// 파일 저장.
		// OS별 파일의 경로를 지정
		String directory = this.windowsBaseDirectory;
		if(os.toLowerCase().startsWith("mac")) {
			directory = userHome + this.macBaseDirectory;
		}
		
		// 업로드한 파일이 저장될 경로 
		File storePath = new File(directory, filename);
		
		if(!storePath.getParentFile().exists()) {
			storePath.getParentFile().mkdirs();
		}
		
		// 업로드한 파일을 저장.
		try {
			file.transferTo(storePath);
		} catch (IllegalStateException | IOException e) {
			// 예외 케이스 : 디스크 부족, 허용되지 않은 경로에 접근 ....
			return null; // 저장 할 수 없다!
		}
		// 업로드한 결과를 반환 
		FileVO uploadResult = new FileVO();
		uploadResult.setFileSize(storePath.length());
		uploadResult.setFileDisplayName(file.getOriginalFilename());
		uploadResult.setFileName(storePath.getName());
		uploadResult.setFilePath(storePath.getAbsolutePath());
		// TODO MimeType 추출 후 셋팅해야 함. + 첨부파일 미업로드하면 오류나는 거 해결 필요
		uploadResult.setFileType("파일의 MimeType을 작성");
		
	
		return uploadResult;
	}
	
	private String makeObfuscationName(String filename) { // 난독화
		
		// 확장자 분리
		String ext = filename.substring(filename.lastIndexOf("."));
		
		// 파일명 난독화를 위해 난수 생성
		String newFilename = UUID.randomUUID().toString(); 
		
		// 확장자 분리 여부에 따라 이름에 확장자 조합 또는 폐기
		if(!this.hideExtEnable) {
			newFilename += ext;
		}
		
		// 완성된 파일의 이름을 반환
		return newFilename;
	}
	
	// 디스크에 저장되는지까지만 -> db 저장 나중
	private boolean availableStore(File file) { // java. import. 업로드 가능한 파일인지 확인
		return false;
	}
	
}
