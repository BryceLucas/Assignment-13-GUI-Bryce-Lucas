import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CounterProgram extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        Button submitButton = new Button("Convert");
        Label resultLabel = new Label();

        submitButton.setOnAction(event -> {
            String query = inputField.getText();
            resultLabel.setText(processConversion(query));
        });

        VBox layout = new VBox(10, inputField, submitButton, resultLabel);
        Scene scene = new Scene(layout, 400, 200);

        primaryStage.setTitle("Converter Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String processConversion(String query) {
        if (query.equalsIgnoreCase("exit")) {
            return "Exiting the program. Goodbye!";
        }

        String[] parts = query.split(" ");
        if (parts.length != 3 || !parts[1].equals("=")) {
            return "Input not recognized. Try format: 1 kg = lb";
        }

        try {
            double value = Double.parseDouble(parts[0]);
            String fromUnit = parts[2];

            switch (fromUnit) {
                case "km":
                    return value + " km = " + (value * 1000) + " m";
                case "kg":
                    return value + " kg = " + (value * 2.20462) + " lb";
                // ... other cases ...
                case "C":
                    return value + " °C = " + ((value * 9/5) + 32) + " °F";
                default:
                    return "Unit not recognized. Try again.";
            }
        } catch (NumberFormatException e) {
            return "Invalid number format. Try again.";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
