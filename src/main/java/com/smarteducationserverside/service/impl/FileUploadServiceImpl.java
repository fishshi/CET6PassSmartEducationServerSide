package com.smarteducationserverside.service.impl;

import java.io.File;
import java.util.Collections;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.smarteducationserverside.service.FileUploadService;

import jakarta.annotation.Resource;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final String authorization = "";

    @Resource
    private RestTemplate restTemplate;

    @SuppressWarnings("null")
    @Override
    public String uploadAvatar(String username) {
        File file = new File("D:\\" + username + ".jpg");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Authorization", authorization);

        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("file", new FileSystemResource(file));
        // form.add("album_id", 174);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, headers);
        String url = "https://picui.cn/api/v1/upload";

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            String links = response.getBody().split("\"links\":")[1];
            System.out.println(links);
            String avatarUrl = links.split(",")[0];
            avatarUrl = avatarUrl.substring(8, avatarUrl.length() - 1);
            return avatarUrl;
        } catch (HttpClientErrorException e) {
            return null;
        }
    }

}