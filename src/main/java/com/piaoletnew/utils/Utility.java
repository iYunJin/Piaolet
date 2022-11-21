package com.piaoletnew.utils;

import com.piaoletnew.domain.InvoiceData;
import com.piaoletnew.service.InvoiceService;
import com.piaoletnew.view.InvoiceInterface;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class Utility {

    static HashMap hashMap;
    static String filePath = "e:\\data.properties";
    static FileOutputStream fos = null;

    public static void saveData() {
        try {
            fos = new FileOutputStream(filePath,true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            Map<Integer,InvoiceData> map = InvoiceService.invoiceList.e();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(fos!=null)
                    fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
