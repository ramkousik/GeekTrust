package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Borrower;
import com.geektrust.backend.entities.Loan;
import com.geektrust.backend.repositories.impl.BorrowerRepositoryImpl;
import com.geektrust.backend.repositories.impl.LoanRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class BorrowerLoanRepositoryTest {

    private IBorrowerRepository borrowerRepository;
    private ILoanRepository loanRepository;

    @BeforeEach
    void setup() {
        int loanId = 1;
        double loanPrincipal = 10000.00;
        int loanTenureInYears = 5;
        double loanInterestRate = 4.0;

        Loan loan = new Loan(loanId, "IDIDI", loanPrincipal, loanTenureInYears, loanInterestRate);
        String borrowerName = "John";
        Borrower borrower = new Borrower(borrowerName);
        borrower.addBorrowerLoan(loan);
        Map<String, Borrower> testBorrowerMap = new HashMap<String, Borrower>() {
            {
                put(borrowerName, borrower);
            }
        };

        Map<Integer, Loan> testLoanMap = new HashMap<Integer, Loan>() {
            {
                put(loanId, loan);
            }
        };

        borrowerRepository = new BorrowerRepositoryImpl(testBorrowerMap);
        loanRepository = new LoanRepositoryImpl(testLoanMap);
    }

    @Test
    @DisplayName("Save Borrower & Loan method should create Loan & Borrower and return borrower object")
    void saveBorrowerLoanRepositoryTest() {
        // Arrange
        int loanId = 2;
        double loanPrincipal = 20000.00;
        int loanTenureInYears = 5;
        double loanInterestRate = 4.0;

        Loan loan = new Loan(loanId, "MBI", loanPrincipal, loanTenureInYears, loanInterestRate);
        Borrower expectedBorrower = new Borrower("Jane");
        expectedBorrower.addBorrowerLoan(loan);

        // Act
        loanRepository.save(new Loan(loanId, "MBI", loanPrincipal, loanTenureInYears, loanInterestRate));
        Borrower actualBorrower = new Borrower("Jane");
        actualBorrower.addBorrowerLoan(loanRepository.findById(loanId));
        borrowerRepository.save(actualBorrower);

        Borrower actualOutput = borrowerRepository.findByName("Jane");

        // Assert
        Assertions.assertTrue((expectedBorrower.getBorrowerName().equals(actualOutput.getBorrowerName()))
                && (expectedBorrower.getBorrowerLoans().size() == actualOutput.getBorrowerLoans().size()));
    }
}
