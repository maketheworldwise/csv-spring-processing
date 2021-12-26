package com.example.csvspringprocessing.application;

import com.example.csvspringprocessing.processor.CustomCsvProcessor;
import com.example.csvspringprocessing.processor.OpenCsvProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class CsvProcessorServiceImpl implements CsvProcessorService {

    private final CustomCsvProcessor customCsvProcessor;
    private final OpenCsvProcessor openCsvProcessor;

    @Override
    public void customProcessor(MultipartFile file) {
        customCsvProcessor.readAndWrite(file);
    }

    @Override
    public void openCsvProcessorTest() {
        openCsvProcessor.readTest();
        openCsvProcessor.writeTest();
    }

    @Override
    public void openCsvProcessor(MultipartFile file) {
        openCsvProcessor.readAndWrite(file);
    }
}
