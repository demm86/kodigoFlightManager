package projectSolid.Service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Sheet {

    SheetsServiceUtil s = new SheetsServiceUtil();

    public void test() throws IOException, GeneralSecurityException {
        Sheets sheetsService = s.getSheetsService();

        Spreadsheet spreadsheet = new Spreadsheet().setProperties(
                new SpreadsheetProperties().setTitle("Flights"));

        Spreadsheet result = sheetsService.spreadsheets().create(spreadsheet).execute();

        if (!(result.getSpreadsheetId()).isEmpty()) throw new AssertionError();
    }
}
