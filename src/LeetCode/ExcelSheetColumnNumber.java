package LeetCode;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
        String columnTitle = "AB";
        int columnNumber = escn.titleToNumber(columnTitle);
        System.out.println("Column Title: " + columnTitle + " -> Column Number: " + columnNumber); // Should return 28
    }
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            // Convert character to its corresponding number (A=1, B=2, ..., Z=26)
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }

}
