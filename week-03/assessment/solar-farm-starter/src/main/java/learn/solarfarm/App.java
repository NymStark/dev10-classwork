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
            SolarPanelRepository repository = new SolarPanelFileRepository("./data/solarfarm-app.txt"); //this is our database.
            SolarPanelService service = new SolarPanelService(repository); //Initializing service
            View view = new View(new ConsoleIO()); // passing an instance of ConsoleIO

            // Create the controller and run the application
            Controller controller = new Controller(view, service);
            controller.run();
        } catch (Exception e) {
            // Handle exceptions here
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}