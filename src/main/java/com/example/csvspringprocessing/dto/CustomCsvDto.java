package com.example.csvspringprocessing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomCsvDto {

    private String id;
    private String name;
    private String title;
    private String content;

    public static CustomCsvDto csvToDto(String line) {
        String[] csvData = line.split(",");
        return new CustomCsvDto(
                csvData[0], // id
                csvData[1], // name
                csvData[2], // title
                csvData[3]  // content
        );
    }
}
