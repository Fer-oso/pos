package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import services.ClientServiceImp;
import views.clients.ClientFindByNameView;

public class ClientFindByNameController extends MouseAdapter implements ActionListener {

    private final ClientFindByNameView clientFindByNameView;

    private final ClientServiceImp clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Client> listClients;
    private int row;
    private int id;
    private Client client;

    /*Constructors*/
    public ClientFindByNameController(ClientFindByNameView clientFindByNameView, ClientServiceImp clientServiceImp) {

        this.clientFindByNameView = clientFindByNameView;

        this.clientServiceImp = clientServiceImp;

        this.listClients = clientServiceImp.findAll();

        listClients();

        addActionsListeners();
    }

    /*Actions*/
    private void addActionsListeners() {

        clientFindByNameView.getJtTableClients().addMouseListener(this);

        clientFindByNameView.getBtnSearch().addActionListener(this);

        clientFindByNameView.getBtnEdit().addActionListener(this);

        clientFindByNameView.getBtnDelete().addActionListener(this);

        clientFindByNameView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientFindByNameView.getBtnSearch()) {

            refreshTable();

            listClients = findByName();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindByNameView.getBtnEdit()) {

            editClient();

            refreshTable();

            listClients();

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindByNameView.getBtnDelete()) {

            deleteClient();

            refreshTable();

            listClients();

            System.out.println(listClients);

        }

        if (e.getSource() == clientFindByNameView.getBtnCancel()) {

            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientFindByNameView.getJtTableClients()) {

            getClientSelectedOfTable();

            setFormWithSelectedClient(client);
        }
    }

    /*Functions*/
    private void listClients() {

        model = (DefaultTableModel) clientFindByNameView.getJtTableClients().getModel();

        for (Client cl : listClients) {

            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};

            model.addRow(clientObject);
        }

        this.clientFindByNameView.getJtTableClients().setModel(model);
    }

    private List<Client> findByName() {

        String clientName = clientFindByNameView.getTxtSearch().getText();

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

        row = clientFindByNameView.getJtTableClients().getSelectedRow();

        client = listClients.get(row);

        id = client.getId();
    }

    private void setClientwithDataOfForm() {

        client.setName(clientFindByNameView.getTxtName().getText());

        client.setLastName(clientFindByNameView.getTxtLastName().getText());

        client.setAge(Integer.valueOf(clientFindByNameView.getTxtAge().getText()));

        client.setAvailability(clientFindByNameView.getJcbAvailability().isSelected());

        client.setSsn(Integer.valueOf(clientFindByNameView.getTxtSsn().getText()));

        client.setPhoneNumber(clientFindByNameView.getTxtPhone().getText());

    }

    private void setFormWithSelectedClient(Client client) {

        clientFindByNameView.getLblId().setText(String.valueOf(client.getId()));

        clientFindByNameView.getTxtName().setText(client.getName());

        clientFindByNameView.getTxtLastName().setText(String.valueOf(client.getLastName()));

        clientFindByNameView.getTxtAge().setText(String.valueOf(client.getAge()));

        checkAvailability();

        clientFindByNameView.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientFindByNameView.getTxtPhone().setText(client.getPhoneNumber());

    }

    private void checkAvailability() {

        if (client.isAvailability()) {

            clientFindByNameView.getJcbAvailability().setSelected(true);

        } else {

            clientFindByNameView.getJcbAvailability().setSelected(false);

        }
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    private void clearForm() {

        clientFindByNameView.getLblId().setText("");

        clientFindByNameView.getTxtName().setText("");

        clientFindByNameView.getTxtLastName().setText("");

        clientFindByNameView.getTxtAge().setText("");

        clientFindByNameView.getJcbAvailability().setSelected(false);

        clientFindByNameView.getTxtSsn().setText("");

        clientFindByNameView.getTxtPhone().setText("");
    }

}
