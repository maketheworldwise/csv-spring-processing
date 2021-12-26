package com.example.csvspringprocessing.application;

import org.springframework.web.multipart.MultipartFile;

public interface CsvProcessorService {
    void customProcessor(MultipartFile file);
    void openCsvProcessorTest();
    void openCsvProcessor(MultipartFile file);
}
