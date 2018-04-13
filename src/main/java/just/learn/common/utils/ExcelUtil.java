package just.learn.common.utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yt on 2017/3/4.
 */
public class ExcelUtil {

    private ExcelUtil() {
    }


    /**
     * 适用于第一行是标题行的excel，例如
     * 姓名   年龄  性别  身高
     * 张三   25  男   175
     * 李四   22  女   160
     * 每一行构成一个map，key值是列标题，value是列值。没有值的单元格其value值为null
     * 返回结果最外层的list对应一个excel文件，第二层的list对应一个sheet页，第三层的map对应sheet页中的一行
     *
     * @throws Exception
     */
    public static List<List<Map<String, String>>> readExcelWithTitle(MultipartFile file) throws Exception {
        InputStream is = null;
        Workbook wb = null;
        try {
            is = file.getInputStream();
            wb = new XSSFWorkbook(is);

            List<List<Map<String, String>>> result = new ArrayList<List<Map<String, String>>>();//对应excel文件

            int sheetSize = wb.getNumberOfSheets();
            for (int i = 0; i < sheetSize; i++) {//遍历sheet页
                Sheet sheet = wb.getSheetAt(i);
                List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//对应sheet页

                List<String> titles = new ArrayList<String>();//放置所有的标题

                int rowSize = sheet.getLastRowNum() + 1;
                for (int j = 0; j < rowSize; j++) {//遍历行
                    Row row = sheet.getRow(j);
                    if (row == null) {//略过空行
                        continue;
                    }
                    int cellSize = row.getLastCellNum();//行中有多少个单元格，也就是有多少列
                    if (j == 0) {//第一行是标题行
                        for (int k = 0; k < cellSize; k++) {
                            Cell cell = row.getCell(k);

                            titles.add(cell.toString());
                        }
                    } else {//其他行是数据行
                        Map<String, String> rowMap = new HashMap<String, String>();//对应一个数据行
                        for (int k = 0; k < titles.size(); k++) {
                            Cell cell = row.getCell(k);
                            String key = titles.get(k);
                            String value = null;
                            if (cell != null) {
                                value = cell.toString();
                            }
                            rowMap.put(key, value);
                        }
                        sheetList.add(rowMap);
                    }
                }
                result.add(sheetList);
            }

            return result;
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (wb != null) {
                wb.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * excel导出到输出流
     * 谁调用谁负责关闭输出流
     *
     * @param os           输出流
     * @param excelExtName excel文件的扩展名，支持xls和xlsx，不带点号
     * @param data
     * @throws IOException
     */
    public static void writeExcel(OutputStream os, String excelExtName, Map<String, List<List<String>>> data) throws
            IOException {
        Workbook wb = null;
        try {
            if ("xls".equals(excelExtName)) {
                wb = new HSSFWorkbook();
            } else if ("xlsx".equals(excelExtName)) {
                wb = new XSSFWorkbook();
            } else {
                throw new Exception("当前文件不是excel文件");
            }
            for (String sheetName : data.keySet()) {
                Sheet sheet = wb.createSheet(sheetName);
                List<List<String>> rowList = data.get(sheetName);
                for (int i = 0; i < rowList.size(); i++) {
                    List<String> cellList = rowList.get(i);
                    Row row = sheet.createRow(i);
                    for (int j = 0; j < cellList.size(); j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(cellList.get(j));
                    }
                }
            }
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (wb != null) {
                wb.close();
            }
        }
    }



    public class ExcelData {
        private String value;//单元格的值
        private int colSpan = 1;//单元格跨几列
        private int rowSpan = 1;//单元格跨几行
        private boolean alignCenter;//单元格是否居中，默认不居中，如果选择是，则水平和上下都居中

        public boolean isAlignCenter() {
            return alignCenter;
        }

        public void setAlignCenter(boolean alignCenter) {
            this.alignCenter = alignCenter;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getColSpan() {
            return colSpan;
        }

        public void setColSpan(int colSpan) {
            this.colSpan = colSpan;
        }

        public int getRowSpan() {
            return rowSpan;
        }

        public void setRowSpan(int rowSpan) {
            this.rowSpan = rowSpan;
        }
    }

    /**
     * excel导出到输出流
     * 谁调用谁负责关闭输出流
     *
     * @param os           输出流
     * @param excelExtName excel文件的扩展名，支持xls和xlsx，不带点号
     * @param data         excel数据，map中的key是标签页的名称，value对应的list是标签页中的数据。list中的子list是标签页中的一行，子list
     *                     中的对象是一个单元格的数据，包括是否居中、跨几行几列以及存的值是多少
     * @throws IOException
     */
    public static void testWrite(OutputStream os, String excelExtName, Map<String, List<List<ExcelData>>> data)
            throws IOException {
        Workbook wb = null;
        CellStyle cellStyle = null;
        boolean isXls;
        try {
            if ("xls".equals(excelExtName)) {
                wb = new HSSFWorkbook();
                isXls = true;
            } else if ("xlsx".equals(excelExtName)) {
                wb = new XSSFWorkbook();
                isXls = false;
            } else {
                throw new Exception("当前文件不是excel文件");
            }
            cellStyle = wb.createCellStyle();
            if (isXls) {
                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            } else {
                cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
            }
            for (String sheetName : data.keySet()) {
                Sheet sheet = wb.createSheet(sheetName);
                List<List<ExcelData>> rowList = data.get(sheetName);
                //i 代表第几行 从0开始
                for (int i = 0; i < rowList.size(); i++) {
                    List<ExcelData> cellList = rowList.get(i);
                    Row row = sheet.createRow(i);
                    int j = 0;//j 代表第几列 从0开始
                    for (ExcelData excelData : cellList) {
                        if (excelData != null) {
                            if (excelData.getColSpan() > 1 || excelData.getRowSpan() > 1) {
                                CellRangeAddress cra = new CellRangeAddress(i, i + excelData.getRowSpan() - 1, j, j +
                                        excelData.getColSpan() - 1);
                                sheet.addMergedRegion(cra);
                            }
                            Cell cell = row.createCell(j);
                            cell.setCellValue(excelData.getValue());
                            if (excelData.isAlignCenter()) {
                                cell.setCellStyle(cellStyle);
                            }
                            j = j + excelData.getColSpan();
                        } else {
                            j++;
                        }
                    }
                }
            }
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (wb != null) {
                wb.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        List<List<Map<String, String>>> outer= ExcelUtil.readExcelWithTitle(new File
// ("C:\\Users\\PXC\\Desktop\\test\\test.xlsx"));
//        List<Map<String,String>> result=outer.get(0);
//        for (Map<String,String> map:result) {
//            User user=new User();
//            user.setHeadpic(map.get("headPic"));
//            user.setDepartment(map.get("department"));
//            user.setGender(map.get("gender"));
//            user.setPassword(map.get("password"));
//            user.setName(map.get("name"));
//            user.setNickname(map.get("nickname"));
//            user.setNote(map.get("note"));
//            user.setRole(map.get("role"));
//            user.setStuNum(map.get("stuNum"));
//            user.setTeaNum(map.get("teaNum"));
//            user.setPhone(map.get("phone"));
//            System.out.println(user);
//        }

    }
}
