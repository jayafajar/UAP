package org.example.uap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FinanceManager {

    private static final String FILE_NAME = "transactions.txt";

    public void addTransaction(double totalIncome) {
        double needs = totalIncome * 0.5;
        double wants = totalIncome * 0.3;
        double investment = totalIncome * 0.1;
        double charity = totalIncome * 0.1;

        String record = LocalDate.now() + "," + totalIncome + "," + needs + "," + wants + "," + investment + "," + charity;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(record);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
