package com.piaoletnew.domain;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class HBoxSet {
    private VBox vb = new VBox();
    private MyHBox hb;
    private Label label1,label2,label3,label4;

    public HBoxSet(InvoiceData invoiceData) {
        try{
            this.label1 = new Label(invoiceData.getSell_name()+invoiceData.getInvoice_kind());
            this.label2 = new Label("发票号："+ invoiceData.getInvoice_num());
            this.label3 = new Label("日期 ："+ invoiceData.getDate().toString());
            this.label4 = new Label("-%s".formatted(invoiceData.getInvoice_amount()));
        }catch (NullPointerException e){
            System.out.println("日期不能为空");
        }

        setVb();
    }

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
    }

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label label3) {
        this.label3 = label3;
    }

    public void setVb(){
        label1.setFont(new Font(15));
        label2.setFont(new Font(10));
        label3.setFont(new Font(10));
        label4.setFont(new Font("黑体",20));
        vb.getChildren().addAll(label1,label2,label3);
        vb.setSpacing(5);
        hb.getChildren().addAll(vb,label4);
        hb.setPadding(new Insets(10,10,10,10));
        hb.setSpacing(400);

    }

    public HBox getHb() {
        return hb;
    }
}
