package com.ktdsuniversity.edu.file.dao;

import com.ktdsuniversity.edu.file.vo.FileVO;
import com.ktdsuniversity.edu.file.vo.RequestDownloadVO;

public interface FileDao {

	public int insertFile(FileVO uploadResult);

	public int updateDownloadCount(RequestDownloadVO requestDownloadVO);

	public FileVO selectFileVO(RequestDownloadVO requestDownloadVO);

}