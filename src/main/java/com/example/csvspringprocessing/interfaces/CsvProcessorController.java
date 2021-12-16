package com.example.csvspringprocessing.interfaces;

import com.example.csvspringprocessing.processor.CustomCsvProcessor;
import com.example.csvspringprocessing.processor.OpenCsvProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class CsvProcessorController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    // 직접 구현
    @PostMapping("/custom-csv/processing")
    public ResponseEntity<?> csvCustomProcessing(@RequestParam(value = "file") MultipartFile file) {
        CustomCsvProcessor customCsvProcessor = new CustomCsvProcessor();
        return new ResponseEntity<>(
                "성공적으로 변환에 성공하였습니다.",
                HttpStatus.OK);
    }

    // OpenCsv 라이브러리 테스트
    @PostMapping("/open-csv/processing/test")
    public ResponseEntity<?> openCsvCustomProcessingTest() {
        OpenCsvProcessor openCsvProcessor = new OpenCsvProcessor();
        openCsvProcessor.readTest();
        openCsvProcessor.writeTest();
        return new ResponseEntity<>(
                "성공적으로 테스트하였습니다.",
                HttpStatus.OK);
    }

    // OpenCsv 라이브러리
    @PostMapping("/open-csv/processing")
    public ResponseEntity<?> openCsvCustomProcessing(@RequestParam(value = "file") MultipartFile file) {
        OpenCsvProcessor openCsvProcessor = new OpenCsvProcessor();
        openCsvProcessor.readAndWrite(file);
        return new ResponseEntity<>(
                "성공적으로 변환에 성공하였습니다.",
                HttpStatus.OK);
    }
}
