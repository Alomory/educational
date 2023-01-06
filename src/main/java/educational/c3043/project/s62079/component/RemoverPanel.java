package educational.c3043.project.s62079.component;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RemoverPanel extends ComponentPanel {
    JComboBox<Object> list = new JComboBox<>();
    JButton remove = new JButton("Remove");
    JTextArea details = new JTextArea();

    public RemoverPanel() {
        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(header)
                                .addComponent(list))
                        .addComponent(remove))
                .addComponent(details)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(header)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(list)
                        .addComponent(remove))
                .addComponent(details)
        );

        details.setEditable(false);
    }

    public Object getSelected() {
        return list.getSelectedItem();
    }
    
    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }

    public void setList(Object[] objects) {
        for (Object o : objects) list.addItem(o);
    }

    public void setRemove(String t) {
        remove.setText(t);
    }

    public void setDetails(String t) {
        details.setText(t);
    }

    public void addListEvent(ActionListener e) {
        list.addActionListener(e);
    }

    public void addRemoveEvent(ActionListener e) {
        remove.addActionListener(e);
    }

    public void showRemove(boolean flag) {
        remove.setVisible(flag);
    }

    public void showDetails(boolean flag) {
        details.setVisible(flag);
    }
}
