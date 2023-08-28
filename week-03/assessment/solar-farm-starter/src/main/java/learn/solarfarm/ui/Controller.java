package learn.solarfarm.ui;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;

import java.util.List;

public class Controller {
    private final View view;
    private final SolarPanelService service;

    public Controller(View view, SolarPanelService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        view.displayHeader("Welcome to Solar Farm");
        try {
            runApp();
        } catch (DataAccessException ex) {
            view.displayErrors(List.of(ex.getMessage()));
        }
        view.displayMessage("Goodbye!");
    }

    private void runApp() throws DataAccessException {
        for (int option = view.chooseMenuOption();
             option > 0;
             option = view.chooseMenuOption()) {

            switch (option) {
                case 1:
                    findSolarPanelsBySection();
                    break;
                case 2:
                    addSolarPanel();
                    break;
                case 3:
                    updateSolarPanel();
                    break;
                case 4:
                    deleteSolarPanel();
                    break;
            }
        }
    }

    private void findSolarPanelsBySection() throws DataAccessException {
        view.displayHeader("Find Panels by Section");
        String section = view.getSection();
        List<SolarPanel> solarPanels = service.findBySection(section);
        if (solarPanels.isEmpty()) {
            view.displayMessage("There are no panels in this section.");
        } else {
            view.displaySolarPanels(section, solarPanels);
        }
    }

    private void addSolarPanel() throws DataAccessException {
        SolarPanel solarPanel = view.addSolarPanel();
        SolarPanelResult result = service.create(solarPanel);
        if (result.isSuccess()) {
            view.displayMessage("[Success]%nPanel %s added.", result.getSolarPanel().getKey());
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }

    private void updateSolarPanel() throws DataAccessException {
        // TODO: grab the section, row, and column from the view.
        // TODO: use the service to fetch a solar panel by its key (section, row, column).
        // TODO: complete update
        String section = view.getSection();
        int row = view.getRow();
        int column = view.getColumn();

        SolarPanel existingPanel = service.findByKey(section, row, column);

        if (existingPanel == null) {
            view.displayMessage("Solar Panel not found for the specified key.");
            return;
        }
        view.displayMessage("Current Solar Panel Details:"); //displaying current panel info:
        view.displaySolarPanels(section, List.of(existingPanel));

        SolarPanel updatedPanel = view.updateSolarPanel();
        updatedPanel.setId(existingPanel.getId()); // Ensure the ID stays the same

        SolarPanelResult result = service.update(updatedPanel);

        if (result.isSuccess()) {
            view.displayMessage("[Success]%nPanel %s updated.", result.getSolarPanel().getKey());
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }


    private void deleteSolarPanel() throws DataAccessException {
        // Get the ID of the solar panel to delete from the view
        int panelIdToDelete = view.deleteSolarPanel();

        boolean isDeleted = service.deleteById(panelIdToDelete);

        if (isDeleted) {
            view.displayMessage("[Success] Panel with ID %d deleted.", panelIdToDelete);
        } else {
            view.displayMessage("Panel with ID %d not found or could not be deleted.", panelIdToDelete);
        }
    }

}
