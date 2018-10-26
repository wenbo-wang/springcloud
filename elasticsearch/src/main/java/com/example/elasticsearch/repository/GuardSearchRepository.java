package com.example.elasticsearch.repository;

import com.example.elasticsearch.domain.Guard;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Guard entity.
 */
public interface GuardSearchRepository extends ElasticsearchRepository<Guard, Long> {
}
