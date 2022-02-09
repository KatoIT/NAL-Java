package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Service {
    List<DienThoaiChinhHang> listCH = new ArrayList<>();
    List<DienThoaiXachTay> listXT = new ArrayList<>();

    Service() {
        listCH = ReadDTCH("C:\\Users\\nguye\\Desktop\\NAL-Java\\src\\data\\mobilesCH.csv");
        listXT = ReadDTXT("C:\\Users\\nguye\\Desktop\\NAL-Java\\src\\data\\mobilesXT.csv");
    }

    public void addDTCH(Scanner sc) {
        System.out.println("Add DTCH:");
        System.out.println("Ten DT: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Gia: ");
        double price = sc.nextDouble();
        while (price < 0) {
            System.out.println("Gia (>=0): ");
            price = sc.nextDouble();
        }
        System.out.println("So luong: ");
        int qty = sc.nextInt();
        while (qty < 0) {
            System.out.println("So luong (>=0): ");
            qty = sc.nextInt();
        }
        System.out.println("NSX: ");
        sc.nextLine();
        String provide = sc.nextLine();
        System.out.println("TGBH: ");
        int warrantyPeriod = sc.nextInt();
        while (warrantyPeriod < 0 || warrantyPeriod > 730) {
            System.out.println("TGBH(>=0 and <= 730): ");
            warrantyPeriod = sc.nextInt();
        }
        System.out.println("Pham vi BH: ");
        sc.nextLine();
        String location = sc.nextLine();
        while (!location.equals("Toan Quoc") && !location.equals("Quoc Te")) {
            System.out.println("Pham vi BH (Toan Quoc or Quoc Te): ");
            location = sc.nextLine();
        }

        listCH.add(new DienThoaiChinhHang(idAuto(), name, price, qty, provide, warrantyPeriod, location));
    }

    public void addDTXT(Scanner sc) {
        System.out.println("Add DTXT:");
        System.out.println("Ten DT: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Gia: ");
        double price = sc.nextDouble();
        while (price < 0) {
            System.out.println("Gia (>=0): ");
            price = sc.nextDouble();
        }
        System.out.println("So luong: ");
        int qty = sc.nextInt();
        while (qty < 0) {
            System.out.println("So luong (>=0): ");
            qty = sc.nextInt();
        }
        System.out.println("NSX: ");
        sc.nextLine();
        String provide = sc.nextLine();
        System.out.println("Quoc gia xach tay: ");
        sc.nextLine();
        String country = sc.nextLine();
        while (country.equals("Viet Nam")) {
            System.out.println("Quoc gia xach tay(Not is Viet Nam): ");
            country = sc.nextLine();
        }
        System.out.println("Trang thai: ");
        String status = sc.next();
        while (!status.equals("Da sua chua") && !status.equals("Chua sua chua")) {
            System.out.println("Trang thai (\'Chua sua chua\' or \'Da sua chua\'): ");
            status = sc.next();
        }
        listXT.add(new DienThoaiXachTay(idAuto(), name, price, qty, provide, country, status));
    }

    public void display() {
        for (DienThoai dtxt :
                listXT) {
            dtxt.display();
        }
        for (DienThoai dtch :
                listCH) {
            dtch.display();
        }
    }

    public List<DienThoaiXachTay> ReadDTXT(String fileName) {
        List<DienThoaiXachTay> listDTXT = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] phone = line.split(splitBy);    // use comma as separator
                listDTXT.add(new DienThoaiXachTay(
                        Integer.parseInt(phone[0]),
                        phone[1],
                        Double.parseDouble(phone[2]),
                        Integer.parseInt(phone[3]),
                        phone[4],
                        phone[5],
                        phone[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listDTXT;
    }

    public List<DienThoaiChinhHang> ReadDTCH(String fileName) {
        List<DienThoaiChinhHang> listDTCH = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] phone = line.split(splitBy);    // use comma as separator
                listDTCH.add(new DienThoaiChinhHang(
                        Integer.parseInt(phone[0]),
                        phone[1],
                        Double.parseDouble(phone[2]),
                        Integer.parseInt(phone[3]),
                        phone[4],
                        Integer.parseInt(phone[5]),
                        phone[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listDTCH;
    }

    public void writeDTCH(String actionName) {
        String whereWrite = "./csvFiles/audit.csv";

        try {
            FileWriter fw = new FileWriter(whereWrite, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            Date date = new Date();

            pw.println(actionName + "," + date.toString());
            pw.flush();
            pw.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteDT(int id) {
        for (DienThoai dtxt :
                listXT) {
            if (id == dtxt.id) {
                listXT.remove(dtxt);
                return true;
            }
        }
        for (DienThoai dtch :
                listCH) {
            if (id == dtch.id) {
                listXT.remove(dtch);
                return true;
            }
        }
        return false;
    }

    public boolean checkDT(int id) {
        for (DienThoai dtxt :
                listXT) {
            if (id == dtxt.id) {
                return true;
            }
        }
        for (DienThoai dtch :
                listCH) {
            if (id == dtch.id) {
                return true;
            }
        }
        return false;
    }

    public int idAuto() {
        int id = 0;
        for (DienThoai dtxt :
                listXT) {
            if (id < dtxt.id) id = dtxt.id;
        }
        for (DienThoai dtch :
                listCH) {
            if (id < dtch.id) id = dtch.id;
        }
        return id + 1;
    }

    public DienThoai findById(int id){
        for (DienThoai dtxt :
                listXT) {
            if (id == dtxt.id) {
                return dtxt;
            }
        }
        for (DienThoai dtch :
                listCH) {
            if (id == dtch.id) {
                return dtch;
            }
        }
        return null;
    }

    public DienThoai findByName(String name){
        for (DienThoai dtxt :
                listXT) {
            if (name.equals(dtxt.name)) {
                return dtxt;
            }
        }
        for (DienThoai dtch :
                listCH) {
            if (name.equals(dtch.name)) {
                return dtch;
            }
        }
        return null;
    }
}
