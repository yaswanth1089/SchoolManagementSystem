

import com.school.service.Managementservice;
import com.school.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {
        Managementservice engine = new Managementservice();

        // Auto-load past session data records from students.txt if they exist
        engine.loadAllData();

        // Fire up the user terminal engine loop
        ConsoleMenu.startMenu(engine);
    }
}

