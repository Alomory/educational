package educational.c3043.project.s62079.frame;

import educational.c3043.project.s62079.core.Account;
import educational.c3043.project.s62079.core.Admin;
import educational.c3043.project.s62079.core.Customer;
import educational.c3043.project.s62079.exception.LazyException;
import educational.c3043.project.s62079.component.LoginPanel;
import educational.c3043.project.s62079.component.RegisterPanel;
import educational.c3043.project.s62079.component.RemoverPanel;

import javax.swing.*;

public class AccountInfo extends AppPanel {
    LoginPanel login = new LoginPanel();
    RegisterPanel register = new RegisterPanel();
    RemoverPanel accounts = new RemoverPanel();
    JButton update, back;

    public AccountInfo() {
        login.setHeader("Account Info");
        login.setUsername(session.getUsername());
        login.setPassword(session.getPassword());

        if (session instanceof Admin) { // Customer can manage their own data
            Admin genius = (Admin) session;

            accounts.setHeader("Manage Users");
            accounts.setList(genius.getAccounts().stream().map(Account::getUsername).toArray());
            accounts.addListEvent(ae -> {
                String select = (String) accounts.getSelected();
                accounts.setDetails(select == null ? "" : Account.getAccount(select).toString());
                app.flush();
            });
            accounts.addRemoveEvent(ae -> {
                try {
                    Object select = accounts.getSelected();
                    if (select == null) throw new LazyException("Nobody to execute :<");
                    if (select.toString().equals(genius.getUsername())) throw new LazyException("No u");
                    genius.removeAccount(select.toString());
                    successDialog("User executed.");
                    setPanel();
                } catch (LazyException e) {
                    errorDialog(e);
                }
            });

            String select = (String) accounts.getSelected();
            accounts.setDetails(select == null ? "" : Account.getAccount(select).toString());

            register.setVisible(false);
        } else { // Admin can delete any account (except itself)
            Customer dummy = (Customer) session;

            register.setHeader("Personal Info");
            register.setIC(dummy.getIC());
            register.setName(dummy.getName());
            register.setAddress(dummy.getAddress());
            register.setPhone(dummy.getPhone());
            register.setEmail(dummy.getEmail());
            register.showBirthdate(true);
            register.setBirthdate();

            accounts.setVisible(false);
        }

        update = new JButton("Update");
        update.addActionListener(ae -> {
            String username = login.getUsername(), ic = register.getIC();
            try {
                if (!session.getUsername().equals(username)) session.setUsername(username);
                session.setPassword(login.getPassword());
                if (session instanceof Customer) {
                    Customer dummy = (Customer) session;
                    if (!dummy.getIC().equals(ic)) dummy.setIC(ic);
                    dummy.setName(register.getName());
                    dummy.setAddress(register.getAddress());
                    dummy.setPhone(register.getPhone());
                    dummy.setEmail(register.getEmail());
                }
                successDialog("Info updated successfully.");
                setPanel();
            } catch (LazyException e) {
                errorDialog(e);
            }
        });

        back = new JButton("Back");
        back.addActionListener(ae -> Menu.setPanel());

        JPanel action = new JPanel();
        GroupLayout actionLayout = new GroupLayout(action);
        action.setLayout(actionLayout);
        actionLayout.setAutoCreateGaps(true);
        actionLayout.setHorizontalGroup(actionLayout.createSequentialGroup()
                .addComponent(update)
                .addComponent(back)
        );
        actionLayout.setVerticalGroup(actionLayout.createSequentialGroup()
                .addGroup(actionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(update)
                        .addComponent(back))
        );

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(accounts)
                        .addComponent(login)
                        .addComponent(register)
                        .addComponent(action))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(accounts)
                .addGap(20)
                .addComponent(login)
                .addComponent(register)
                .addComponent(action)
        );
    }

    public static void setPanel() {
        app.setPanel(new AccountInfo());
    }
}
