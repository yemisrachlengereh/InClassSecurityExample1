package me.afua.thymeleafsecdemo.repositories;

import me.afua.thymeleafsecdemo.entities.Bank;
import org.springframework.data.repository.CrudRepository;

import java.security.cert.CertPathValidatorException;

public interface BankRepository extends CrudRepository<Bank,Long> {
   Bank findByReason(String bank);
Bank findByAccountnumber(long bank);
Bank findById(long  bank);
}
