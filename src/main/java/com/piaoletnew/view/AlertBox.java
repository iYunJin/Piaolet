package com.piaoletnew.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    private static AlertBox INSTANCE= null;

    Button btn1 = new Button("确定");
    Button btn2 = new Button("取消");
    Label label = new Label("添加内容");

    HBox hBox = new HBox();
    VBox vBox = new VBox();

    Scene scene = new Scene(vBox,300,150);

    private AlertBox() {
        hBox.getChildren().addAll(btn1,btn2);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));

        vBox.getChildren().addAll(label,hBox);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);


    }

    public void display(String message){
        label.setText(message);

    }

    public static AlertBox getInstance(){
        if (INSTANCE == null)
            INSTANCE = new AlertBox();
        return INSTANCE;
    }
}

