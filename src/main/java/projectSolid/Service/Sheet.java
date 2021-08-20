package projectSolid.Service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import projectSolid.Entities.Country;
import projectSolid.Implementation.CountryServices;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Sheet {

    CountryServices countryServices = new CountryServices();

    SheetsServiceUtil s = new SheetsServiceUtil();
    Date date = new Date();

    public void createSheet() throws IOException, GeneralSecurityException {
        Sheets sheetsService = s.getSheetsService();

        Spreadsheet spreadsheet = new Spreadsheet().setProperties(
                new SpreadsheetProperties().setTitle("Flights " + date.toString()));

        Spreadsheet resultCreate = sheetsService.spreadsheets().create(spreadsheet).execute();

        String spreadsheetId = resultCreate.getSpreadsheetId();

        List<Country> list = countryServices.setElements();
        List<ValueRange> data = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            data.add(new ValueRange().setRange("B"+(i+1)).setValues(List.of(
                    Arrays.asList(list.get(i).getId(), list.get(i).getCode(), list.get(i).getName())
            )));
        }

        BatchUpdateValuesRequest body = new BatchUpdateValuesRequest()
                .setValueInputOption("USER_ENTERED")
                .setData(data);

        BatchUpdateValuesResponse result = sheetsService.spreadsheets().values()
                .batchUpdate(spreadsheetId, body)
                .execute();

        if (!(resultCreate.getSpreadsheetId()).isEmpty()) throw new AssertionError();
    }
}
