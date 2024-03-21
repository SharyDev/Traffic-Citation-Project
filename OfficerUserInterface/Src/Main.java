package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Login");

        AnchorPane header = new AnchorPane();
        Label headerTitle = new Label("Login");
        headerTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        header.getChildren().add(headerTitle);
        AnchorPane.setTopAnchor(headerTitle, 10.0);
        AnchorPane.setLeftAnchor(headerTitle, 10.0);
        AnchorPane.setRightAnchor(headerTitle, 10.0);
        header.setStyle("-fx-background-color: #f0f0f0;");
        header.setPrefHeight(30);

        Label titleLabel = new Label("Login To TCRS:");
        titleLabel.setStyle("-fx-font-weight: bold;");

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            System.out.println("Username: " + username + ", Password: " + password);
            // Here you can perform authentication logic

            if (username.equals("Shahroz") && password.equals("Testing")) {
                openNewStage();
                primaryStage.close();
            } else {
                System.out.println("Incorrect username or password.");
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setStyle("-fx-background-color: #FFFFFF;");
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        gridPane.add(titleLabel, 1, 0, 2, 1); 
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(usernameField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(submitButton, 1, 3, 2, 1); 

        VBox root = new VBox();
        root.getChildren().addAll(header, gridPane); 

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openNewStage() {
        Stage newStage = new Stage();
        newStage.setTitle("TCR - Traffic Citation Reporting System");
        AnchorPane HeaderTCRS = new AnchorPane();
        Label headerTitle = new Label("TCRS Query");
        headerTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        HeaderTCRS.getChildren().add(headerTitle);
        
        AnchorPane.setTopAnchor(headerTitle, 10.0);
        AnchorPane.setLeftAnchor(headerTitle, 10.0);
        AnchorPane.setRightAnchor(headerTitle, 10.0);
        HeaderTCRS.setStyle("-fx-background-color: #f0f0f0;");
        HeaderTCRS.setPrefHeight(30);
        
        Pane Desc = new Pane();
        
        Label Label2 = new Label("Conduct Query");

        //For centering the Label
        Label2.layoutXProperty().bind(Desc.widthProperty().subtract(Label2.widthProperty()).divide(2));

    
        Label2.layoutYProperty().bind(Desc.heightProperty().subtract(Label2.heightProperty()).divide(2));

        Desc.getChildren().add(Label2);
        
        
       
        
        GridPane mainSearchPane = new GridPane();
        mainSearchPane.setVgap(100);
        mainSearchPane.setHgap(10);
        mainSearchPane.setStyle("-fx-background-color: #FFFFFF;");
        GridPane.setMargin(mainSearchPane, new Insets(50, 0, 0, 0));
        
        Pane vehileSearchPane = new Pane();
        Label VehileLabel = new Label("Vehile Search");
        
        VehileLabel.layoutXProperty().bind(vehileSearchPane.widthProperty().subtract(VehileLabel.widthProperty()).divide(2));

        
        
        vehileSearchPane.getChildren().add(VehileLabel);
        vehileSearchPane.setPrefSize(100, 100); // Set preferred size for VehileSearchPane
        vehileSearchPane.setStyle("-fx-background-color: #f0f0f0;");
        GridPane.setMargin(vehileSearchPane, new Insets(0, 0, 0, 30));
       

        Pane driverSearchPane = new Pane();
       
        Label DriverLabel = new Label("Driver Search");
        
        
        DriverLabel.layoutXProperty().bind(driverSearchPane.widthProperty().subtract(DriverLabel.widthProperty()).divide(2));
        driverSearchPane.getChildren().add(DriverLabel);
        
        driverSearchPane.setPrefSize(100, 100); // Set preferred size for DriverSearchPane
        driverSearchPane.setStyle("-fx-background-color: #f0f0f0;");

        mainSearchPane.add(vehileSearchPane, 0, 0); // Add VehileSearchPane to column 1, row 0
        mainSearchPane.add(driverSearchPane, 1, 0); // Add DriverSearchPane to column 0, row 0
      

        HeaderTCRS.setStyle("-fx-background-color: #FFFFFF;");
        Desc.setStyle("-fx-background-color: #FFFFFF;");
        
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #FFFFFF;");
        root.getChildren().addAll(HeaderTCRS,Desc,mainSearchPane); 
        
        
        Scene newScene = new Scene(root, 300, 200);
        newStage.setScene(newScene);
        newStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
