package Model;

import java.util.Random;

public class WhiteCowModel {
    private boolean hasLemon = false; // สถานะการกินมะนาว
    private boolean isBSOD = false; // สถานะ BSOD
    private int ageInMonths;

    public WhiteCowModel(int ageInMonths) {
        this.ageInMonths = ageInMonths;
    }

    public void addLemon() {
        this.hasLemon = true;
    }

    public void resetLemon() {
        this.hasLemon = false;
    }

    public boolean hasLemon() {
        return this.hasLemon;
    }

    public boolean isBSOD() {
        return this.isBSOD;
    }

    public void setBSOD() {
        this.isBSOD = true;
    }

    public void resetBSOD() {
        this.isBSOD = false;
    }

    // คำนวณโอกาสการเกิด BSOD
    public String produceMilk() {
        if (hasLemon) {
            return "Drinking Yogurt"; // ถ้ากินมะนาวจะไม่เกิด BSOD
        } else {
            Random random = new Random();
            double chance = 0.5 * (ageInMonths % 12); // โอกาสเป็นเปอร์เซ็นต์
            if (random.nextDouble() * 100 < chance) {
                this.isBSOD = true;
                return "Soy Milk (BSOD)";
            }
            return "Plain Milk";
        }
    }
}
