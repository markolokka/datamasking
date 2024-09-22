package com.girbola.datamasking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DataMaskMainApplication extends Application {

    private ModelMain modelMain;
    @Override
    public void start(Stage stage) throws IOException {
        modelMain = new ModelMain();

        Parent parent = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("datamask-main.fxml"));

        parent = fxmlLoader.load();


        Scene scene = new Scene(parent, 320, 240);
        stage.setTitle("Data Masking");
        stage.setScene(scene);

        DataMaskMainController dataMaskMainController = (DataMaskMainController) fxmlLoader.getController();

        dataMaskMainController.initialize(modelMain);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}