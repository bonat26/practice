package com.practice.first.dao;

import com.practice.first.model.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ClientDao extends PagingAndSortingRepository<Client, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Client SET NAME = :name WHERE client_id = :id")
    void updateClientName(@Param("id") Integer id, @Param("name") String name);

}
