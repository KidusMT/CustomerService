package project.swa.CustomerCommand.service;

import project.swa.CustomerCommand.domain.Address;

public class AddressAdapter {
    public static Address getCustomer(AddressDTO addressDTO) {
        return new Address(
                addressDTO.getStreet(),
                addressDTO.getCity(),
                addressDTO.getZip());
    }

    public static AddressDTO getCustomerDTO(Address address) {
        return new AddressDTO(
                address.getStreet(),
                address.getCity(),
                address.getZip());
    }
}
