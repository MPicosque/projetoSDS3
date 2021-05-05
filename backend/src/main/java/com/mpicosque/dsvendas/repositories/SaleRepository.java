package com.mpicosque.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpicosque.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
