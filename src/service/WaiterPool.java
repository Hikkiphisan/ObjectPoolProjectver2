package service;

import utils.exception.WaiterNotFoundException;
import model.WaiterInServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class WaiterPool {
    private static final long EXPIRED_TIME_IN_MILESECOND = 1200;
    private static final long NUMBER_OF_WAITER = 9;

    private final List<WaiterInServer> available = Collections.synchronizedList(new ArrayList<>());
    private final List<WaiterInServer> inUse = Collections.synchronizedList(new ArrayList<>());

    private final AtomicInteger count = new AtomicInteger(0);
    private final AtomicBoolean waiting = new AtomicBoolean(false);

    public synchronized WaiterInServer getWaiter() {
        if (!available.isEmpty()) {
            WaiterInServer waiter = available.remove(0);
            inUse.add(waiter);
            return waiter;
        }
        if (count.get() == NUMBER_OF_WAITER) {
            this.waitingUntilWaiterAvailable();
            return this.getWaiter();
        }
        WaiterInServer waiter = this.createWaiter();
        inUse.add(waiter);
        return waiter;
    }

    public synchronized void release(WaiterInServer waiter)  {
        inUse.remove(waiter);
        available.add(waiter);
        System.out.println(waiter.getNameWaiter() + " đang rảnh và có thể chạy bàn.");
    }

    private WaiterInServer createWaiter() {
        String[] nameWaiter = {
                "Trần Minh Trí", "Phí Hữu Lộc", "Nguyễn Đức Thắng", "Lê Tuấn Dũng", "Đào Văn Huy Hưng",
                "Hoàng Minh Nhật", "Thành", "Phí Hữu Lộc"
        };
        waiting(200);

        // Lấy tên nhân viên từ mảng nameWaiter theo chỉ số
        int index = count.incrementAndGet() - 1;  // Giả sử count là một AtomicInteger, giúp đếm số nhân viên
        String waiterName = nameWaiter[index];  // Lấy tên của nhân viên theo chỉ số


        WaiterInServer waiter = new WaiterInServer("Nhân viên phục vụ " + waiterName); //TRuyen nhan vien boi ban cua HIgland vao
        System.out.println(waiter.getNameWaiter() + " đã được triệu tập!!");
        return waiter;
    }



    private void waitingUntilWaiterAvailable() {
        if (waiting.get()) {
            waiting.set(false);
            throw new WaiterNotFoundException("Hiện tại chưa có nhân viên phục vụ nào đang rảnh để có thể chạy bàn");
        }
        waiting.set(true);
        waiting(EXPIRED_TIME_IN_MILESECOND); //1200
    }



    private void waiting(long numberOfSecond) {
        try {
            TimeUnit.MILLISECONDS.sleep(numberOfSecond); //đưa luồng (thread) vào trạng thái ngủ (sleep) trong một khoảng thời gian nhất định, được đo bằng mili giây.
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); // gửi tín hiệu ngắt (interrupt) tới chính luồng hiện tại. Khi gọi phương thức này, nó đánh dấu luồng hiện tại là bị "ngắt" (interrupted), nhưng không tự động dừng luồng đó.
        }
    }

}

/*
Đây là cách thức hoạt động của waitingUntilWaiterAvailable:

Kiểm tra trạng thái chờ:

waiting.get() kiểm tra xem có luồng nào đang chờ (waiting) hay không.
Nếu waiting.get() trả về true, nghĩa là đã có luồng khác đang trong trạng thái chờ, do đó, phương thức sẽ đặt lại waiting thành false và ném ra ngoại lệ WaiterNotFoundException. Ngoại lệ này thông báo rằng hiện không có nhân viên nào rảnh để phục vụ khách hàng.
Thiết lập trạng thái chờ:

Nếu waiting.get() trả về false, nghĩa là chưa có luồng nào chờ, waiting.set(true) được gọi để thiết lập trạng thái chờ. Từ đây, khách hàng sẽ phải chờ một khoảng thời gian nhất định để có thể thử lấy nhân viên phục vụ lại.
Chờ trong khoảng thời gian cố định:

waiting(EXPIRED_TIME_IN_MILESECOND) gọi đến phương thức waiting(long numberOfSecond) với giá trị EXPIRED_TIME_IN_MILESECOND (1200 milliseconds) để đưa luồng vào trạng thái ngủ trong khoảng thời gian 1200ms.
Trong thời gian này, nếu có nhân viên phục vụ được giải phóng (release), trạng thái sẽ thay đổi và khách hàng có thể tiếp tục được phục vụ.
Giải phóng trạng thái chờ khi có ngoại lệ:

Nếu không có nhân viên nào được giải phóng trong thời gian chờ 1200ms, WaiterNotFoundException sẽ thông báo rằng không có nhân viên phục vụ nào rảnh vào lúc này.
 */