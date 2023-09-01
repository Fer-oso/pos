package controllers.clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import entitys.Client;
import services.ClientServiceImp;
import views.clients.ClientFindBySsnView;

public class ClientFindBySsnController extends MouseAdapter implements ActionListener {

    private final ClientFindBySsnView clientFindBySsnView;

    private final ClientServiceImp clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Client> listClients;
    private int row;
    private int id;
    private Client client;

    /*Constructors*/
    public ClientFindBySsnController(ClientFindBySsnView clientFindBySsnView, ClientServiceImp clientServiceImp) {

        this.clientFindBySsnView = clientFindBySsnView;

        this.clientServiceImp = clientServiceImp;

        this.listClients = clientServiceImp.findAll();

        listClients();

        addActionsListeners();
    }

    /*Actions*/
    private void addActionsListeners() {

        clientFindBySsnView.getJtTableClients().addMouseListener(this);

        clientFindBySsnView.getBtnSearch().addActionListener(this);

        clientFindBySsnView.getBtnEdit().addActionListener(this);

        clientFindBySsnView.getBtnDelete().addActionListener(this);

        clientFindBySsnView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientFindBySsnView.getBtnSearch()) {

            refreshTable();

            listClients = findBySsn();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindBySsnView.getBtnEdit()) {

            editClient();

            refreshTable();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindBySsnView.getBtnDelete()) {

            deleteClient();

            refreshTable();

            listClients();

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindBySsnView.getBtnCancel()) {

            clearForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientFindBySsnView.getJtTableClients()) {

            getClientSelectedOfTable();

            setFormWithSelectedClient(client);
        }
    }

    /*Functions*/
    private void listClients() {

        model = (DefaultTableModel) this.clientFindBySsnView.getJtTableClients().getModel();

        for (Client cl : this.listClients) {

            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};

            model.addRow(clientObject);
        }

        this.clientFindBySsnView.getJtTableClients().setModel(model);
    }

    private List<Client> findBySsn() {

        int ssn = Integer.parseInt(this.clientFindBySsnView.getTxtSearch().getText());

        Client optionalClient = clientServiceImp.findBySsn(ssn).get();

        listClients = new ArrayList<>();

        listClients.add(optionalClient);

        return listClients;
    }

    private Client editClient() {

        setClientwithDataOfForm();

        return clientServiceImp.update(row, client);
    }

    private void deleteClient() {

        clientServiceImp.delete(id);
    }

    private void getClientSelectedOfTable() {

        row = clientFindBySsnView.getJtTableClients().getSelectedRow();

        client = listClients.get(row);
        
        id = client.getId();
    }

    private void setClientwithDataOfForm() {

        client.setName(clientFindBySsnView.getTxtName().getText());

        client.setLastName(clientFindBySsnView.getTxtLastName().getText());

        client.setAge(Integer.valueOf(clientFindBySsnView.getTxtAge().getText()));

        client.setAvailability(clientFindBySsnView.getJcbAvailability().isSelected());

        client.setSsn(Integer.valueOf(clientFindBySsnView.getTxtSsn().getText()));

        client.setPhoneNumber(clientFindBySsnView.getTxtPhone().getText());
    }

    private void setFormWithSelectedClient(Client client) {

        clientFindBySsnView.getLblId().setText(String.valueOf(client.getId()));

        clientFindBySsnView.getTxtName().setText(client.getName());

        clientFindBySsnView.getTxtLastName().setText(String.valueOf(client.getLastName()));

        clientFindBySsnView.getTxtAge().setText(String.valueOf(client.getAge()));

        checkAvailability();

        clientFindBySsnView.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientFindBySsnView.getTxtPhone().setText(client.getPhoneNumber());
    }

    private void checkAvailability() {

        if (client.isAvailability()) {

            clientFindBySsnView.getJcbAvailability().setSelected(true);

        } else {

            clientFindBySsnView.getJcbAvailability().setSelected(false);
        }
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    private void clearForm() {

        clientFindBySsnView.getLblId().setText("");

        clientFindBySsnView.getTxtName().setText("");

        clientFindBySsnView.getTxtLastName().setText("");

        clientFindBySsnView.getTxtAge().setText("");

        clientFindBySsnView.getJcbAvailability().setSelected(false);

        clientFindBySsnView.getTxtSsn().setText("");

        clientFindBySsnView.getTxtPhone().setText("");
    }

}
