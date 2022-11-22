package com.piaoletnew.view;

import com.piaoletnew.domain.InvoiceData;
import com.piaoletnew.domain.MyHBox;
import com.piaoletnew.service.InvoiceService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class InvoiceInterface {

    private static InvoiceInterface INSTANCE = null;

    Label[] labels = new Label[11];
    String[] strings = {"发票号码:\t","发票代码:\t","发票金额:\t",
                        "发票日期:\t","发票类型:\t","购方名称:\t",
                        "销方名称:\t","税    率:\t","税     额:\t",
                        "价税合计:\t","备    注:\t"};

    public static TextField[] textFields = new TextField[11];
    Button btn1 = new Button("修改");
    HBox[] hBoxes = new HBox[11];
    VBox vb =new VBox();
    public DatePicker dp = new DatePicker();
    public ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.observableArrayList(
            "增值税专用发票", "增值税普通发票", "通用定额发票", "其他"
    ));

    Scene scene;
    static InvoiceData invoiceData;
    static InvoiceService invoiceService = new InvoiceService();


    private InvoiceInterface(){
        start();
    }

    public void start(){
        Set();
        scene = new Scene(vb,450,500);
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                if ("保存".equals(btn1.getText())){
                    invoiceService.ChangeInvoice(invoiceData);
                    btn1.setText("修改");
                    for (TextField textField : textFields) {
                        textField.setEditable(false);
                    }
                    dp.setDisable(true);
                    cb.setDisable(true);
                }

                else {
                    btn1.setText("保存");
                    for (TextField textField : textFields) {
                        textField.setEditable(true);
                    }
                    dp.setDisable(false);
                    cb.setDisable(false);

                }
            }
        });
    }

    public void showInfo(MyHBox myHBox){

        invoiceData = myHBox.getInvoiceData();

        textFields[0].setText(invoiceData.getInvoice_num());
        textFields[1].setText(invoiceData.getInvoice_code());
        textFields[2].setText(invoiceData.getInvoice_amount());
        dp.setValue(invoiceData.getDate());
        cb.setValue(invoiceData.getInvoice_kind());
        textFields[5].setText(invoiceData.getPurchaser_name());
        textFields[6].setText(invoiceData.getSell_name());
        textFields[7].setText(invoiceData.getTax_rate());
        textFields[8].setText(invoiceData.getTax_amount());
        textFields[9].setText(invoiceData.getPrice_tax());
        textFields[10].setText(invoiceData.getRemarks());

        for (TextField textField : textFields) {
            textField.setEditable(false);
        }
        dp.setDisable(true);
        cb.setDisable(true);
    }

    /**
     * 显示界面的布局
     */
    public void Set(){

        for (int i = 0;i<labels.length;i++){
            labels[i]  = new Label(strings[i]);
            labels[i].setFont(new Font("黑体", 16));
            textFields[i] = new TextField();
            hBoxes[i] = new HBox();
            if (i==3)
                hBoxes[i].getChildren().addAll(labels[i],dp);
            else if (i==4)
                hBoxes[i].getChildren().addAll(labels[i],cb);
            else
                hBoxes[i].getChildren().addAll(labels[i],textFields[i]);
            vb.getChildren().add(hBoxes[i]);
        }
        btn1.setPrefSize(80,10);
        vb.getChildren().add(btn1);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10));
    }

    public static InvoiceInterface getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new InvoiceInterface();
        }
        return INSTANCE;
    }
}
