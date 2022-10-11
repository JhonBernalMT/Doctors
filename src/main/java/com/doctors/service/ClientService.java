package com.doctors.service;

import com.doctors.model.ClientModel;
import com.doctors.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients() {
        return clientRepository.getAllClients();
    }

    public Optional<ClientModel> getClient(Integer id) {
        return clientRepository.getClient(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        return clientRepository.saveClient(clientModel);
    }

    public ClientModel updateClient(ClientModel clientModel){
        return clientRepository.updateClient(clientModel);
    }

    public boolean deleteClient(Integer id){
        return clientRepository.deleteClient(id);
    }
}


