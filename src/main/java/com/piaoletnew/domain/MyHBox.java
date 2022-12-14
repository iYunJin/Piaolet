package com.piaoletnew.domain;

import javafx.scene.layout.HBox;

import java.io.Serializable;

public class MyHBox extends HBox implements Serializable {
    private InvoiceData invoiceData;

    private static final long serialVersionUID = 10L;

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
