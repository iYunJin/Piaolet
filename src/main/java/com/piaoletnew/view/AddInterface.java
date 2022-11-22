package com.piaoletnew.view;

import com.piaoletnew.service.InvoiceService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * 添加发票界面的设计
 */
public class AddInterface{
    /*
    标签和文字框
     */
    String[] strings = {"发票号码","发票代码","发票金额",
                        "发票日期","发票类型","购方名称",
                        "销方名称","税    率","税    额",
                        "价税合计","备     注"};

    private static AddInterface INSTANCE = null;

    public static TextField[] textFields = new TextField[9];
    HBox[] hBoxes = new HBox[12];
    Label[] labels = new Label[11];

    Button btn1 = new Button("保存");

    public static ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.observableArrayList(
            "增值税专用发票", "增值税普通发票", "通用定额发票", "其他"
     ));

    public static DatePicker dp = new DatePicker();
    GridPane gridPane = new GridPane();
    public Scene scene;

    private AddInterface(){
        start();
    }

    /**
     * 设置空间布局及其属性
     */
    public void start(){
        init();

        cb.setPrefSize(150,10);
        btn1.setPrefSize(80,10);


        scene = new Scene(gridPane,600,400);
        for (int i=0;i<=2;i++)
            hBoxes[i].getChildren().addAll(labels[i],textFields[i]);

        for (int i=5;i<=10;i++)
            hBoxes[i].getChildren().addAll(labels[i],textFields[i-2]);

        hBoxes[3].getChildren().addAll(labels[3],dp);
        hBoxes[4].getChildren().addAll(labels[4],cb);
        hBoxes[11].getChildren().add(btn1);

        //设置布局内部空间位置
        for (int i = 0; i <= 10; i++)
            hBoxes[i].setSpacing(10);
        hBoxes[11].setAlignment(Pos.CENTER_RIGHT);

        //添加布局到场景中
        for (int i = 0; i < hBoxes.length -1 ; i++) {
            if (i%2==0)
                gridPane.add(hBoxes[i],0,i/2);
            else
                gridPane.add(hBoxes[i],1,i/2);
        }
        gridPane.add(hBoxes[11],0,6);
        gridPane.setHgap(30);gridPane.setVgap(30);
        gridPane.setPadding(new Insets(30));

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new InvoiceService().AddNewInvoice();
                }catch (NullPointerException e){
                    e.printStackTrace();
                    System.out.println("日期部分不能为空");
                }
            }
        });
    }

    public void init(){
        for (int i = 0;i<labels.length;i++)
            labels[i] = new Label(strings[i]);

        for (int i = 0;i<textFields.length;i++)
            textFields[i] = new TextField();

        for (int i = 0;i<hBoxes.length;i++)
            hBoxes[i] = new HBox();
    }

    public static AddInterface getInstance(){
        if (INSTANCE == null)
            INSTANCE = new AddInterface();
        return INSTANCE;
    }

}
