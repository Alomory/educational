package educational.lib;

import javax.swing.*;
import java.awt.*;

public abstract class ModuleTester extends JFrame {
    JPanel
            modulePanel = new JPanel(),
            activityPanel = new JPanel();
    public JComboBox<String>
            moduleBox = new JComboBox<>(),
            activityBox = new JComboBox<>();

    public ModuleTester() {
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        modulePanel.add(new JLabel("Lab Module"));
        modulePanel.add(moduleBox);
        container.add(modulePanel);

        activityPanel.add(new JLabel("Activity"));
        activityPanel.add(activityBox);
        container.add(activityPanel);

        setSize(400, 200);
        setVisible(true);
    }
}
