package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import entitys.CreditCard;
import services.ClientServiceImp;
import views.clients.ClientRegisterForm;

public class ClientRegisterFormController extends MouseAdapter implements ActionListener {

    private final ClientRegisterForm clientRegisterForm;

    private final ClientServiceImp clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();

    private List<Client> listClients = new ArrayList<>();

    private Client client;

    /*Constructors*/
    public ClientRegisterFormController(ClientRegisterForm clientRegisterForm, ClientServiceImp clientServiceImp) {

        this.clientRegisterForm = clientRegisterForm;

        this.clientServiceImp = clientServiceImp;

        listClients();

        addACtionsListeners();

    }

    /*Actions*/
    private void addACtionsListeners() {

        clientRegisterForm.getJtTableClients().addMouseListener(this);

        clientRegisterForm.getBtnSave().addActionListener(this);

        clientRegisterForm.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientRegisterForm.getBtnSave()) {

            createNewClient();

            save();

            refreshTable();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientRegisterForm.getBtnCancel()) {

            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientRegisterForm.getJtTableClients()) {

            getClientSelectedOfTable();

            setFormWithSelectedClient();
        }
    }

    /*Functions*/
    private void createNewClient() {

        String name = clientRegisterForm.getTxtName().getText();

        String lastName = clientRegisterForm.getTxtLastname().getText();

        Integer age = Integer.valueOf(clientRegisterForm.getTxtAge().getText());

        boolean availability = clientRegisterForm.getJcbAvailability().isSelected();

        Integer ssn = Integer.valueOf(clientRegisterForm.getTxtSsn().getText());

        String phoneNumber = clientRegisterForm.getTxtPhone().getText();
        //int id = Integer.parseInt(clientRegisterForm.getLblId().getText());

        client = new Client(name, lastName, age, ssn, availability, phoneNumber, new CreditCard());

    }

    private Client save() {

        return clientServiceImp.save(client);
    }

    private void listClients() {

        listClients = clientServiceImp.findAll();

        model = (DefaultTableModel) clientRegisterForm.getJtTableClients().getModel();

        for (var cl : listClients) {

            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};

            model.addRow(clientObject);
        }

        this.clientRegisterForm.getJtTableClients().setModel(model);

    }

    private void getClientSelectedOfTable() {

        int row = clientRegisterForm.getJtTableClients().getSelectedRow();

        client = listClients.get(row);

    }

    private void setFormWithSelectedClient() {

        clientRegisterForm.getLblId().setText(String.valueOf(client.getId()));

        clientRegisterForm.getTxtName().setText(client.getName());

        clientRegisterForm.getTxtLastname().setText(String.valueOf(client.getLastName()));

        clientRegisterForm.getTxtAge().setText(String.valueOf(client.getAge()));

        checkAvailability();

        clientRegisterForm.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientRegisterForm.getTxtPhone().setText(client.getPhoneNumber());
    }

    private void checkAvailability() {

        if (client.isAvailability()) {

            this.clientRegisterForm.getJcbAvailability().setSelected(true);

        } else {

            this.clientRegisterForm.getJcbAvailability().setSelected(false);

        }
    }

    private void clearForm() {

        clientRegisterForm.getLblId().setText("");

        clientRegisterForm.getTxtName().setText("");

        clientRegisterForm.getTxtLastname().setText("");

        clientRegisterForm.getTxtAge().setText("");

        checkAvailability();

        clientRegisterForm.getTxtSsn().setText("");

        clientRegisterForm.getTxtPhone().setText("");

    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;

        }

    }

}
