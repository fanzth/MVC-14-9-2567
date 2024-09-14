import Model.Model;
import View.View;

public class Main {
    public static void main(String[] args) {
        // สร้าง View และ Model
        View view = new View();
        Model model = new Model();

        // สร้าง Controller และเชื่อม Model กับ View
        Controller controller = new Controller(model, view);

        // แสดงหน้าจอ GUI หลัก
        view.setVisible(true);
    }
}
