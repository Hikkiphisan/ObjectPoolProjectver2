package observer;

public interface Subject {
    void addObserver(Observer observer);      // Đăng ký Observer mới
    void removeObserver(Observer observer);   // Hủy đăng ký Observer
    void notifyObservers(String newDrink);    // Thông báo cho tất cả Observer về đồ uống mới
}