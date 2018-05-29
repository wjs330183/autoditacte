package com.kefang.autoditacte.utils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class ExcelFileUtils {
    private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    //private static Logger logger = LogManager.getLogger(ExcelReader.class);
    //private int sheetNo;//页号
    /**
     * 读取Excel数据内容
     * @param is
     * @return Map 包含单元格数据内容的Map对象
     *
     */
    public static String[] EXCEL_TYPE={"xls","et"};
    public static boolean isExcl(String fileExt){
        if(CommonUtils.isNotEmpty(fileExt)){
            for(int i=0;i<EXCEL_TYPE.length;i++){
                if (fileExt.equals(EXCEL_TYPE[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    public List<Map<String,String>> readExcel(InputStream is) {
        Map<String,String> dataMap;
        List<Map<String,String>> dataList= new ArrayList<>();
        String value = "";
        System.out.print("解析开始");
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheet("Sheet1");
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] keyArray = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            keyArray[i] = row.getCell(i).getRichStringCellValue().toString().trim();
        }
        int rowNum = sheet.getLastRowNum();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            dataMap= new HashMap<>();
            row = sheet.getRow(i);
            if(row!=null){
                int j = 0;
                while (j <=colNum) {
                    //这里把列循环到Map
                    if(row.getCell(j)!=null){
                        value = row.getCell(j).getRichStringCellValue().toString().trim();
                        dataMap.put(keyArray[j],value);
                    }
                    j++;
                }
                dataList.add(dataMap);
            }
        }
       // logger.info("解析xls完成...");
        System.out.print("解析xls完成...");
        try {
            if(is!=null)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
           // logger.error(e.toString());
        }
        return dataList;
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return

    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                /*case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);
                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        DecimalFormat df = new DecimalFormat("0");
                        String dfStr = df.format(cell.getNumericCellValue());
                        cellvalue = dfStr;
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }
    */
}
