package ru.by.bsuir.sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.text.Font;



public class Main extends Application {

    public static void main() {
    }

    public void start(Stage stage) {
        stage.setTitle("Подбор корня");
        stage.setHeight(200);
        stage.setWidth(400);

        FlowPane inputLayer1 = new FlowPane(10, 15);
        inputLayer1.setMaxWidth(400);
        inputLayer1.setMaxHeight(20);
        Label label1 = new Label("x +");
        label1.setMaxWidth(30);
        TextField term = new TextField();
        term.setMaxWidth(160);
        term.setEditable(true);
        Label label2 = new Label("=");
        label2.setMaxWidth(30);
        TextField sum = new TextField();
        sum.setMaxWidth(160);
        sum.setEditable(true);
        inputLayer1.getChildren().addAll(label1, term, label2, sum);
        inputLayer1.setAlignment(Pos.CENTER_LEFT);

        FlowPane inputLayer2 = new FlowPane(10, 15);
        inputLayer2.setMaxWidth(300);
        inputLayer2.setMaxHeight(20);
        Label label3 = new Label("Начало диапазона: ");
        label3.setMaxWidth(150);
        TextField begOfRange = new TextField();
        begOfRange.setMaxWidth(300);
        begOfRange.setEditable(true);
        inputLayer2.getChildren().addAll(label3, begOfRange);
        inputLayer2.setAlignment(Pos.CENTER_LEFT);

        FlowPane inputLayer3 = new FlowPane(10, 15);
        inputLayer3.setMaxWidth(300);
        inputLayer3.setMaxHeight(20);
        Label label4 = new Label("Конец диапазона: ");
        label1.setMaxWidth(100);
        TextField endOfRange = new TextField();
        endOfRange.setMaxWidth(200);
        endOfRange.setEditable(true);
        inputLayer3.getChildren().addAll(label4, endOfRange);
        inputLayer3.setAlignment(Pos.CENTER_LEFT);


        FlowPane resultLayer = new FlowPane(10, 15);
        resultLayer.setAlignment(Pos.CENTER_LEFT);
        resultLayer.setMaxWidth(400);
        resultLayer.setMaxHeight(20);
        Button result = new Button("Подобрать!");
        result.setMaxWidth(100);
        result.setMaxHeight(14);
        Label label5 = new Label("Корень: ");
        label1.setMaxWidth(100);
        Label resultAns = new Label();
        label1.setMaxWidth(100);
        label1.setMaxWidth(100);
        resultLayer.getChildren().addAll(result, label5, resultAns);

        FlowPane mainLayer = new FlowPane(0, 15, inputLayer1, inputLayer2, inputLayer3, resultLayer);
        mainLayer.setMaxHeight(500);
        mainLayer.setAlignment(Pos.CENTER_LEFT);
        mainLayer.setMargin(inputLayer1, new Insets(0, 0, 0, 10));
        mainLayer.setMargin(inputLayer2, new Insets(0, 0, 0, 10));
        mainLayer.setMargin(inputLayer3, new Insets(0, 0, 0, 10));
        mainLayer.setMargin(resultLayer, new Insets(0, 0, 0, 10));
        Scene scene = new Scene(mainLayer);
        stage.setScene(scene);

        result.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    int firstterm = Integer.parseInt(term.getText());
                    int summ = Integer.parseInt(sum.getText());
                    int beg = Integer.parseInt(begOfRange.getText());
                    int end = Integer.parseInt(endOfRange.getText());
                    String result ="";
                    result = Algorithm.findRoot(firstterm, summ, beg, end);
                    resultAns.setText(result);
                }
               catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    Stage err = new Stage();
                    FlowPane errlay = new FlowPane();
                    Label error = new Label("ERROR");
                    error.setFont(Font.font("", 72));
                    errlay.getChildren().add(error);
                    Scene errscene = new Scene(errlay);
                    errlay.setAlignment(Pos.CENTER);
                    err.setScene(errscene);
                    err.show();
                }
            }
        });
        stage.show();
    }

}