package com.d288.awilliams.bootstrap;

import com.d288.awilliams.dao.CustomerRepository;
import com.d288.awilliams.dao.DivisionRepository;
import com.d288.awilliams.entities.Customer;
import com.d288.awilliams.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Division division = divisionRepository.findById(2L).orElse(null);
        if(customerRepository.count()<=1) {

            Customer steveRogers = new Customer("Steve","Rogers", "569 Leaman Place, Brooklyn", "11201", "(444)555-6666", division);
            Customer bruceBanner = new Customer("Bruce", "Banner", "570 East 6th Ave., Dayton", "45404", "(555)666-7777", division);
            Customer natashaRomanoff = new Customer("Natasha", "Romanoff", "1984 Volgograd St.", "90011", "(666)777-8888", division);
            Customer thorOdinson = new Customer("Thor", "Odinson", "111 Odin's Palace", "11122", "(777)888-9999", division);
            Customer clintBarton = new Customer("Clint", "Barton", "1102 West Rd., Waverly", "50677", "(888)999-0000", division);

            division.add(steveRogers);
            division.add(bruceBanner);
            division.add(natashaRomanoff);
            division.add(thorOdinson);
            division.add(clintBarton);

            if(customerRepository.count() <=1) {
                customerRepository.save(steveRogers);
                customerRepository.save(bruceBanner);
                customerRepository.save(natashaRomanoff);
                customerRepository.save(thorOdinson);
                customerRepository.save(clintBarton);
            }



        }

    }
}
