package org.example;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;

public class CsvStringToJson {
    public static void main(String[] args) {
        Converter();
    }

    public static void Converter() {
        String CSVin = "";
        JSONArray jsonArray = new JSONArray();
        String[] line;

        try(CSVReader r = new CSVReader(new StringReader(CSVin))) {
            String[] headers = r.readNext();

            while((line = r.readNext()) != null) {
                String[] values = line;
                JSONObject obj = new JSONObject();
                for (int i = 0; i < values.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }
            System.out.println(jsonArray.toString(1));
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
