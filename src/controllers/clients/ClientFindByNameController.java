package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import services.ClientServiceImp;
import views.clients.ClientFindByNameFormView;

public class ClientFindByNameController extends MouseAdapter implements ActionListener {

    private final ClientFindByNameFormView clientFindByNameFormView;

    private final ClientServiceImp clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Client> listClients;
    private int row;
    private int id;
    private Client client;

    /*Constructors*/
    public ClientFindByNameController(ClientFindByNameFormView clientFindByNameFormView, ClientServiceImp clientServiceImp) {

        this.clientFindByNameFormView = clientFindByNameFormView;

        this.clientServiceImp = clientServiceImp;

        this.listClients = clientServiceImp.findAll();

        listClients();

        addActionsListeners();
    }

    /*Actions*/
    private void addActionsListeners() {

        clientFindByNameFormView.getJtTableClients().addMouseListener(this);

        clientFindByNameFormView.getBtnSearch().addActionListener(this);

        clientFindByNameFormView.getBtnEdit().addActionListener(this);

        clientFindByNameFormView.getBtnDelete().addActionListener(this);

        clientFindByNameFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientFindByNameFormView.getBtnSearch()) {

            refreshTable();

            listClients = findByName();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindByNameFormView.getBtnEdit()) {

            editClient();

            refreshTable();

            listClients();

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindByNameFormView.getBtnDelete()) {

            deleteClient();

            refreshTable();

            listClients();

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindByNameFormView.getBtnCancel()) {

            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientFindByNameFormView.getJtTableClients()) {

            getClientSelectedOfTable();

            setFormWithSelectedClient(client);
        }
    }

    /*Functions*/
    private void listClients() {

        model = (DefaultTableModel) clientFindByNameFormView.getJtTableClients().getModel();

        for (Client cl : listClients) {

            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};

            model.addRow(clientObject);
        }

        this.clientFindByNameFormView.getJtTableClients().setModel(model);
    }

    private List<Client> findByName() {

        String clientName = clientFindByNameFormView.getTxtSearch().getText();

        return clientServiceImp.findByName(clientName);
    }

    private Client editClient() {

        setClientwithDataOfForm();

        return clientServiceImp.update(row, client);
    }

    private void deleteClient() {

        clientServiceImp.delete(id);
    }

    private void getClientSelectedOfTable() {

        row = clientFindByNameFormView.getJtTableClients().getSelectedRow();

        client = listClients.get(row);

        id = client.getId();
    }

    private void setClientwithDataOfForm() {

        client.setName(clientFindByNameFormView.getTxtName().getText());

        client.setLastName(clientFindByNameFormView.getTxtLastname().getText());

        client.setAge(Integer.valueOf(clientFindByNameFormView.getTxtAge().getText()));

        client.setAvailability(clientFindByNameFormView.getJcbAvailability().isSelected());

        client.setSsn(Integer.valueOf(clientFindByNameFormView.getTxtSsn().getText()));

        client.setPhoneNumber(clientFindByNameFormView.getTxtPhone().getText());

    }

    private void setFormWithSelectedClient(Client client) {

        clientFindByNameFormView.getLblId().setText(String.valueOf(client.getId()));

        clientFindByNameFormView.getTxtName().setText(client.getName());

        clientFindByNameFormView.getTxtLastname().setText(String.valueOf(client.getLastName()));

        clientFindByNameFormView.getTxtAge().setText(String.valueOf(client.getAge()));

        checkAvailability();

        clientFindByNameFormView.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientFindByNameFormView.getTxtPhone().setText(client.getPhoneNumber());

    }

    private void checkAvailability() {

        if (client.isAvailability()) {

            clientFindByNameFormView.getJcbAvailability().setSelected(true);

        } else {

            clientFindByNameFormView.getJcbAvailability().setSelected(false);

        }
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    private void clearForm() {

        clientFindByNameFormView.getLblId().setText("");

        clientFindByNameFormView.getTxtName().setText("");

        clientFindByNameFormView.getTxtLastname().setText("");

        clientFindByNameFormView.getTxtAge().setText("");

        clientFindByNameFormView.getJcbAvailability().setSelected(false);

        clientFindByNameFormView.getTxtSsn().setText("");

        clientFindByNameFormView.getTxtPhone().setText("");
    }

}
