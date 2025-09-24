package com.ktdsuniversity.edu.file.web;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.edu.file.service.FileService;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;
    
    @GetMapping("/test")
    public String test() {
    	
    	Map<String, String> envMap = System.getenv();
    	Properties props = System.getProperties(); // 더 세세한 정보 
    	System.out.println(envMap); // 시스템 환경설정 정보를 가져옴
    	System.out.println(props);
    	return "dd";
    	
    	// os.name=Windows 10, user.home=C:\Users\User
    }

}