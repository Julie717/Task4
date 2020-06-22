package com.buyalskaya.array.parser;

import com.buyalskaya.array.exception.ProjectException;
import com.buyalskaya.array.validator.DataValidator;

public class DataParser {
    public static final String REGEX_DELIMITER = "\\s+";

    public String[] parseDataToArray(String data) throws ProjectException {
        if (data == null) {
            throw new ProjectException("These data is null");
        }
        String[] parseData = data.split(REGEX_DELIMITER);
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.validateData(parseData)) {
            throw new ProjectException("These data are incorrect");
        }
        return parseData;
    }

    public String[][] parseDataToMatrix(String[] data) throws ProjectException {
        if (data == null) {
            throw new ProjectException("These data is null");
        }
        String[][] parseData = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            parseData[i] = parseDataToArray(data[i]);
        }
        return parseData;
    }
}