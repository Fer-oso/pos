package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import entitys.CreditCard;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import services.ClientServiceImp;
import views.clients.ClientRegisterFormView;

public class ClientRegisterFormController extends MouseAdapter implements ActionListener, Serializable {

    private static final long serialVersionUID = 1L;

    private final ClientRegisterFormView clientRegisterFormView;

    private final ClientServiceImp clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Client> listClients;
    private Client client;

    /*Constructors*/
    public ClientRegisterFormController(ClientRegisterFormView clientRegisterFormView, ClientServiceImp clientServiceImp) {

        this.clientRegisterFormView = clientRegisterFormView;

        this.clientServiceImp = clientServiceImp;

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        clientRegisterFormView.getJtTableClients().addMouseListener(this);

        clientRegisterFormView.getBtnSave().addActionListener(this);

        clientRegisterFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientRegisterFormView.getBtnSave()) {

            if (createNewClient()) {

                save();

                clearForm();

                refreshTable();

                listClients();
            }

            System.out.println(listClients);
        }

        if (e.getSource() == clientRegisterFormView.getBtnCancel()) {

            clearForm();

            refreshTable();

            listClients = clientServiceImp.findAll();

            listClients();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientRegisterFormView.getJtTableClients()) {

            getClientSelectedOfTable();

            setFormWithSelectedClient();
        }
    }

    /*Functions*/
    private boolean createNewClient() {

        if (clientRegisterFormView.getTxtName().getText().equals("") || clientRegisterFormView.getTxtLastname().getText().equals("")
                || clientRegisterFormView.getTxtAge().getText().equals("") || clientRegisterFormView.getTxtSsn().getText().equals("") || clientRegisterFormView.getTxtPhone().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "All fields required");

            return false;
        }

        String name = clientRegisterFormView.getTxtName().getText();

        String lastName = clientRegisterFormView.getTxtLastname().getText();

        Integer age = Integer.valueOf(clientRegisterFormView.getTxtAge().getText());

        boolean availability = clientRegisterFormView.getJcbAvailability().isSelected();

        Integer ssn = Integer.valueOf(clientRegisterFormView.getTxtSsn().getText());

        String phoneNumber = clientRegisterFormView.getTxtPhone().getText();

        client = new Client(name, lastName, age, ssn, availability, phoneNumber, new CreditCard());

        return true;
    }

    private Client save() {

        return clientServiceImp.save(client);
    }

    public void listClients() {

        this.listClients = clientServiceImp.findAll();

        model = (DefaultTableModel) clientRegisterFormView.getJtTableClients().getModel();

        this.clientRegisterFormView.getJtTableClients().setModel(model);

        for (var cl : listClients) {

            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};

            model.addRow(clientObject);
        }
    }

    private void getClientSelectedOfTable() {

        int row = clientRegisterFormView.getJtTableClients().getSelectedRow();

        client = listClients.get(row);
    }

    private void setFormWithSelectedClient() {

        clientRegisterFormView.getLblId().setText(String.valueOf(client.getId()));

        clientRegisterFormView.getTxtName().setText(client.getName());

        clientRegisterFormView.getTxtLastname().setText(String.valueOf(client.getLastName()));

        clientRegisterFormView.getTxtAge().setText(String.valueOf(client.getAge()));

        checkAvailability();

        clientRegisterFormView.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientRegisterFormView.getTxtPhone().setText(client.getPhoneNumber());
    }

    private void checkAvailability() {

        if (client.isAvailability()) {

            this.clientRegisterFormView.getJcbAvailability().setSelected(true);

        } else {

            this.clientRegisterFormView.getJcbAvailability().setSelected(false);
        }
    }

    private void clearForm() {

        clientRegisterFormView.getLblId().setText("");

        clientRegisterFormView.getTxtName().setText("");

        clientRegisterFormView.getTxtLastname().setText("");

        clientRegisterFormView.getTxtAge().setText("");

        checkAvailability();

        clientRegisterFormView.getTxtSsn().setText("");

        clientRegisterFormView.getTxtPhone().setText("");
    }

    public void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;

        }
    }
}
