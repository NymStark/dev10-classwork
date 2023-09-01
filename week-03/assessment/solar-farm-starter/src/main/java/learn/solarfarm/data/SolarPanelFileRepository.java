package learn.solarfarm.data;

import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SolarPanelFileRepository implements SolarPanelRepository {
    private final String filePath;
    private final String delimiter = "~";

    public SolarPanelFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<SolarPanel> findBySection(String section) throws DataAccessException {
        ArrayList<SolarPanel> result = new ArrayList<>();
        for (SolarPanel solarPanel : findAll()) {
            if (solarPanel.getSection().equalsIgnoreCase(section)) {
                result.add(solarPanel);
            }
        }
        return result;
    }

    @Override
    public SolarPanel findByKey(String section, int row, int column) throws DataAccessException {
        List<SolarPanel> all = findAll();
        for (SolarPanel solarPanel : all) {
            if (solarPanel.isMatch(section, row, column)) {
                return solarPanel;
            }
        }
        return null;
    }

    // implementing findById method.
    @Override
    public SolarPanel findById(int id) throws DataAccessException {
        List<SolarPanel> all = findAll();
        for (SolarPanel solarPanel : all) {
            if (solarPanel.getId() == id) {
                return solarPanel;
            }
        }
        return null;
    }

    @Override
    public SolarPanel create(SolarPanel solarPanel) throws DataAccessException {
        List<SolarPanel> all = findAll();
        int nextId = getNextId(all);
        solarPanel.setId(nextId);
        all.add(solarPanel);
        writeToFile(all);
        return solarPanel;
    }

    // TODO: add an update method (must match with interface)
    // Update takes an argument of a SolarPanel object, looks for the id of that object, then update
    @Override
    public SolarPanel update(int oldId, SolarPanel newSolarPanel) throws DataAccessException {
//        List<SolarPanel> all = findAll();
//        SolarPanel existingSolarPanel = findById(oldId); //leveraging findById
//        if (existingSolarPanel != null){
//            newSolarPanel.setId(oldId);
//            all.set(oldId, newSolarPanel);
//            writeToFile(all);
//            return newSolarPanel;
//        }
        // this is throwing out of bound errors while the other one is accurate, I am not sure why.

        List<SolarPanel> all = findAll(); // Load all solar panels from the file.
        for (int i = 0; i < all.size(); i++) {
            SolarPanel sp = all.get(i); // Gets one from the list
            newSolarPanel.setId(oldId); // sets the Id of the new solar panel
            if (sp.getId() == oldId) { //checks if the solarPanelId is the same as the updated panel.
                all.set(i, newSolarPanel); //replace the solar panel at index i with solarpanel object, done by the set(index, element) method of ArrayList<>();
                writeToFile(all);//rewrite
                return newSolarPanel;
            }
        }
        return null; // If the panel with the specified ID is not found.
    }


    // TODO: add a delete method (must match with interface)
    @Override
    public boolean deleteById(int id) throws DataAccessException {
        List<SolarPanel> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == id) {
                all.remove(i); // Remove the panel with the specified ID from the list.
                writeToFile(all);
                return true; // Return true to indicate successful deletion.
            }
        }
        return false; // Else false
    }


    private List<SolarPanel> findAll() throws DataAccessException {
        ArrayList<SolarPanel> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                SolarPanel sp = lineToSolarPanel(line);
                if (sp != null) {
                    result.add(sp);
                }
            }
        } catch (FileNotFoundException ex) {
            // If the file doesn't exist, no big deal.
            // We'll create it when we add a new solar panel.
            // No file just means no solar panels yet.
        } catch (IOException ex) {
            throw new DataAccessException("Could not open the file path: " + filePath, ex);
        }
        return result;
    }

    private int getNextId(List<SolarPanel> solarPanels) {
        int maxId = 0;
        for (SolarPanel solarPanel : solarPanels) {
            if (maxId < solarPanel.getId()) {
                maxId = solarPanel.getId();
            }
        }
        return maxId + 1;
    }

    private void writeToFile(List<SolarPanel> solarPanels) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (SolarPanel solarPanel : solarPanels) {
                writer.println(solarPanelToLine(solarPanel));
            }
        } catch (IOException ex) {
            throw new DataAccessException("Could not write to file path: " + filePath, ex);
        }
    }

    private SolarPanel lineToSolarPanel(String line) {
        String[] fields = line.split(delimiter);

        if (fields.length != 7) {
            return null;
        }

        return new SolarPanel(
                Integer.parseInt(fields[0]),
                fields[1],
                Integer.parseInt(fields[2]),
                Integer.parseInt(fields[3]),
                Integer.parseInt(fields[4]),
                Material.valueOf(fields[5]),
                "true".equals(fields[6])
        );
    }

    private String solarPanelToLine(SolarPanel solarPanel) {
        StringBuilder buffer = new StringBuilder(100);
        buffer.append(solarPanel.getId()).append(delimiter);
        buffer.append(cleanField(solarPanel.getSection())).append(delimiter);
        buffer.append(solarPanel.getRow()).append(delimiter);
        buffer.append(solarPanel.getColumn()).append(delimiter);
        buffer.append(solarPanel.getYearInstalled()).append(delimiter);
        buffer.append(solarPanel.getMaterial()).append(delimiter);
        buffer.append(solarPanel.isTracking());
        return buffer.toString();
    }

    private String cleanField(String field) {
        // If the file delimiter, a carriage return, or a newline was written to the file,
        // it would ruin our ability to read the solar panel.
        // Here, we insure those characters don't end up in the file.
        return field.replace(delimiter, "")
                .replace("/r", "")
                .replace("/n", "");
    }
}
