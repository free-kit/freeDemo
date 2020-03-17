package com.freekit.demo.service.Impl;

import com.freekit.common.exception.BusinessException;
import com.freekit.common.exception.ExceptionStatus;
import com.freekit.demo.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class PictureServiceImpl implements PictureService {

    @Value("${fileupload.root-path}")
    private String url;

    @Value("${fileupload.download}")
    private String download;

    @Override
    public String pictureUpload(MultipartFile multipartFile) throws BusinessException, IOException {
        log.debug("==========================上传文件开始>>>>>>>>>>>>>>>>>>>");
        //上传的文件名称
        String originalFilename = multipartFile.getOriginalFilename();
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        String format = sd.format(date);
        if(StringUtils.isEmpty(originalFilename)){
            throw new BusinessException(ExceptionStatus.FILENAME_IS_EMPTY);
        }
        String fileName;
        String imageFile = null;
        File file = null;
        do{
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //取文件的后缀
            if(originalFilename.lastIndexOf(".") > 0){
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                fileName = uuid+suffix;
            }else{
                fileName = uuid;
            }
            String filePath = url + File.separator + format;
            imageFile = filePath  + File.separator + fileName;
            /*生成完成的保存文件的路径*/
            file = new File(imageFile);
            log.debug("=========================>>>>>>>>>>>>>>>>>>>>>>>>>>name{}",file.exists());
        }while (file.exists());
        //判断目标文件所在目录是否存在
        if (!file.getParentFile().exists()){//如果目标文件所在文件夹不存在，则创建父文件夹
            //判断父文件夹是否存在，如果存在则表示创建成功，否则失败
            if ( !file.getParentFile().mkdirs() ){
                throw new BusinessException(ExceptionStatus.CREATE_FILE_DEFEAT,"创建日期文件夹失败！");
            }
        }
        log.debug("下一个方法");
        boolean newFile = file.createNewFile();
        log.debug("=========================>>>>>>>>>>>>>>>>>>>>>>>>>>newFile{}",newFile);
        if(!newFile)
            throw new BusinessException(ExceptionStatus.CREATE_FILE_DEFEAT);
        this.saveFile(multipartFile.getInputStream(),file);
        return imageFile;
    }

    /**
     * 生成文件保存到服务器上
     * @param inputStream
     * @param file
     * @throws IOException
     */
    private void saveFile(InputStream inputStream, File file) throws IOException {
        /*生成文件*/
        FileUtils.touch(file);
        /*保存到服务器*/
        FileUtils.copyInputStreamToFile(inputStream,file);
    }


    @Override
    public String pictureDownload(String url, HttpServletResponse response, HttpServletRequest request) throws BusinessException {
        // path是指欲下载的文件的路径。
        File file = new File(url);
        // 取得文件名。
        String filename = file.getName();
        if(file.exists()){
            OutputStream out = null;
            FileInputStream in = null;
            try {
                // 1.读取要下载的内容
                in = new FileInputStream(file);
                // 2. 告诉浏览器下载的方式以及一些设置
                // 解决文件名乱码问题，获取浏览器类型，转换对应文件名编码格式，IE要求文件名必须是utf-8, firefo要求是iso-8859-1编码
                String agent = request.getHeader("user-agent");
                if (agent.contains("FireFox")) {
                    filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
                } else {
                    filename = URLEncoder.encode(filename, "UTF-8");
                }
                // 设置下载文件的mineType，告诉浏览器下载文件类型
                String mineType = request.getServletContext().getMimeType(filename);
                response.setContentType(mineType);
                // 设置一个响应头，无论是否被浏览器解析，都下载
                response.setHeader("Content-disposition", "attachment; filename=" + filename);
                // 将要下载的文件内容通过输出流写到浏览器
                out = response.getOutputStream();
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else
            throw new BusinessException(ExceptionStatus.CREATE_FILE_DEFEAT,"文件不存再");
        return "ok";
    }
}
