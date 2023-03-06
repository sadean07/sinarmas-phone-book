package com.sinarmas.testing.repository;

import com.sinarmas.testing.entity.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookRepository extends JpaRepository<PhoneBook,Long> {
}
