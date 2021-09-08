package projectSolid.Service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import projectSolid.Entities.Flight;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SheetUtil {

    public void exportSheet(List<Flight> flights){
        Date dt = new Date();
        String date = dt.toString().substring(0,10) + " " + dt.toString().substring(24,28);

        String fileName = "Flights list " + date +".xls";
        String sheetName = "Flights";

        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet(sheetName);

        String[] header = new String[] {
                "ID",
                "CODE",
                "DEPARTURE AIRPORT",
                "ARRIVAL AIRPORT",
                "DEPARTURE DATE",
                "DEPARTURE TIME",
                "ARRIVAL DATE",
                "ARRIVAL TIME",
                "DELAY DEPARTURE DATE",
                "DELAY DEPARTURE TIME",
                "DELAY ARRIVAL DATE",
                "DELAY ARRIVAL TIME",
                "DELAY ARRIVAL AIRPORT",
                "AIRCRAFT",
                "FLIGHT STATUS"
        };
        CellStyle style = book.createCellStyle();
        Font font = book.createFont();
        font.setBold(true);
        style.setFont(font);
        
        for(int i = 0; i < flights.size(); i++){
            Row row = sheet.createRow(i++);
            int j = 0;
            for(Flight flight : flights){
                Cell cell1 = row.createCell(j++);
                cell1.setCellValue(flight.getId());

                Cell cell2 = row.createCell(j++);
                cell2.setCellValue(flight.getCode());

                Cell cell3 = row.createCell(j++);
                cell3.setCellValue(flight.getDepartureAirport().getName());

                Cell cell4 = row.createCell(j++);
                cell4.setCellValue(flight.getArrivalAirport().getName());

                Cell cell5 = row.createCell(j++);
                cell5.setCellValue(flight.getDepartureDate().toString());

                Cell cell6 = row.createCell(j++);
                cell6.setCellValue(flight.getDepartureTime().toString());

                Cell cell7 = row.createCell(j++);
                cell7.setCellValue(flight.getArrivalDate().toString());

                Cell cell8 = row.createCell(j++);
                cell8.setCellValue(flight.getArrivalTime().toString());

                Cell cell9 = row.createCell(j++);
                if(Objects.isNull(flight.getDelayDepartureDate())){
                    cell9.setCellValue("Null");
                }else{
                    cell9.setCellValue(flight.getDelayDepartureDate().toString());
                }

                Cell cell10 = row.createCell(j++);
                if(Objects.isNull(flight.getDelayDepartureTime())){
                    cell10.setCellValue("Null");
                }else{
                    cell10.setCellValue(flight.getDelayDepartureTime().toString());
                }

                Cell cell11 = row.createCell(j++);
                if(Objects.isNull(flight.getDelayArrivalDate())){
                    cell11.setCellValue("Null");
                }else{
                    cell11.setCellValue(flight.getDelayArrivalDate().toString());
                }

                Cell cell12 = row.createCell(j++);
                if(Objects.isNull(flight.getDelayArrivalTime())){
                    cell12.setCellValue("Null");
                }else{
                    cell12.setCellValue(flight.getDelayArrivalTime().toString());
                }

                Cell cell13 = row.createCell(j++);
                if(Objects.isNull(flight.getDelayArrivalAirport())){
                    cell13.setCellValue("Null");
                }else{
                    cell13.setCellValue(flight.getDelayArrivalAirport().getName());
                }

                Cell cell14 = row.createCell(j++);
                cell14.setCellValue(flight.getAircraft().getModel());

                Cell cell15 = row.createCell(j++);
                cell15.setCellValue(flight.getFlightStatus().getName());
            }
        }

        try{
            FileOutputStream out = new FileOutputStream("C:/Users/wltrs/IdeaProjects/kodigoFlightManager/src/main/resources/" + fileName);
            book.write(out);
            out.close();
            System.out.println("File created successful\n");
        }catch (Exception e){
            System.out.println("Error creating file\n");
            e.printStackTrace();
        }
    }
}
