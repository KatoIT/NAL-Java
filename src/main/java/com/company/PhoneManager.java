package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneManager {
    String filePath = new File("").getAbsolutePath();
    String fileName = filePath + "\\src\\main\\java\\data\\mobiles.csv";
    List<Phone> phoneList = new ArrayList<>();
    Service service = new Service();

    PhoneManager() {
        getPhoneListByFile();
    }

    /**
     * File IO
     */
    public void getPhoneListByFile() {
        String line;
        String splitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(splitBy);
                if (columns[0].trim().equals("genuine")) {
                    phoneList.add(new GenuinePhone(
                            Integer.parseInt(columns[1].trim()),
                            columns[2].trim(),
                            Double.parseDouble(columns[3].trim()),
                            Integer.parseInt(columns[4].trim()),
                            columns[5].trim(),
                            Integer.parseInt(columns[6].trim()),
                            columns[7].trim()));
                } else if (columns[0].trim().equals("cell")) {
                    phoneList.add(new CellPhone(
                            Integer.parseInt(columns[1].trim()),
                            columns[2].trim(),
                            Double.parseDouble(columns[3].trim()),
                            Integer.parseInt(columns[4].trim()),
                            columns[5].trim(),
                            columns[6].trim(),
                            columns[7].trim()));
                } else {
                    // TODO sản phẩm loại khác.
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean writePhoneListToFile() {
        try (FileWriter fw = new FileWriter(fileName, false);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            for (Phone phone : phoneList) {
                pw.println(phone.toString());
            }
            pw.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Insert, Delete
     */
    public boolean insertPhone(Phone phone) {
        phoneList.add(phone);
        writePhoneListToFile();
        return true;
    }

    public boolean deletePhone(Phone phone) {
        if (phoneList.remove(phone)) {
            if (writePhoneListToFile()) {
                return true;
            } else {
                phoneList.add(phone);
                return false;
            }
        }
        return false;
    }

    /**
     * Search
     */
    public List<Phone> approximateSearch(String textSearch) {
        List<Phone> phoneListAnswer = new ArrayList<>();
        Pattern pattern = Pattern.compile("^.*" + textSearch + ".*$");
        for (Phone phone : phoneList) {
            Matcher matcher = pattern.matcher(phone.id + "");
            if (matcher.matches()) {
                phoneListAnswer.add(phone);
                continue;
            }
            matcher = pattern.matcher(phone.name);
            if (matcher.matches()) {
                phoneListAnswer.add(phone);
            }
        }
        return phoneListAnswer;
    }

    public Phone findById(int id) {
        for (Phone phone : phoneList) {
            if (phone.id == id) {
                return phone;
            }
        }
        return null;
    }

    /**
     *
     */
    public void showPhoneList() {
        if (phoneList.isEmpty()) {
            System.out.println("*** Không có sản phẩm nào ***");
        } else {
            System.out.println("Số sản phẩm điện thoại hiện có: " + phoneList.size());
            for (Phone phone : phoneList) {
                phone.show();
            }
        }
    }

    public int autoIncrementId() {
        int id = 0;
        for (Phone phone : phoneList) {
            if (id < phone.id) id = phone.id;
        }
        return id + 1;
    }
}
