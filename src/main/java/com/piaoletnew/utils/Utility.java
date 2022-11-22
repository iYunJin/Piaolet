package com.piaoletnew.utils;

import com.piaoletnew.domain.InvoiceData;
import com.piaoletnew.service.InvoiceService;
import com.piaoletnew.view.MainInterface;


import java.io.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Utility {

    static String filePath = "e:\\data.dat";

    static File file = new File(filePath);

    public static void saveData() {
        FileOutputStream fos = null;
        try {
            if(!file.exists())
                file.createNewFile();

            fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (InvoiceData invoiceData : InvoiceService.invoiceList) {
                oos.writeObject(invoiceData);
            }

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

    public static void loadData() throws ClassCastException {
        Object obj = null;
        FileInputStream fis = null;
        InvoiceService invoiceData = new InvoiceService();
        try {
            fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
//            System.out.println(ois.readObject());

            while ((obj = ois.readObject()) != null) {
                InvoiceService.invoiceList.add((InvoiceData)obj);
                MainInterface.listData.add(invoiceData.HBoxSet((InvoiceData) obj));
//                System.out.println(obj);
            }
        }catch (EOFException e){
            System.out.println("数据加载完成");
        }catch (ClassNotFoundException|IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(fis!=null)
                    fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
