package Model;

import java.util.Random;

public class BrownCowModel {
    private boolean isBSOD = false; // สถานะ BSOD
    private int ageInYears;

    public BrownCowModel(int ageInYears) {
        this.ageInYears = ageInYears;
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
        Random random = new Random();
        double chance = 1.0 * ageInYears; // โอกาสเป็นเปอร์เซ็นต์
        if (random.nextDouble() * 100 < chance) {
            this.isBSOD = true;
            return "Almond Milk (BSOD)";
        }
        return "Chocolate Milk";
    }
}
