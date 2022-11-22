package com.piaoletnew.domain;

import java.io.Serializable;
import java.time.LocalDate;



public class InvoiceData implements Serializable {
    public static final String VAT_SPECIAL;
    public static final String VAT_ORDINARY;
    public static final String GENERAL_QUOTA;
    public static final String OTHER;

    private static final long serialVersionUID = 1L;

    private String invoice_num,invoice_code,invoice_kind,
                    invoice_amount,purchaser_name,sell_name,
                    tax_rate,tax_amount,price_tax,remarks;

    private LocalDate date;
    private MyHBox myHBox;

    static{
        VAT_SPECIAL = "增值税专用发票";
        VAT_ORDINARY= "增值税普通发票";
        GENERAL_QUOTA = "通用定额发票";
        OTHER =  "其他";
    }


    public InvoiceData(String invoice_num, String invoice_code, String invoice_amount,
                       LocalDate date, String invoice_kind,String purchaser_name,String sell_name,
                       String tax_rate,String tax_amount, String price_tax) {
        this.invoice_kind = invoice_kind;
        this.invoice_num = invoice_num;
        this.invoice_code = invoice_code;
        this.date = date;
        this.invoice_amount = invoice_amount;
        this.purchaser_name = purchaser_name;
        this.sell_name = sell_name;
        this.tax_rate = tax_rate;
        this.tax_amount = tax_amount;
        this.price_tax = price_tax;
    }

    public InvoiceData(String invoice_num, String invoice_code, String invoice_amount,
                       LocalDate date, String invoice_kind,String purchaser_name,String sell_name,
                       String tax_rate,String tax_amount, String price_tax,
                       String remarks) {

        this.invoice_kind = invoice_kind;
        this.invoice_num = invoice_num;
        this.invoice_code = invoice_code;
        this.invoice_amount = invoice_amount;
        this.purchaser_name = purchaser_name;
        this.sell_name = sell_name;
        this.date = date;
        this.tax_rate = tax_rate;
        this.tax_amount = tax_amount;
        this.price_tax = price_tax;
        this.remarks = remarks;
    }

    public String getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(String invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public String getPurchaser_name() {
        return purchaser_name;
    }

    public void setPurchaser_name(String purchaser_name) {
        this.purchaser_name = purchaser_name;
    }

    public String getSell_name() {
        return sell_name;
    }

    public void setSell_name(String sell_name) {
        this.sell_name = sell_name;
    }

    public String getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(String tax_rate) {
        this.tax_rate = tax_rate;
    }

    public String getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(String tax_amount) {
        this.tax_amount = tax_amount;
    }

    public String getPrice_tax() {
        return price_tax;
    }

    public void setPrice_tax(String price_tax) {
        this.price_tax = price_tax;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInvoice_kind() {
        return invoice_kind;
    }

    public String getInvoice_num() {
        return invoice_num;
    }

    public String getInvoice_code() {
        return invoice_code;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setInvoice_kind(String invoice_kind) {
        this.invoice_kind = invoice_kind;
    }

    public void setInvoice_num(String invoice_num) {
        this.invoice_num = invoice_num;
    }

    public void setInvoice_code(String invoice_code) {
        this.invoice_code = invoice_code;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MyHBox getMyHBox() {
        return myHBox;
    }

    public void setMyHBox(MyHBox myHBox) {
        this.myHBox = myHBox;
    }

    @Override
    public String toString() {
        return "InvoiceData{" +
                "invoice_kind='" + invoice_kind + '\'' +
                '}';
    }
}

