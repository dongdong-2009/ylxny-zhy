package com.zhy.collector.data.excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;
import java.util.Map;

/**
 * @Package com.zhy.collector.data.excel
 * @Description: excel模板
 * @User: zengqiang
 * @Date: 2018-09-12
 */
public class ExcelTemplate {
    private HSSFWorkbook wb=new HSSFWorkbook();
    //sheet最大行数
    private static int MAX_ROW_PER_SHEET = 65535;

    public ExcelTemplate(){}

    public ExcelTemplate(String[] header, String[] titles, List<Map<String,Object>> data){
        setValue(header, titles, data);
    }

    /**
     * 设置数据 并自动换页
     * @param header
     * @param titles
     * @param data
     */
    private void setValue(String[] header, String[] titles, List<Map<String, Object>> data) {
        int count = (data.size() / (MAX_ROW_PER_SHEET - 1)) + 1;
        for(int i = 1 ; i <= count; i++){
            HSSFSheet sheet = wb.createSheet("第"+i+"页");
            int maxRow = data.size() > (MAX_ROW_PER_SHEET - 1) ? (MAX_ROW_PER_SHEET - 1) : data.size();
            int baseIndex = (i-1) * (MAX_ROW_PER_SHEET-1);
            HSSFRow row = sheet.createRow(0);
            setHeader(row, header);
            for(int j = 0 ; j < maxRow; j++){
                HSSFRow dataRow = sheet.createRow(j);
                Map<String, Object> map = data.get(baseIndex+j);
                for(int k = 0 ; k < titles.length; k++){
                    String title = titles[k];
                    HSSFCell cell = dataRow.createCell(k);
                    cell.setCellValue(String.valueOf(map.get(title)));
                }
            }
        }

    }

    /**
     * 设置
     * @param row
     * @param headers
     */
    private void setHeader(HSSFRow row, String[] headers) {
        HSSFCell cell = row.createCell(0);
        for(int i = 0 ; i < headers.length; i++){
            cell.setCellValue(headers[i]);
        }
    }
}