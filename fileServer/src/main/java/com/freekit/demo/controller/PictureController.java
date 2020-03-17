package com.freekit.demo.controller;

import com.freekit.common.entity.ResultMap;
import com.freekit.common.exception.BusinessException;
import com.freekit.common.exception.ExceptionStatus;
import com.freekit.demo.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(name = "/icon")
@Slf4j
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "picture/upload",method = {RequestMethod.POST})
    public ResultMap uploadFile(@RequestParam("fileName") MultipartFile multipartFile) throws IOException {
        String s = pictureService.pictureUpload(multipartFile);
        return ResultMap.ok(s);
    }



    @RequestMapping(value = "picture/download",method = {RequestMethod.GET})
    public ResultMap  downloadFile(String url, HttpServletResponse response, HttpServletRequest request)  {
        String s = pictureService.pictureDownload(url, response, request);
        return ResultMap.ok(s);
    }
}
