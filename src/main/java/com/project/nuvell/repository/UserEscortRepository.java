package com.project.nuvell.repository;

import com.project.nuvell.entity.UserEscort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserEscortRepository extends JpaRepository<UserEscort, Long> {
}
