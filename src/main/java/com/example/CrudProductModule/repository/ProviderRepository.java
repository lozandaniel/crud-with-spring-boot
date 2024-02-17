package com.example.CrudProductModule.repository;

import com.example.CrudProductModule.models.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
