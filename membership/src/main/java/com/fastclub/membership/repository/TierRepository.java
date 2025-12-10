package com.fastclub.membership.repository;

import com.fastclub.membership.domain.Tier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TierRepository extends JpaRepository<Tier, String> {
}
