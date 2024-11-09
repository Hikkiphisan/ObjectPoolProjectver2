package view;

import java.util.ArrayList;
import java.util.List;

import model.ClientThread;
import service.WaiterPool;
import controller.ReadOrderRequestsDataFromFileTxt;
import controller.PrintInvoicefromTxt;

public class AppOrderDrinkfromCodeGym {
    public static final int NUM_OF_CLIENT = 7;                                                 // số lượng client tối đa được vào cửa tiệm để gọi món
    public static void main ( String[] args) {
        WaiterPool waiterPool = new WaiterPool();


        List<String> clientNames = new ArrayList<>();
        List<String> drinkNames = new ArrayList<>();
        List<String> moneyNames = new ArrayList<>();


        // Đọc thông tin khách hàng từ file gọi món.
        ReadOrderRequestsDataFromFileTxt.readOrderRequestsDataFromFileTxt(clientNames,drinkNames,moneyNames);


        // Tạo hóa đơn riêng lẻ cho từng khách hàng
        for (int i = 0; i < NUM_OF_CLIENT; i++) {

            String clientName = clientNames.get(i);
            String drinkName = drinkNames.get(i);
            String moneyName = moneyNames.get(i);
            PrintInvoicefromTxt.printInvoicefromTxt(clientName,drinkName,moneyName);


            // Tạo và chạy thread cho từng khách hàng
            Runnable client = new ClientThread(waiterPool, clientName, drinkName, moneyName);
            Thread thread = new Thread(client);
            thread.start();
        }


    }



    }

