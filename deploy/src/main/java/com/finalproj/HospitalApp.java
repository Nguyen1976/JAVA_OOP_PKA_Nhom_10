package com.finalproj;

import com.finalproj.Controller.HospitalController;
import com.finalproj.Modal.*;
import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        HospitalController controller = new HospitalController(hospital);

        while (true) {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ BỆNH VIỆN =====");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Sửa thông tin bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Xem thông tin bệnh nhân");
            System.out.println("5. Thêm phòng điều trị");
            System.out.println("6. Sửa thông tin phòng điều trị");
            System.out.println("7. Xóa phòng điều trị");
            System.out.println("8. Gán bệnh nhân vào phòng điều trị");
            System.out.println("9. Xóa bệnh nhân khỏi phòng điều trị");
            System.out.println("10. Xem danh sách bệnh nhân từ phòng điều trị");
            System.out.println("0. Thoát");
            System.out.print("Vui lòng chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Thêm bệnh nhân
                    System.out.println("Nhập tên bệnh nhân:");
                    String name = scanner.nextLine();
                    System.out.println("Nhập tuổi:");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập giới tính:");
                    String gender = scanner.nextLine();
                    System.out.println("Nhập chẩn đoán:");
                    String diagnose = scanner.nextLine();
                    System.out.println("Nhập số điện thoại:");
                    String phone = scanner.nextLine();
                    System.out.println("Nhập tên thành phố:");
                    String city = scanner.nextLine();
                    System.out.println("Nhập tên quận/huyện:");
                    String district = scanner.nextLine();
                    Address address = new Address(city, district);

                    controller.addPatient(name, age, gender, diagnose, address, phone, 0);
                    break;

                case 2:
                    // Sửa thông tin bệnh nhân
                    System.out.println("Nhập ID bệnh nhân cần sửa:");
                    int updatePatientId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập tên mới:");
                    String newName = scanner.nextLine();
                    System.out.println("Nhập tuổi mới:");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập giới tính mới:");
                    String newGender = scanner.nextLine();
                    System.out.println("Nhập chẩn đoán mới:");
                    String newDiagnose = scanner.nextLine();
                    System.out.println("Nhập số điện thoại mới:");
                    String newPhone = scanner.nextLine();
                    System.out.println("Nhập tên thành phố:");
                    String newCity = scanner.nextLine();
                    System.out.println("Nhập tên quận/huyện:");
                    String newDistrict = scanner.nextLine();
                    Address newAddress = new Address(newCity, newDistrict);

                    controller.updatePatient(updatePatientId, newName, newAge, newGender, newDiagnose, newAddress, newPhone);
                    break;

                case 3:
                    // Xóa bệnh nhân
                    System.out.println("Nhập ID bệnh nhân cần xóa:");
                    int deletePatientId = scanner.nextInt();
                    scanner.nextLine();
                    controller.deletePatient(deletePatientId);
                    break;

                case 4:
                    // Xem thông tin bệnh nhân
                    System.out.println("Nhập ID bệnh nhân cần xem:");
                    int viewPatientId = scanner.nextInt();
                    scanner.nextLine();
                    controller.getPatientInfo(viewPatientId);
                    break;

                case 5:
                    // Thêm phòng điều trị
                    System.out.println("Nhập tên phòng:");
                    String roomName = scanner.nextLine();
                    System.out.println("Nhập loại phòng:");
                    String roomType = scanner.nextLine();
                    System.out.println("Nhập sức chứa:");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();
                    controller.addTreatmentRoom(roomName, roomType, capacity);
                    break;

                case 6:
                    // Sửa thông tin phòng điều trị
                    System.out.println("Nhập ID phòng cần sửa:");
                    int updateRoomId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhập tên mới cho phòng:");
                    String newRoomName = scanner.nextLine();
                    System.out.println("Nhập loại phòng mới:");
                    String newRoomType = scanner.nextLine();
                    System.out.println("Nhập sức chứa:");
                    int newCapacity = scanner.nextInt();
                    scanner.nextLine();
                    controller.updateTreatmentRoom(updateRoomId, newRoomName, newRoomType, newCapacity);
                    break;

                case 7:
                    // Xóa phòng điều trị
                    System.out.println("Nhập ID phòng cần xóa:");
                    int deleteRoomId = scanner.nextInt();
                    scanner.nextLine();
                    controller.deleteTreatmentRoom(deleteRoomId);
                    break;

                case 8:
                    // Gán bệnh nhân vào phòng điều trị
                    System.out.println("Nhập ID bệnh nhân:");
                    int patientIdAssign = scanner.nextInt();
                    System.out.println("Nhập ID phòng điều trị:");
                    int roomIdAssign = scanner.nextInt();
                    controller.assignPatientToRoom(patientIdAssign, roomIdAssign);
                    break;

                case 9:
                    // Xóa bệnh nhân khỏi phòng điều trị
                    System.out.println("Nhập ID bệnh nhân:");
                    int patientIdRemove = scanner.nextInt();
                    System.out.println("Nhập ID phòng điều trị:");
                    int roomIdRemove = scanner.nextInt();
                    controller.removePatientFromRoom(patientIdRemove);
                    break;
                case 10:
                    System.out.println("In danh sách bệnh nhân trong phòng điều trị");
                    System.out.println("Nhập id từ phòng điều trị");
                    int ID = scanner.nextInt();
                    controller.getPatientsInRoom(ID);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại.");
            }
        }
    }
}
