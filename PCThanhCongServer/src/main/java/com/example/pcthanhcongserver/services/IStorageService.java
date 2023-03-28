package com.example.pcthanhcongserver.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
    void init();

    String store(String dir, MultipartFile file, String fileName);
    Resource loadAsResource(String filename);
    void deleteFileByPrefix(String prefix, String path);
}
