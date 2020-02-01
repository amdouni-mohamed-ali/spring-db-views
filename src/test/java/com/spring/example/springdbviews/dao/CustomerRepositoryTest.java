package com.spring.example.springdbviews.dao;

import com.spring.example.springdbviews.entity.Account;
import com.spring.example.springdbviews.entity.Address;
import com.spring.example.springdbviews.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Transactional
    public void globalTest() {

        List<Customer> customers = customerRepository.findAll();
        assertThat(customers).isNotNull();
        assertThat(customers).hasSize(3);
        assertThat(customers.get(0).getId()).isEqualTo(1);
        assertThat(customers.get(1).getId()).isEqualTo(2);
        assertThat(customers.get(2).getId()).isEqualTo(3);

        //Test of the customer address
        Address address = new Address()
                .setBuilding("building11")
                .setCountry("country11")
                .setFirstName("first1")
                .setStreet("street11");
        assertThat(customerRepository.findById(1).isPresent()).isTrue();
        assertThat(customerRepository.findById(1).get().getAddress()).isEqualTo(address);

        List<Account> accounts = customerRepository.findById(1).get().getAccounts();
        assertThat(accounts).isNotNull();
        assertThat(accounts).hasSize(3);
        assertThat(accounts.get(0).getFirstName()).isEqualTo("first1");
        assertThat(accounts.get(1).getFirstName()).isEqualTo("first1");
        assertThat(accounts.get(2).getFirstName()).isEqualTo("first1");
    }
}
