package com.practice.first.dao;

import com.practice.first.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends PagingAndSortingRepository<Client, Integer> {


}
