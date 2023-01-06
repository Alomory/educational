package educational.c3043.project.s62079.frame;

import educational.c3043.project.s62079.core.Access;
import educational.c3043.project.s62079.core.Admin;
import educational.c3043.project.s62079.core.Customer;
import educational.c3043.project.s62079.exception.LazyException;
import educational.c3043.project.s62079.component.AdderPanel;
import educational.c3043.project.s62079.component.RemoverPanel;

import javax.swing.*;
import java.util.List;

public class AccessInfo extends AppPanel {
    RemoverPanel
            demolisher = new RemoverPanel(),
            accesses = new RemoverPanel();
    AdderPanel constructor = new AdderPanel();
    JButton back;

    public AccessInfo() {
        demolisher.setHeader("Manage Facility");
        demolisher.setList(Access.getFacilities().toArray());
        demolisher.addRemoveEvent(ae -> {
            try {
                Object select = demolisher.getSelected();
                if (select == null) throw new LazyException("Nothing to remove :(");
                Access.removeFacilities(demolisher.getSelectedIndex());
                successDialog("Facility demolished.");
                setPanel();
            } catch (LazyException e) {
                errorDialog(e);
            }
        });
        demolisher.showDetails(false);

        constructor.addAddEvent(ae -> {
            try {
                Access.addFacilities(constructor.getField());
                successDialog("Facility Added.");
                setPanel();
            } catch (LazyException e) {
                errorDialog(e);
            }
        });
        constructor.showArea(false);

        if (session instanceof Admin) {
            Admin genius = (Admin) session;

            accesses.setHeader("Manage Access");
            accesses.setList(genius.getCustomers().stream().map(Customer::getAccesses).flatMap(List::stream).toArray());
            accesses.addRemoveEvent(ae -> {
                try {
                    Object select = accesses.getSelected();
                    if (select == null) throw new LazyException("Nothing to remove :(");
                    ((Access) select).delete();
                    setPanel();
                } catch (LazyException e) {
                    errorDialog(e);
                }
            });
        } else {
            Customer dummy = (Customer) session;

            accesses.setHeader("Access History");
            accesses.setList(dummy.getAccesses().toArray());
            accesses.showRemove(false);

            constructor.setVisible(false);
            demolisher.setVisible(false);
        }
        accesses.showDetails(false);

        back = new JButton("Back");
        back.addActionListener(ae -> Menu.setPanel());

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(demolisher)
                        .addComponent(constructor)
                        .addComponent(accesses)
                        .addComponent(back))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(demolisher)
                .addComponent(constructor)
                .addGap(20)
                .addComponent(accesses)
                .addGap(20)
                .addComponent(back));
    }

    public static void setPanel() {
        app.setPanel(new AccessInfo());
    }
}
