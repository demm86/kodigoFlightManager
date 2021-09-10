package projectSolid.Service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import projectSolid.Entities.Flight;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SheetUtil {

    String path = "C:/Users/wltrs/IdeaProjects/kodigoFlightManager/src/main/resources/";

    public void exportSheet(List<Flight> flights){
        Date dt = new Date();
        String date = dt.toString().substring(0,10) + " " + dt.toString().substring(24,28);

        String fileName = "Flights list " + date +".xls";
        String sheetName = "Flights";

        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet(sheetName);
        sheet.setColumnWidth(0, 1000);
        sheet.setColumnWidth(1, 2000);
        sheet.setColumnWidth(2, 8000);
        sheet.setColumnWidth(3, 8000);
        sheet.setColumnWidth(4, 4000);
        sheet.setColumnWidth(5, 4000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 4000);
        sheet.setColumnWidth(8, 4000);
        sheet.setColumnWidth(9, 4000);
        sheet.setColumnWidth(10, 4000);
        sheet.setColumnWidth(11, 4000);
        sheet.setColumnWidth(12, 8000);
        sheet.setColumnWidth(13, 4000);
        sheet.setColumnWidth(14, 3000);

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

        Row row = sheet.createRow(0);
        for(int k = 0; k < header.length; k++){
            Cell cell = row.createCell(k);
            cell.setCellValue(header[k]);
            cell.setCellStyle(style);
        }

        for(int i = 0; i < flights.size(); i++){
            row = sheet.createRow(i+1);
            int j = 0;

            Cell cell1 = row.createCell(j++);
            cell1.setCellValue(flights.get(i).getId());

            Cell cell2 = row.createCell(j++);
            cell2.setCellValue(flights.get(i).getCode());

            Cell cell3 = row.createCell(j++);
            cell3.setCellValue(flights.get(i).getDepartureAirport().getName());

            Cell cell4 = row.createCell(j++);
            cell4.setCellValue(flights.get(i).getArrivalAirport().getName());

            Cell cell5 = row.createCell(j++);
            cell5.setCellValue(flights.get(i).getDepartureDate().toString());

            Cell cell6 = row.createCell(j++);
            cell6.setCellValue(flights.get(i).getDepartureTime().toString());

            Cell cell7 = row.createCell(j++);
            cell7.setCellValue(flights.get(i).getArrivalDate().toString());

            Cell cell8 = row.createCell(j++);
            cell8.setCellValue(flights.get(i).getArrivalTime().toString());

            Cell cell9 = row.createCell(j++);
            if(Objects.isNull(flights.get(i).getDelayDepartureDate())){
                cell9.setCellValue("Null");
            }else{
                cell9.setCellValue(flights.get(i).getDelayDepartureDate().toString());
            }

            Cell cell10 = row.createCell(j++);
            if(Objects.isNull(flights.get(i).getDelayDepartureTime())){
                cell10.setCellValue("Null");
            }else{
                cell10.setCellValue(flights.get(i).getDelayDepartureTime().toString());
            }

            Cell cell11 = row.createCell(j++);
            if(Objects.isNull(flights.get(i).getDelayArrivalDate())){
                cell11.setCellValue("Null");
            }else{
                cell11.setCellValue(flights.get(i).getDelayArrivalDate().toString());
            }

            Cell cell12 = row.createCell(j++);
            if(Objects.isNull(flights.get(i).getDelayArrivalTime())){
                cell12.setCellValue("Null");
            }else{
                cell12.setCellValue(flights.get(i).getDelayArrivalTime().toString());
            }

            Cell cell13 = row.createCell(j++);
            if(Objects.isNull(flights.get(i).getDelayArrivalAirport())){
                cell13.setCellValue("Null");
            }else{
                cell13.setCellValue(flights.get(i).getDelayArrivalAirport().getName());
            }

            Cell cell14 = row.createCell(j++);
            cell14.setCellValue(flights.get(i).getAircraft().getModel());

            Cell cell15 = row.createCell(j++);
            cell15.setCellValue(flights.get(i).getFlightStatus().getName());
        }

        try{
            FileOutputStream out = new FileOutputStream(path + fileName);
            book.write(out);
            out.close();
            System.out.println("File created successful\n");
        }catch (Exception e){
            System.out.println("Error creating file\n");
            e.printStackTrace();
        }
    }

    public void importExcel(){
        try{
            FileInputStream file = new FileInputStream(path + "Prueba.xlt");
            Workbook book = new HSSFWorkbook(file);
            Sheet sheet = book.getSheetAt(0);
            List<Flight> flights = new ArrayList<>();
            Flight flight;
            int i = 0;
            for(Row row : sheet){
                if(row.getRowNum() != 0){
                    flight = new Flight();
                    flight.setId((Integer.parseInt(row.getCell(i++).getNumericCellValue()+ "")));
                    flight.setCode(row.getCell(i++).getRichStringCellValue().getString());
                    flights.add(flight);
                }
            }
            System.out.println(flights);

        }catch (Exception e){
            System.out.println("Error importing file\n");
            e.printStackTrace();
        }
    }
}
