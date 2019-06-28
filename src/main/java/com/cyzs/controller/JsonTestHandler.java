package com.cyzs.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author xiaoH
 * @create 2019-06-28-21:03
 */
@Controller
public class JsonTestHandler {

    @RequestMapping("/testJSONDownLoad")
    public ResponseEntity<byte[]> testJSONData(HttpSession session) throws IOException {
        byte[] data=null;
        InputStream inputStream = session.getServletContext().getResourceAsStream("/files/1.jpg");
        data=new byte[inputStream.available()];
        inputStream.read(data);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=1.jpg");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(data
                , httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/submitFile")
    public String submitFile(@RequestParam("desc") String desc
            , @RequestParam("file")MultipartFile multipartFile) throws IOException {
        System.out.println("desc=="+desc);
        File file = new File("d:/" + multipartFile.getOriginalFilename());
        //存入d：盘文件名为  abc.txt
        multipartFile.transferTo(file);
        //multipartFile.getOriginalFilename()   abc.txt
        System.out.println("名字"+multipartFile.getOriginalFilename());
        return "成功";
    }



}
