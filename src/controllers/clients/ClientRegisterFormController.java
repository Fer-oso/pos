package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import entitys.CreditCard;
import services.ClientServiceImp;
import views.clients.ClientRegisterFormView;

public class ClientRegisterFormController extends MouseAdapter implements ActionListener {

    private final ClientRegisterFormView clientRegisterFormView;

    private final ClientServiceImp clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Client> listClients;
    private Client client;

    /*Constructors*/
    
    public ClientRegisterFormController(ClientRegisterFormView clientRegisterFormView, ClientServiceImp clientServiceImp) {

        this.clientRegisterFormView = clientRegisterFormView;

        this.clientServiceImp = clientServiceImp;

        listClients();

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

            createNewClient();

            save();

            refreshTable();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientRegisterFormView.getBtnCancel()) {

            clearForm();
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
    private void createNewClient() {

        String name = clientRegisterFormView.getTxtName().getText();

        String lastName = clientRegisterFormView.getTxtLastname().getText();

        Integer age = Integer.valueOf(clientRegisterFormView.getTxtAge().getText());

        boolean availability = clientRegisterFormView.getJcbAvailability().isSelected();

        Integer ssn = Integer.valueOf(clientRegisterFormView.getTxtSsn().getText());

        String phoneNumber = clientRegisterFormView.getTxtPhone().getText();

        client = new Client(name, lastName, age, ssn, availability, phoneNumber, new CreditCard());
    }

    private Client save() {

        return clientServiceImp.save(client);
    }

    private void listClients() {

        listClients = clientServiceImp.findAll();

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

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;

        }
    }
}
