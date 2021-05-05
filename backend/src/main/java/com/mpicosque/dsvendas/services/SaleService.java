package com.mpicosque.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mpicosque.dsvendas.dto.SaleDTO;
import com.mpicosque.dsvendas.dto.SaleSuccessDTO;
import com.mpicosque.dsvendas.dto.SaleSumDTO;
import com.mpicosque.dsvendas.entities.Sale;
import com.mpicosque.dsvendas.repositories.SaleRepository;
import com.mpicosque.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}
