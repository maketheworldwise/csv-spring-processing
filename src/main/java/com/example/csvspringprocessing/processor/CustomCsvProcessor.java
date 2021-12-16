package com.example.csvspringprocessing.processor;

import com.example.csvspringprocessing.config.MyProperties;
import com.example.csvspringprocessing.dto.CustomCsvDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomCsvProcessor {

    private final MyProperties myProperties = new MyProperties();

    private List<CustomCsvDto> read(MultipartFile file) {
        try {
            List<CustomCsvDto> csvDataList = new ArrayList<>();
            File csv = new File(file.getOriginalFilename());
            file.transferTo(csv);

            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line = "";

            while((line = br.readLine()) != null) {
                csvDataList.add(CustomCsvDto.csvToDto(line));
            }

            br.close();

            return csvDataList;

        } catch (FileNotFoundException e) {
            log.info("파일을 찾을 수 없음");
        } catch (Exception e) {
            log.info("파일 읽기 실패");
        }
        return null;
    }

    private void write(List<CustomCsvDto> csvDataList) {

        try {
            File output = new File(myProperties.getPath().getDownload());
            BufferedWriter bw = new BufferedWriter(new FileWriter(output, false));

            boolean isHeader = true;
            for(CustomCsvDto data : csvDataList) {
                StringBuilder sb = new StringBuilder();

                // 헤더를 생략하고 데이터만 저장
                if(isHeader) {
                    isHeader = false;
                    continue;
                }

                sb.append(data.getId()).append(",");
                sb.append(data.getName()).append(",");
                sb.append(data.getTitle()).append(",");
                sb.append(data.getContent()).append(",");
                sb.append(myProperties.getUri().getS3()).append(data.getName()).append(",");
                sb.append(myProperties.getUri().getCdn()).append(data.getName());

                bw.write(sb.toString());
                bw.newLine();
            }

            bw.flush();
            bw.close();

        }  catch (FileNotFoundException e) {
            log.info("파일을 찾을 수 없음");
        } catch (Exception e) {
            log.info("파일 쓰기 실패");
        }
    }

    public void readAndWrite(MultipartFile file) {
        write(read(file));
    }
}