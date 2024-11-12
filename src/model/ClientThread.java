package model;

import java.time.LocalTime;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import observer.CustomerObserver;
import service.WaiterPool;
import utils.exception.WaiterNotFoundException;

public class ClientThread extends Person implements Runnable, CustomerObserver {
    private WaiterPool waiterPool;
    private String drinkName;
    private String moneyName;
    private int customerArrivalOrder;  //Khách thứ mấy đến quán
    private LocalTime customerWaitingTime;  //Thời gian khách phải chờ đợi, , ưu tiên phục vụ những khách này trước sau khi sắp xếp thứ tự ưu tiên phục vụ.

    public ClientThread(WaiterPool waiterPool, String name, String drinkName, String moneyName) {
        super(String.valueOf(0), name);
        this.waiterPool = waiterPool;
        this.drinkName = drinkName;
        this.moneyName = moneyName;
    }

    public ClientThread(String name, String drinkName, int customerArrivalOrder, LocalTime customerWaitingTime ) {
       // PPhương thức sẽ được sử dụng để sắp xếp khách tới quán để ưu tiên phục vụ

        super(String.valueOf(0), name);
        this.drinkName = drinkName;
        this.customerArrivalOrder = customerArrivalOrder;
        this.customerWaitingTime = customerWaitingTime;
    }


    public ClientThread(String name, String drinkName) {

        super(String.valueOf(0), name);
        this.drinkName = drinkName;
           }


    public String getMoneyName() {
        return moneyName;
    }

    public void setMoneyName(String moneyName) {
        this.moneyName = moneyName;
    }

    public void run() {
        orderaDrink();
    }


    private void orderaDrink() {
        try {
            System.out.println("Khách hàng " + name + " vừa mới gọi món " + drinkName + " với giá tiền là " + moneyName + "!");

            WaiterInServer waiter = waiterPool.getWaiter();
            TimeUnit.MILLISECONDS.sleep(randomInt(4000,10000));
            waiterPool.release(waiter);
            System.out.println("Vị khách hàng tên là " + name + " đã được phục vụ!");
        } catch (InterruptedException | WaiterNotFoundException e) {
            System.out.println("Vị khách " + name + " sẽ phải chờ đợi một lúc.");
        }

        System.out.println("======================Luồng/" + Thread.currentThread().getName() + "==============================");
    }




    public static int randomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    @Override
    public void update(String newDrink) {
        System.out.println("Thông báo: Đã có món mới: " + newDrink + "! Hãy thử ngay!");
    }
}