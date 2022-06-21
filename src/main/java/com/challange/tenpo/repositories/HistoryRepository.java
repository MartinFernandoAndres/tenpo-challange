package com.challange.tenpo.repositories;

import com.challange.tenpo.entitys.History;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HistoryRepository extends PagingAndSortingRepository<History, Long> {
}