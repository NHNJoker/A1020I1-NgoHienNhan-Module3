package common;

import model.bean.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFileCSV {
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeFile(List<String> listObj, String object) {
        String fileName = null;
        switch (object) {
            case "Customer":
                fileName = "src/Data/Customer.csv";
                break;
            case "Employee":
                fileName = "src/Data/Employee.csv";
                break;
            case "Villa":
                fileName = "src/Data/Villa.csv";
                break;
            case "House":
                fileName = "src/Data/House.csv";
                break;
            case "Room":
                fileName = "src/Data/Room.csv";
                break;
            case "Booking":
                fileName = "src/Data/Booking.csv";
                break;
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            for (String list : listObj) {
                fileWriter.append(list);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (
                Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static List<String> readFile(String object) {
        BufferedReader br = null;
        String fileName = null;
        List<String> stringList = new ArrayList<>();
        switch (object) {
            case "Customer":
                fileName = "src/Data/Customer.csv";
                break;
            case "Employee":
                fileName = "src/Data/Employee.csv";
                break;
            case "Villa":
                fileName = "src/Data/Villa.csv";
                break;
            case "House":
                fileName = "src/Data/House.csv";
                break;
            case "Room":
                fileName = "src/Data/Room.csv";
                break;
            case "Booking":
                fileName = "src/Data/Booking.csv";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + object);
        }
        Path path = Paths.get(fileName);
        // nếu file csv chưa có thì sẽ tạo một file csv mới
        if (!Files.exists(path)) {
            try {
                FileWriter fileWriter = new FileWriter(fileName);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return stringList;
    }

//    public static ArrayList<Customer> readFileCustomer() {
//        ArrayList<Customer> customerArrayList = new ArrayList<>();
//        for (int i = 0; i < readFile("Customer").size(); i++) {
//            String[] splitData = readFile("Customer").get(i).split(",");
//            Customer customer = new Customer();
//            customer.setNameCus(splitData[0]);
//            customer.setDateOfBirth(splitData[1]);
//            customer.setGender(splitData[2]);
//            customer.setId(splitData[3]);
//            customer.setEmail(splitData[4]);
//            customer.setTypeOfCus(splitData[5]);
//            customer.setAddress(splitData[6]);
//            customerArrayList.add(customer);
//        }
//        return customerArrayList;
//    }

//    public static ArrayList<Employee> readFileEmployee() {
//        ArrayList<Employee> employeeArrayList = new ArrayList<>();
//        for (int i = 0; i < readFile("Employee").size(); i++) {
//            String[] splitData = readFile("Employee").get(i).split(",");
////            Employee employee = new Employee();
//            employee.setNameOfEmployee(splitData[0]);
//            employee.setDateOfBirth(splitData[1]);
//            employee.setEmail(splitData[2]);
//            employee.setId(splitData[3]);
//            employee.setPhone(splitData[4]);
//            employee.setLevel(splitData[5]);
//            employee.setWorkPosition(splitData[6]);
//            employee.setWorkingParts(splitData[7]);
//            employeeArrayList.add(employee);
//        }
//        return employeeArrayList;
//    }

//    public static ArrayList<Services> readFileVilla() {
//        ArrayList<Services> villaArrayList = new ArrayList<>();
//        for (int i = 0; i < readFile("Villa").size(); i++) {
//            String[] splitData = readFile("Villa").get(i).split(",");
//            Villa villa = new Villa();
//            villa.setId(splitData[0]);
//            villa.setServiceName(splitData[1]);
//            villa.setAreaUsed(parseDouble(splitData[2]));
//            villa.setRentalCosts(Integer.parseInt(splitData[3]));
//            villa.setMaxPeople(Integer.parseInt(splitData[4]));
//            villa.setRentalType(splitData[5]);
//            villa.setTypeOfRoom(splitData[6]);
//            villa.setOtherAmenities(splitData[7]);
//            villa.setAcreagePool(parseDouble(splitData[8]));
//            villa.setNumOfFloor(Integer.parseInt(splitData[9]));
//            villaArrayList.add(villa);
//        }
//        return villaArrayList;
//    }
//
//    public static ArrayList<Services> readFileHouse() {
//        ArrayList<Services> houseArrayList = new ArrayList<>();
//        for (int i = 0; i < readFile("House").size(); i++) {
//            String[] splitData = readFile("House").get(i).split(",");
//            House house = new House();
//            house.setId(splitData[0]);
//            house.setServiceName(splitData[1]);
//            house.setAreaUsed(Double.parseDouble(splitData[2]));
//            house.setRentalCosts(Integer.parseInt(splitData[3]));
//            house.setMaxPeople(Integer.parseInt(splitData[4]));
//            house.setRentalType(splitData[5]);
//            house.setTypeOfRoom(splitData[6]);
//            house.setOtherAmenities(splitData[7]);
//            house.setNumOfFloor(Integer.parseInt(splitData[8]));
//            houseArrayList.add(house);
//        }
//        return houseArrayList;
//    }
//
//    public static ArrayList<Services> readFileRoom() {
//        ArrayList<Services> roomArrayList = new ArrayList<>();
//        for (int i = 0; i < readFile("Room").size(); i++) {
//            String[] splitData = readFile("Room").get(i).split(",");
//            Room room = new Room();
//            room.setId(splitData[0]);
//            room.setServiceName(splitData[1]);
//            room.setAreaUsed(Double.parseDouble(splitData[2]));
//            room.setRentalCosts(Integer.parseInt(splitData[3]));
//            room.setMaxPeople(Integer.parseInt(splitData[4]));
//            room.setRentalType(splitData[5]);
//            ServiceFree serviceFree = new ServiceFree();
//            serviceFree.setServiceFreeName(splitData[6]);
//            serviceFree.setUnit(Integer.parseInt(splitData[7]));
//            serviceFree.setPrice(Integer.parseInt(splitData[8]));
//            room.setServiceFreeObj(serviceFree);
//            roomArrayList.add(room);
//        }
//        return roomArrayList;
//    }
//
//    public static ArrayList<Customer> readFileBooking() {
//        ArrayList<Customer> bookingArrList = new ArrayList<>();
//        for (int i = 0; i < readFile("Booking").size(); i++) {
//            String[] splitData = readFile("Booking").get(i).split(",");
//            Customer customer = new Customer();
//            customer.setId(splitData[0]);
//            customer.setNameCus(splitData[1]);
//            switch (splitData[2].substring(0, 4)) {
//                case "SVVL":
//                    Services villa = new Villa();
//                    villa.setId(splitData[2]);
//                    villa.setServiceName(splitData[3]);
//                    customer.setUseService(villa);
//                    bookingArrList.add(customer);
//                    break;
//                case "SVHO":
//                    Services house = new House();
//                    house.setId(splitData[2]);
//                    house.setServiceName(splitData[3]);
//                    customer.setUseService(house);
//                    bookingArrList.add(customer);
//                    break;
//                case "SVRO":
//                    Services room = new Room();
//                    room.setId(splitData[2]);
//                    room.setServiceName(splitData[3]);
//                    customer.setUseService(room);
//                    bookingArrList.add(customer);
//            }
//        }
//        return bookingArrList;
//    }
}
