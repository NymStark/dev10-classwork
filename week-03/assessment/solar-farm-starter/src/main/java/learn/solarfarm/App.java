package learn.solarfarm;

import learn.solarfarm.data.SolarPanelFileRepository;
import learn.solarfarm.data.SolarPanelRepository;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.ui.ConsoleIO;
import learn.solarfarm.ui.Controller;
import learn.solarfarm.ui.View;

public class App {
    public static void main(String[] args) {
        try {
            // Create the dependencies
            SolarPanelRepository repository = new SolarPanelFileRepository("./data/solarfarm.txt");
            SolarPanelService service = new SolarPanelService(repository);
            View view = new View(new ConsoleIO()); // You can pass an instance of ConsoleIO or any other TextIO implementation.

            // Create the controller and run the application
            Controller controller = new Controller(view, service);
            controller.run();
        } catch (Exception ex) {
            // Handle exceptions here
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }
}