package educational.c3043.project.s62079.component;

import educational.c3043.project.s63683.BirthDate;

import javax.swing.*;

public class RegisterPanel extends ComponentPanel {
    JLabel icLabel, nameLabel, addressLabel, phoneLabel, emailLabel, birthdateLabel;
    JTextField ic, name, address, phone, email, birthdate;
    
    public RegisterPanel() {
        icLabel = new JLabel("IC");
        ic = new JTextField(30);
        nameLabel = new JLabel("Name");
        name = new JTextField();
        addressLabel = new JLabel("Address");
        address = new JTextField();
        phoneLabel = new JLabel("Phone");
        phone = new JTextField();
        emailLabel = new JLabel("Email");
        email = new JTextField();
        birthdateLabel = new JLabel("Birth Date");
        birthdate = new JTextField();
        birthdate.setEditable(false);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(header)
                        .addComponent(icLabel)
                        .addComponent(nameLabel)
                        .addComponent(addressLabel)
                        .addComponent(phoneLabel)
                        .addComponent(emailLabel)
                        .addComponent(birthdateLabel))
                .addGroup(layout.createParallelGroup()
                        .addComponent(ic)
                        .addComponent(name)
                        .addComponent(address)
                        .addComponent(phone)
                        .addComponent(email)
                        .addComponent(birthdate))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(header)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(icLabel)
                        .addComponent(ic))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(name))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addressLabel)
                        .addComponent(address))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneLabel)
                        .addComponent(phone))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailLabel)
                        .addComponent(email))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(birthdateLabel)
                        .addComponent(birthdate))
        );
    }

    public String getIC() {
        return ic.getText();
    }

    public void setIC(String t) {
        ic.setText(t);
    }

    public String getName() {
        return name.getText();
    }

    public void setName(String t) {
        name.setText(t);
    }

    public void setBirthdate() {
        birthdate.setText(new BirthDate(getIC()).toString());
    }
    
    public String getAddress() {
        return address.getText();
    }

    public void setAddress(String t) {
        address.setText(t);
    }
    
    public String getPhone() {
        return phone.getText();
    }

    public void setPhone(String t) {
        phone.setText(t);
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(String t) {
        email.setText(t);
    }
    
    public void clear() {
        setIC("");
        setName("");
        setAddress("");
        setPhone("");
        setEmail("");
    }
    
    public void showBirthdate(boolean flag) {
        birthdateLabel.setVisible(flag);
        birthdate.setVisible(flag);
    }
}
