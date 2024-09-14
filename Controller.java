import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.BrownCowModel;
import Model.Model;
import Model.WhiteCowModel;
import View.BrownCowView;
import View.View;
import View.WhiteCowView;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addSubmitListener(new SubmitListener());
    }

    // ตรวจสอบว่า CowID ที่รับเข้ามาถูกต้องหรือไม่
    private boolean isValidCowId(String cowId) {
        if (cowId.matches("\\d{8}")) {
            return !cowId.startsWith("0");
        }
        return false;
    }

    // สร้าง ActionListener สำหรับปุ่ม Submit
    class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cowId = view.getCowId();

            // ตรวจสอบ CowID ที่รับเข้ามาว่าเป็นเลข 8 หลักและไม่ขึ้นต้นด้วย 0 หรือไม่
            if (!isValidCowId(cowId)) {
                view.showMessage("CowID must be 8 digits and not start with 0");
                return;
            }

            // เช็คว่า CowID ที่รับเข้ามามีอยู่ในระบบหรือไม่
            if (model.isCowExist(cowId)) {
                String cowColor = model.getCowType(cowId);

                // สร้าง Object ของวัวสีน้ำตาลหรือขาว
                if ("brown".equalsIgnoreCase(cowColor)) {
                    BrownCowModel brownCowModel = new BrownCowModel(model.getCowAgeYear(cowId));
                    BrownCowView brownCowView = new BrownCowView();
                    brownCowView.setVisible(true);

                    brownCowView.addMilkButtonListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String milkResult = brownCowModel.produceMilk();
                            if (milkResult == "Almond Milk (BSOD)") {
                                brownCowModel.setBSOD();
                            }
                            if (brownCowModel.isBSOD()) {
                                brownCowView.showMessage(milkResult + "RESET NOWWWWWW!");
                            } else {
                                brownCowView.showMessage(milkResult);
                            }
                        }
                    });
                } else if ("white".equalsIgnoreCase(cowColor)) {
                    WhiteCowModel whiteCowModel = new WhiteCowModel(model.getCowAgeMonth(cowId));
                    WhiteCowView whiteCowView = new WhiteCowView();
                    whiteCowView.setVisible(true);

                    whiteCowView.addMilkButtonListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String milkResult = whiteCowModel.produceMilk();
                            if (milkResult == "Soy Milk (BSOD)") {
                                whiteCowModel.setBSOD();
                            }
                            if (whiteCowModel.isBSOD()) {
                                whiteCowView.showMessage(milkResult + "RESET NOWWWWWW!");
                            } else {
                                whiteCowView.showMessage(milkResult);
                            }
                        }
                    });

                    // เพิ่มมะนาวให้วัวขาว
                    whiteCowView.addLemonButtonListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            whiteCowModel.addLemon();
                            whiteCowView.showMessage("Added Lemon!");
                        }
                    });
                }
            } else {
                view.showMessage("CowID not found");
            }
        }
    }

}
