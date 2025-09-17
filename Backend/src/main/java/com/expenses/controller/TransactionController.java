package com.expenses.controller;
import com.expenses.model.Transaction;
import com.expenses.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend later
public class TransactionController {
    private final TransactionService service;
    public TransactionController(TransactionService service)
    {
        this.service = service;
    }
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        service.deleteTransaction(id);
    }

    @GetMapping("/balance")
    public double getBalance() {
        return service.getBalance();
    }
}
