import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    public static void main(String[] args) {
        try {
            String filePath = "/workspaces/codespaces-blank/puzzle.txt";
            int sum = calculateCalibrationSum(filePath);
            System.out.println("Sum of calibration values: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateCalibrationSum(String filePath) throws IOException {
        int sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int firstDigit = findFirstNumber(line);
                int lastDigit = findLastNumber(line);

                if (firstDigit != -1 && lastDigit != -1) {
                    int calibrationValue = firstDigit * 10 + lastDigit;
                    sum += calibrationValue;
                }
            }
        }

        return sum;
    }

    private static int findFirstNumber(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        return -1;
    }

    private static int findLastNumber(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        return -1;
    }
}
