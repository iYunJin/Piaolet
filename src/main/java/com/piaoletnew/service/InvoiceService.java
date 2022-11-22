package com.piaoletnew.service;

import com.piaoletnew.domain.*;
import com.piaoletnew.utils.Utility;
import com.piaoletnew.view.AddInterface;
import com.piaoletnew.view.InvoiceInterface;
import com.piaoletnew.view.MainInterface;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


import java.time.LocalDate;

import java.util.HashMap;
import java.util.HashSet;


@SuppressWarnings({"all"})
public class InvoiceService {

    public static HashSet<InvoiceData> invoiceList = new HashSet<>();

    public static int num = 0;

    static InvoiceInterface invoiceInterface = InvoiceInterface.getInstance();

    /**
     * 此函数设置显示的HBox布局
     *
     */
    public MyHBox HBoxSet(InvoiceData invoiceData){
        VBox vb = new VBox();
        MyHBox myHBox = new MyHBox(invoiceData);

        Label label1,label2,label3,label4;

        invoiceData.setMyHBox(myHBox);
        try{
            label1 = new Label(invoiceData.getSell_name()+invoiceData.getInvoice_kind());
            label2 = new Label("发票号："+ invoiceData.getInvoice_num());
            label3 = new Label("日期 ："+ invoiceData.getDate().toString());
            label4 = new Label("-%s".formatted(invoiceData.getInvoice_amount()));
            label1.setFont(new Font(15));
            label2.setFont(new Font(10));
            label3.setFont(new Font(10));
            label4.setFont(new Font("黑体",20));
            vb.getChildren().addAll(label1,label2,label3);
            vb.setSpacing(5);
            myHBox.getChildren().addAll(vb,label4);
            myHBox.setPadding(new Insets(10,10,10,10));
            myHBox.setSpacing(400);
        }catch (NullPointerException e){
            System.out.println("日期不能为空");
        }

        return myHBox;
    }


    private void MyHBoxUpdate(MyHBox myHBox){

        InvoiceData invoiceData = myHBox.getInvoiceData();
        VBox vb = (VBox) myHBox.getChildren().get(0);

        ((Label)vb.getChildren().get(0)).setText(invoiceData.getSell_name()+invoiceData.getInvoice_kind());
        ((Label)vb.getChildren().get(1)).setText("发票号："+ invoiceData.getInvoice_num());
        ((Label)vb.getChildren().get(2)).setText("日期 ："+ invoiceData.getDate().toString());
        ((Label)myHBox.getChildren().get(1)).setText("-%s".formatted(invoiceData.getInvoice_amount()));
    }

    /**
     * 修改发票内容
     * @param invoiceData
     */
    public void ChangeInvoice(InvoiceData invoiceData){

        invoiceData.setDate(invoiceInterface.dp.getValue());
        invoiceData.setInvoice_kind(invoiceInterface.cb.getValue());
        invoiceData.setInvoice_num(invoiceInterface.textFields[0].getText());
        invoiceData.setInvoice_code(invoiceInterface.textFields[1].getText());
        invoiceData.setInvoice_amount(invoiceInterface.textFields[2].getText());
        invoiceData.setPurchaser_name(invoiceInterface.textFields[5].getText());
        invoiceData.setSell_name(invoiceInterface.textFields[6].getText());
        invoiceData.setTax_rate(invoiceInterface.textFields[7].getText());
        invoiceData.setTax_amount(invoiceInterface.textFields[8].getText());
        invoiceData.setPrice_tax(invoiceInterface.textFields[9].getText());
        invoiceData.setRemarks(invoiceInterface.textFields[10].getText());

        MyHBoxUpdate(invoiceData.getMyHBox());
    }

    /**
     * 将用户输入的数据添加到集合里
     */
    public void AddNewInvoice(){

        String invoice_name,invoice_num,invoice_code,invoice_kind,
                invoice_amount,purchaser_name,sell_name,
                tax_rate,tax_amount,price_tax,remarks;

        LocalDate date;

        InvoiceData invoiceData;


        date = AddInterface.dp.getValue();
        invoice_num  = AddInterface.textFields[0].getText();
        invoice_amount  = AddInterface.textFields[1].getText();
        invoice_code  = AddInterface.textFields[2].getText();
        invoice_kind  = AddInterface.cb.getValue();
        purchaser_name  = AddInterface.textFields[3].getText();
        sell_name = AddInterface.textFields[4].getText();
        tax_rate = AddInterface.textFields[5].getText();
        tax_amount = AddInterface.textFields[6].getText();
        price_tax = AddInterface.textFields[7].getText();
        remarks = AddInterface.textFields[8].getText();

        invoiceData = new InvoiceData(invoice_num,invoice_code, invoice_amount,
                                        date,invoice_kind,purchaser_name,sell_name,
                                        tax_rate,tax_amount,price_tax);

        try {
            invoiceList.add(invoiceData);
            MainInterface.listData.add(HBoxSet(invoiceData));

        }catch (NullPointerException e){
            e.printStackTrace();
        }finally {
            clear();
        }
    }

    public void DeleteInvoice(MyHBox myHBox){

        MainInterface.listData.remove(myHBox);
        invoiceList.remove(myHBox.getInvoiceData());

    }



    public void clear(){
        AddInterface.dp.setValue(null);
        AddInterface.cb.setValue("");
        for (int i=0;i<AddInterface.textFields.length;i++)
            AddInterface.textFields[i].clear();
    }
}
