package com.piaoletnew.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class GlobalMenu extends ContextMenu {

    private InvoiceInterface invoiceInterface = InvoiceInterface.getInstance();

    Stage stage = new Stage();
    private  MenuItem deleteMenuItem = new MenuItem("删除");
    private  MenuItem checkMenuItem = new MenuItem("查看");

    public MenuItem getDeleteMenuItem() {
        return deleteMenuItem;
    }

    public MenuItem getCheckMenuItem() {
        return checkMenuItem;
    }

    @SuppressWarnings("restriction")

    private static GlobalMenu INSTANCE = null;

    private GlobalMenu() {
//        MenuItem deleteMenuItem = new MenuItem("删除");
//        MenuItem checkMenuItem = new MenuItem("查看");
        getItems().add(deleteMenuItem);
        getItems().add(checkMenuItem);

        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("删除");
            }
        });

        checkMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                invoiceInterface.showInfo(MainInterface.listView.getSelectionModel().getSelectedItem());//
                stage.setScene(invoiceInterface.scene);
                stage.show();
            }
        });

    }

    public static GlobalMenu getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalMenu();
        }
        return INSTANCE;
    }
}
