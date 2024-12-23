package org.example.uap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.uap.FinanceManager;

public class GUI extends Application {

    private FinanceManager financeManager;

    public GUI() {
        this.financeManager = new FinanceManager();
    }

    @Override
    public void start(Stage stage) {
        Label incomeLabel = new Label("Enter your total income:");
        incomeLabel.setStyle("-fx-text-fill: #333A2F;");

        TextField incomeField = new TextField();
        incomeField.setPromptText("Income");

        Label variationLabel = new Label("Select income distribution variation:");
        variationLabel.setStyle("-fx-text-fill: #333A2F;");

        ComboBox<String> variationBox = new ComboBox<>();
        variationBox.getItems().addAll(
                "50% Needs, 30% Wants, 10% Investment, 10% Charity",
                "60% Needs, 20% Wants, 15% Investment, 5% Charity",
                "40% Needs, 30% Wants, 20% Investment, 10% Charity"
        );
        variationBox.setValue("50% Needs, 30% Wants, 10% Investment, 10% Charity");

        Button calculateButton = new Button("Calculate Distribution");
        calculateButton.setStyle("-fx-background-color: #333A2F; -fx-text-fill: white;");

        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-text-fill: #333A2F;");

        GridPane resultGrid = new GridPane();
        resultGrid.setHgap(10);
        resultGrid.setVgap(10);
        resultGrid.setPadding(new Insets(15));

        resultGrid.add(new Label("Needs:"), 0, 0);
        resultGrid.add(new Label("Wants:"), 0, 1);
        resultGrid.add(new Label("Investment:"), 0, 2);
        resultGrid.add(new Label("Charity:"), 0, 3);

        Label needsValue = new Label();
        Label wantsValue = new Label();
        Label investmentValue = new Label();
        Label charityValue = new Label();

        resultGrid.add(needsValue, 1, 0);
        resultGrid.add(wantsValue, 1, 1);
        resultGrid.add(investmentValue, 1, 2);
        resultGrid.add(charityValue, 1, 3);

        calculateButton.setOnAction(e -> {
            String incomeText = incomeField.getText().trim();
            if (incomeText.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Income field cannot be empty!");
                return;
            }

            try {
                double income = Double.parseDouble(incomeText);
                if (income <= 0) {
                    showAlert(Alert.AlertType.ERROR, "Input Error", "Income must be greater than zero!");
                    return;
                }

                String variation = variationBox.getValue();
                double[] distribution = calculateDistribution(income, variation);

                needsValue.setText(String.format("%.2f", distribution[0]));
                wantsValue.setText(String.format("%.2f", distribution[1]));
                investmentValue.setText(String.format("%.2f", distribution[2]));
                charityValue.setText(String.format("%.2f", distribution[3]));

                financeManager.addTransaction(income);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Transaction Saved and Distribution Calculated!");
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Invalid income value!");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #EBEDDF;");
        root.getChildren().addAll(incomeLabel, incomeField, variationLabel, variationBox, calculateButton, resultGrid);

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Financial Management");
        stage.show();
    }

    private double[] calculateDistribution(double income, String variation) {
        double needs = 0, wants = 0, investment = 0, charity = 0;

        switch (variation) {
            case "50% Needs, 30% Wants, 10% Investment, 10% Charity":
                needs = income * 0.5;
                wants = income * 0.3;
                investment = income * 0.1;
                charity = income * 0.1;
                break;

            case "60% Needs, 20% Wants, 15% Investment, 5% Charity":
                needs = income * 0.6;
                wants = income * 0.2;
                investment = income * 0.15;
                charity = income * 0.05;
                break;

            case "40% Needs, 30% Wants, 20% Investment, 10% Charity":
                needs = income * 0.4;
                wants = income * 0.4;
                investment = income * 0.1;
                charity = income * 0.1;
                break;
        }

        return new double[]{needs, wants, investment, charity};
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
