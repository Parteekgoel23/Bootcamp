package com.cg.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.cg.wallet.dto.UserDto;
import com.cg.wallet.entity.WalletAccount;

@Repository
public interface WalletAccountDao extends JpaRepository<WalletAccount, String>{
}

