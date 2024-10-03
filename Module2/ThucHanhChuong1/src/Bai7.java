public class Bai7 {
    // Hàm trả về số ngày của tháng trong năm
    public static int countDayOfMonth(int month, int year) {
        return (month == 2) ? (isLeapYear(year) ? 29 : 28) :
                ((month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31);
    }

    // Hàm kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    public static void main(String[] args) {
        int month = 2;  // Tháng cố định
        int year = 2000;  // Năm cố định

        System.out.println("Số ngày của tháng " + month + " năm " + year + " là: " + countDayOfMonth(month, year));
    }
}
