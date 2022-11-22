package com.piaoletnew.view;

import com.piaoletnew.domain.MyHBox;
import com.piaoletnew.service.InvoiceService;
import com.piaoletnew.utils.Utility;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

import java.time.LocalDate;


public class MainInterface extends Application {

    public static ObservableList<MyHBox> listData = FXCollections.observableArrayList();

    static ListView<MyHBox> listView = new ListView<>();

    public static DatePicker dp = new DatePicker();

    VBox vb = new VBox();
    HBox hb2 = new HBox();

    public static TextField textField = new TextField();

    Button btn1 = new Button("新增");
    Button btn2 = new Button("查询");
    BorderPane root = new BorderPane();
    Stage stage1 = new Stage();
    Stage stage2 = new Stage();

    static InvoiceInterface invoiceInterface = InvoiceInterface.getInstance();
    static AddInterface addInterface = AddInterface.getInstance();
    static InvoiceService invoiceService = new InvoiceService();
    static AlertBox alertBox = AlertBox.getInstance();

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root,600,610);
        stage.setTitle("发票管理系统");
        listView.setItems(listData);

        SceneSet(stage);

        //设置单元格工厂
        listView.setCellFactory(new Callback<ListView<MyHBox>, ListCell<MyHBox>>() {
            @Override
            public ListCell<MyHBox> call(ListView<MyHBox> vBoxListView) {
                return new MyListCell();
            }
        });

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage1.setScene(addInterface.scene);
                stage1.show();
            }
        });


        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER)
                    System.out.println("oh~");
            }
        });

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {


            @Override
            public void handle(MouseEvent mouseEvent) {
                GlobalMenu gm = GlobalMenu.getInstance();
                if((mouseEvent.getButton()== MouseButton.SECONDARY)&&(mouseEvent.getClickCount()==1)){
                    Node node = mouseEvent.getPickResult().getIntersectedNode();
                    GlobalMenu.getInstance().show(node, Side.RIGHT, 0, 0);
                    gm.getDeleteMenuItem().setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            alertBox.display("是否删除？");
                            invoiceService.DeleteInvoice(listView.getSelectionModel().getSelectedItem());
                        }
                    });

                }

                if((mouseEvent.getButton()== MouseButton.PRIMARY)&&(mouseEvent.getClickCount()==2)){
                    invoiceInterface.showInfo(listView.getSelectionModel().getSelectedItem());//
                    stage2.setScene(invoiceInterface.scene);
                    stage2.show();
                }
            }
        });

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                if (windowEvent.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST)
                    Utility.saveData();
            }
        });

        stage.setScene(scene);
        Utility.loadData();
        stage.show();

    }

    /**
     * 函数：SceneSet  设置界面布局，界面所有空间属性设置写在这个函数里。
     */

    public void SceneSet(Stage stage){

        textField.setPromptText("搜索");
        vb.getChildren().addAll(textField,dp);
        vb.setPrefSize(stage.getWidth()-50,stage.getHeight()/7);
        vb.setPadding(new Insets(10));
        vb.setSpacing(15);
        dp.setValue(LocalDate.now());
        btn1.setPrefSize(80,10);
        btn2.setPrefSize(40,10);
        hb2.getChildren().add(btn1);
        hb2.setAlignment(Pos.CENTER);
        hb2.setPadding(new Insets(10));
        hb2.setSpacing(20);
        root.autosize();
        root.setTop(vb);
        root.setCenter(listView);
        root.setBottom(hb2);
    }

    /**
     * 列表单元格设置
     */

    static class MyListCell extends ListCell<MyHBox> {
        public void updateItem(MyHBox item,boolean empty){
            super.updateItem(item,empty);
            this.setFont(new Font("楷书",15));

            if(item!=null)
                this.setGraphic(item);
        }
    }
}
