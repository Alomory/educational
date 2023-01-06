package educational.c3043.project.s62079.frame;

import educational.c3043.project.s62079.core.Admin;
import educational.c3043.project.s62079.core.Customer;
import educational.c3043.project.s62079.exception.LazyException;
import educational.c3043.project.s62079.core.Report;
import educational.c3043.project.s62079.component.AdderPanel;
import educational.c3043.project.s62079.component.RemoverPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class ReportInfo extends AppPanel {
    RemoverPanel manage;
    AdderPanel create;

    public ReportInfo() {
        manage = new RemoverPanel();
        manage.setHeader("Manage Reports");
        Object[] reports = session instanceof Admin ?
                ((Admin) session).getCustomers().stream().map(Customer::getReports).flatMap(List::stream).toArray() :
                ((Customer) session).getReports().toArray();
        manage.setList(reports);
        manage.addListEvent(ae -> {
            Report select = (Report) manage.getSelected();
            manage.setDetails(select == null ? "" : select.deepToString());
            app.flush();
        });
        manage.addRemoveEvent(ae -> {
            try {
                Report select = (Report) manage.getSelected();
                if (select == null) throw new LazyException("Nothing to remove :(");
                select.delete();
                successDialog("Report removed.");
                setPanel();
            } catch (LazyException e) {
                errorDialog(e);
            }
        });
        Report select = (Report) manage.getSelected();
        manage.setDetails(select == null ? "" : select.deepToString());

        create = new AdderPanel();
        create.setHeader("Make Report");
        if (session instanceof Customer) {
            Customer dummy = (Customer) session;

            create.setLabels("Title", "Details");
            create.addAreaEvent(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent keyEvent) {
                    app.flush();
                }

                @Override
                public void keyPressed(KeyEvent keyEvent) {}

                @Override
                public void keyReleased(KeyEvent keyEvent) {}
            });
            create.addAddEvent(ae -> {
                dummy.addReport(create.getField(), create.getArea());
                successDialog("Report submitted.");
                setPanel();
            });
        } else create.setVisible(false);
        
        JButton back = new JButton("Back");
        back.addActionListener(ae -> Menu.setPanel());

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(manage)
                        .addComponent(create)
                        .addComponent(back))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(manage)
                .addComponent(create)
                .addGap(20)
                .addComponent(back)
        );
    }

    public static void setPanel() {
        app.setPanel(new ReportInfo());
    }
}
