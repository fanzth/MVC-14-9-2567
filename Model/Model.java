package Model;

import java.io.*;
import java.util.HashMap;

public class Model {
    private String csvFilePath = "CowList.csv";
    private HashMap<String, String[]> cowData = new HashMap<>();

    // โหลดข้อมูลจากไฟล์ CSV
    public Model() {
        loadCowDataFromCSV();
    }

    // ตรวจสอบว่ารหัสวัวมีอยู่ในข้อมูลหรือไม่
    public boolean isCowExist(String cowId) {
        return cowData.containsKey(cowId);
    }

    // ดึงข้อมูลวัวทั้งหมดจากไฟล์ CSV
    private void loadCowDataFromCSV() {
        File csvFile = new File(csvFilePath);

        // ถ้าไม่มีไฟล์ ให้สร้างไฟล์ขึ้นมาพร้อม header
        if (!csvFile.exists()) {
            createCSVFileWithHeader();
        }

        // อ่านข้อมูลจากไฟล์ CSV
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // ข้าม header ไป
            br.readLine();

            // อ่านแต่ละบรรทัดและเก็บข้อมูลใน cowData
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String cowId = data[0];
                String[] cowInfo = { data[1], data[2], data[3] }; // สี, ปี, เดือน
                cowData.put(cowId, cowInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // สร้างไฟล์ CSV พร้อม header
    private void createCSVFileWithHeader() {
        try (FileWriter writer = new FileWriter(csvFilePath)) {
            // เขียน header ลงในไฟล์
            writer.append("cowid,cowcolor,cowyear,cowmonth\n");
            // สามารถเพิ่มข้อมูลตัวอย่างได้ถ้าต้องการ
            // อันนี้เป็นชุดตัวอย่างที่ใช้ในการทดสอบ
            writer.append("12345678,white,5,6\n");
            writer.append("87654321,brown,3,4\n");
            writer.append("11223344,white,7,9\n");
            writer.append("44332211,brown,2,11\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ดึงประเภทวัวจากรหัส
    public String getCowType(String cowId) {
        String[] cowInfo = cowData.get(cowId);
        return cowInfo[0]; // index 0 คือ สีของวัว
    }

    // ผลิตนมตามประเภทของวัว
    public String produceMilk(String cowType) {
        if ("white".equalsIgnoreCase(cowType)) {
            return "Plain Milk";
        } else if ("brown".equalsIgnoreCase(cowType)) {
            return "Chocolate Milk";
        }
        return "Unknown Milk";
    }

    // เพิ่มฟังก์ชันสำหรับดึงอายุของวัวเพื่อใช้ในคำนวณเพิ่มเติม
    public int getCowAgeYear(String cowId) {
        String[] cowInfo = cowData.get(cowId);
        return Integer.parseInt(cowInfo[1]); // index 1 คือ ปีของวัว
    }

    public int getCowAgeMonth(String cowId) {
        String[] cowInfo = cowData.get(cowId);
        return Integer.parseInt(cowInfo[2]); // index 2 คือ เดือนของวัว
    }
}
