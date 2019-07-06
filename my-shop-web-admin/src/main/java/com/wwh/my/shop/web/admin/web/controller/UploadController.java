package com.wwh.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 * <p>Title: UploadController</p>
 * <p>Description: </p>
 *
 * @author William
 * @version 1.0.0
 * @date 2019/6/22 14:41
 */
@Controller
public class UploadController {

    private static final String UPLOAD_PATH = "/static/upload/";

    /**
     * 文件上传
     * @param dropzFile Dropzone 上传文件
     * @param editorFile wangEditor 上传文件
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropzFile, MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        MultipartFile myFile = dropzFile == null ? editorFile : dropzFile;

        // 获取上传的原始文件名
        String fileName = myFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // 判断并创建上传用的文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        // 重新设置文件名为 UUID，以确保唯一
        file = new File(filePath, UUID.randomUUID() + fileSuffix);

        try {
            // 写入文件
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Dropzone 图片返回格式
        if (dropzFile != null) {
            // 返回 JSON 数据，这里只带入了文件名
            result.put("fileName", UPLOAD_PATH + file.getName());
        }
        // wangEditor 图片返回格式
        else {
            /**
             * 获取服务端路径
             * scheme: 服务器提供的协议 http/https
             * serverName: 服务器名称 localhost/ip/domain
             * serverPort: 服务器端口
             * contextPath: 项目地址
             */
            String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);

            // 返回给 wangEditor 的数据格式
            result.put("errno", 0);
            result.put("data", new String[]{serverPath + file.getName()});
        }

        return result;
    }
}
