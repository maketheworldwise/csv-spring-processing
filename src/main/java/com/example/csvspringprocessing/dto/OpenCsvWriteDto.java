package com.example.csvspringprocessing.dto;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;

@Getter
public class OpenCsvWriteDto {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String title;

    @CsvBindByPosition(position = 3)
    private String content;

    @CsvBindByPosition(position = 4)
    private String s3ImageUri;

    @CsvBindByPosition(position = 5)
    private String cdnImageUri;

    public OpenCsvWriteDto(OpenCsvReadDto openCsvReadDto, String s3Uri, String cdnUri) {
        this.id = openCsvReadDto.getId();
        this.name = openCsvReadDto.getName();
        this.title = openCsvReadDto.getTitle();
        this.content = openCsvReadDto.getContent();
        this.s3ImageUri = createUri(openCsvReadDto.getName(), s3Uri);
        this.cdnImageUri = createUri(openCsvReadDto.getName(), cdnUri);
    }

    private String createUri(String name, String uri) {
        StringBuilder sb = new StringBuilder();
        sb.append(uri).append(name).append(".jpg");
        return sb.toString();
    }
}
