package com.example.csvspringprocessing.processor;

import com.example.csvspringprocessing.config.MyProperties;
import com.example.csvspringprocessing.dto.OpenCsvReadDto;
import com.example.csvspringprocessing.dto.OpenCsvWriteDto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class OpenCsvProcessor {

    private final MyProperties myProperties;

    // 읽기 테스트
    public void readTest() {
        try {
            File input = new File(myProperties.getPaths().getRead());
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(input))
                    .withSkipLines(1)
                    .build();

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                for(String s : nextLine) {
                    System.out.println(s);
                }
            }
            csvReader.close();

        } catch (CsvValidationException e) {
            log.info("유효하지 않은 파일");
        } catch (FileNotFoundException e) {
            log.info("파일을 찾을 수 없음");
        } catch (Exception e) {
            log.info("파일 읽기 실패");
        }
    }

    // 쓰기 테스트
    public void writeTest() {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(myProperties.getPaths().getWrite()));
            String[] entries = new String[]{"test1", "test2"};
            csvWriter.writeNext(entries);
            csvWriter.close();
        } catch (Exception e) {
            log.info("파일 쓰기 실패");
        }
    }

    private List<OpenCsvReadDto> read(MultipartFile file) {
        try {
            List<OpenCsvReadDto> csvDataList = new CsvToBeanBuilder<OpenCsvReadDto>(new InputStreamReader(file.getInputStream()))
                    .withType(OpenCsvReadDto.class)
                    .build()
                    .parse();

            csvDataList.forEach(System.out::println);
            return csvDataList;

        } catch (FileNotFoundException e) {
            log.info("파일을 찾을 수 없음");
        } catch (Exception e) {
            log.info("파일 읽기 실패");
        }
        return null;
    }

    private void write(List<OpenCsvReadDto> csvDataList) {
        try {
            FileWriter writer = new FileWriter(myProperties.getPaths().getDownload());
            StatefulBeanToCsv<OpenCsvWriteDto> beanToCsv = new StatefulBeanToCsvBuilder<OpenCsvWriteDto>(writer).build();
            beanToCsv.write(
                    csvDataList.stream()
                            .map(x -> new OpenCsvWriteDto(x, myProperties.getUris().getS3(), myProperties.getUris().getCdn()))
                            .collect(Collectors.toList()));
            writer.close();
        } catch (Exception e) {
            log.info("파일 쓰기 실패");
        }
    }

    public void readAndWrite(MultipartFile file) {
        write(read(file));
    }
}
