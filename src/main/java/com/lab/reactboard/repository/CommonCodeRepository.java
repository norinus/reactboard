package com.lab.reactboard.repository;

import com.lab.reactboard.domain.CommonCode;
import com.lab.reactboard.domain.CommonCodeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommonCodeRepository extends JpaRepository<CommonCode, CommonCodeKey>, JpaSpecificationExecutor<CommonCode> {

}
