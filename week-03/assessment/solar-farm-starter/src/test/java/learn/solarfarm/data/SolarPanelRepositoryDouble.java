package learn.solarfarm.data;

import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;

import java.util.ArrayList;
import java.util.List;

public class SolarPanelRepositoryDouble implements SolarPanelRepository {
    private final ArrayList<SolarPanel> solarPanels = new ArrayList<>();

    public SolarPanelRepositoryDouble() {
        solarPanels.add(new SolarPanel(1, "Section One", 1, 1, 2020, Material.POLY_SI, true));
        solarPanels.add(new SolarPanel(2, "Section One", 1, 2, 2020, Material.POLY_SI, true));
        solarPanels.add(new SolarPanel(3, "Section Two", 10, 11, 2000, Material.A_SI, false));
    }

    @Override
    public List<SolarPanel> findBySection(String section) throws DataAccessException {
        ArrayList<SolarPanel> result = new ArrayList<>();
        for (SolarPanel sp : solarPanels) {
            if (sp.getSection().equalsIgnoreCase(section)) {
                result.add(sp);
            }
        }
        return result;
    }

    @Override
    public SolarPanel findByKey(String section, int row, int column) throws DataAccessException {
        for (SolarPanel sp : solarPanels) {
            if (sp.isMatch(section, row, column)) {
                return sp;
            }
        }
        return null;
    }
    @Override
    public SolarPanel findById(int id) throws DataAccessException {
        for (SolarPanel sp : solarPanels) {
            if (sp.getId() == id) {
                return sp;
            }
        }
        return null;
    }

    @Override
    public SolarPanel create(SolarPanel solarPanel) throws DataAccessException {
        return solarPanel;
        //poor example, create method should add the input object to the list.
    }


    // TODO: add an update method (must match with interface)
    @Override
    public SolarPanel update(int oldId, SolarPanel newSolarPanel) throws DataAccessException {
        return newSolarPanel;
    }

    // TODO: add a delete method (must match with interface)
    @Override
    public boolean deleteById(int id) throws DataAccessException {
        //straight up implementing it should work, but I'm very curious of how to implement the test "short cut", the same manner as update and create.
//        if (findById(id) != null) {
//            solarPanels.remove(findById(id));
//            return true;
//        }
//        Maybe something like that?

        SolarPanel panelToRemove = null;
        for (SolarPanel sp : solarPanels) {
            if (sp.getId() == id) {
                panelToRemove = sp;
                break;
            }
        }
        if (panelToRemove != null) {
            solarPanels.remove(panelToRemove);
            return true; // Panel successfully deleted.
        }

        return false;
    }




}
