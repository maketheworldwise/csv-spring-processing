package com.example.csvspringprocessing.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;

@Getter
public class OpenCsvReadDto {

    @CsvBindByName(column = "title")
    private String id;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "content")
    private String content;

}
