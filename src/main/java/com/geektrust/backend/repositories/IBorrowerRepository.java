package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Borrower;

public interface IBorrowerRepository {
    Borrower save(Borrower borrower);

    Borrower findByName(String name);
}
