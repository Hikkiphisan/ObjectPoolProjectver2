package view;

import java.util.ArrayList;
import java.util.List;
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
        PrintInvoicefromTxt.printInvoicefromTxt(clientNames,drinkNames,moneyNames,NUM_OF_CLIENT,waiterPool);



    }



    }

