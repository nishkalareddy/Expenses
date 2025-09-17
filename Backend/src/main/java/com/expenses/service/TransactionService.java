package com.expenses.service;
import com.expenses.model.Transaction;
import com.expenses.respository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
/*******************************************
 Developer Name: Nishkala
 Created on: 08/09/25 1:49 pm
 *******************************************/


@Service
public class TransactionService {
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public Transaction addTransaction(Transaction transaction) {
        return repo.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }

    public void deleteTransaction(Long id) {
        repo.deleteById(id);
    }

    public double getBalance() {
        List<Transaction> transactions = repo.findAll();
        double income = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("income"))
                .mapToDouble(Transaction::getAmount).sum();

        double expense = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("expense"))
                .mapToDouble(Transaction::getAmount).sum();

        return income - expense;
    }
}
