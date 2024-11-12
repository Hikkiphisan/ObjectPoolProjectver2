package observer;

import model.ClientThread;

public interface Subject {
    void addObserver(CustomerObserver customerObserver);      // Đăng ký Observer mới
    void removeObserver(CustomerObserver customerObserver);   // Hủy đăng ký Observer
    void notifyObserevrs(String newDrink, CustomerObserver customer);    // Thông báo cho tất cả Observer về đồ uống mới
}