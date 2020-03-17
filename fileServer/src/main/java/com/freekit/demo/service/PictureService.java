package com.freekit.demo.service;

import com.freekit.common.exception.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PictureService {

    String  pictureUpload(MultipartFile multipartFile) throws BusinessException, IOException;

    String  pictureDownload(String url, HttpServletResponse response, HttpServletRequest request) throws BusinessException;

}
