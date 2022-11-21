package com.piaoletnew.domain;

import javafx.scene.layout.HBox;

public class MyHBox extends HBox {
    private InvoiceData invoiceData;



    private boolean isShow = true;

    public MyHBox(){
        super();
    }

    public MyHBox(InvoiceData invoiceData){
        this();
        this.invoiceData = invoiceData;
    }

    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
