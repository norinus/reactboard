package com.lab.reactboard.repository;

import com.lab.reactboard.domain.CommonGroupCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommonGroupCodeRepository extends JpaRepository <CommonGroupCode, String>, JpaSpecificationExecutor<CommonGroupCode> {
}
