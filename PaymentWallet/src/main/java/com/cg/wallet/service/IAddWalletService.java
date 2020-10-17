package com.cg.wallet.service;

import java.util.List;
import com.cg.wallet.dto.AddMoneyDto;
import com.cg.wallet.dto.DeleteAccountDto;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exception.WalletAccountDoNotExistsException;
import com.cg.wallet.exception.WalletAccountExistsException;

/****************************************************************************************************
* @author      :  Parteek goel
* Description  :  It is a service interface that contain methods to be implemented in service class
* Version      :  1.0
* Created Date :  7-OCT-2020
*******************************************************************************************************/


public interface IAddWalletService {
	
	
	public String addNewWalletAccount(UserDto userDto) throws WalletAccountExistsException;
	public List<WalletAccount> getAllDetails();
	public String addMoney(AddMoneyDto addmoneyDto) throws WalletAccountDoNotExistsException;
	public String deleteWalletAccount(String phoneNo) throws WalletAccountDoNotExistsException;
}
