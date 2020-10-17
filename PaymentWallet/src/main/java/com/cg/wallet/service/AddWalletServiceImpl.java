package com.cg.wallet.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.wallet.dao.WalletAccountDao;
import com.cg.wallet.dto.AddMoneyDto;
import com.cg.wallet.dto.DeleteAccountDto;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exception.WalletAccountDoNotExistsException;
import com.cg.wallet.exception.WalletAccountExistsException;
import com.cg.wallet.util.WalletConstants;

@Service
/****************************************************************************************************
* @author      :  Parteek goel
* Description  :  It is a service class that provides the services for create a new wallet account,
*                 add money to user's wallet and viewing all the account details.
* Version      :  1.0
* Created Date :  7-OCT-2020
*******************************************************************************************************/


public class AddWalletServiceImpl implements IAddWalletService{

	@Autowired
	private WalletAccountDao accountDao;
	
	/*********************************************************************************************************************
	 * Method: addNewWalletAccount 
	 * Description: Create new wallet account for user
	 * @param userDto: object containing data about user
	 * @throws WalletAccountExistsException: It is raised if the PhoneNo provided by the user is already exists
	 * Created By: Parteek Goel
	 * Created Date: 7-OCT-2020
	 * 
	 ***********************************************************************************************************************/

	@Override
	@Transactional
	public String addNewWalletAccount(UserDto userDto) throws WalletAccountExistsException {
		 Optional<WalletAccount> optAccount = accountDao.findById(userDto.getPhoneNo());
		 if (optAccount.isPresent())
			 throw new WalletAccountExistsException(WalletConstants.PHONE_NO_ALREADY_EXISTS);
		WalletAccount account = new WalletAccount();
		account.setPhoneNo(userDto.getPhoneNo());
		account.setUserName(userDto.getUserName());
		account.setPassword(userDto.getPassword());
		account.setBalance(userDto.getBalance());
		account.setRole(WalletConstants.USER_ROLE);
		account.setStatus(WalletConstants.ACTIVE_USER);
		account.setAccCreatedDt(LocalDate.now());
		accountDao.save(account);
		return WalletConstants.WALLET_ACCOUNT_CREATED;
	}
	
	/*********************************************************************************************************************
	 * Method: addMoney 
	 * Description: AddMoney to user wallet account
	 * @param addmoneyDto: object containing user PhoneNo and Amount to be added in wallet account
	 * @throws WalletAccountDoNotExistsException: It is raised if the PhoneNo provided by the user is not exists
	 * Created By: Parteek Goel
	 * Created Date: 7-OCT-2020
	 * 
	 ***********************************************************************************************************************/

	@Override
	public String addMoney(AddMoneyDto addmoneyDto) throws WalletAccountDoNotExistsException {
		Optional<WalletAccount> optAccount = accountDao.findById(addmoneyDto.getPhoneNo());
		if (!optAccount.isPresent())
			 throw new WalletAccountDoNotExistsException(WalletConstants.ACCOUNT_NOT_EXISTS);
		WalletAccount account=optAccount.get();
		Double balance=account.getBalance();
		balance=balance+addmoneyDto.getAmount();
		account.setBalance(balance);
		accountDao.save(account);
		return WalletConstants.MONEY_ADDED_TO_WALLET ;
	}	
	
	/*********************************************************************************************************************
	 * Method: getAllDetails 
	 * Description: Give the details of all the users
	 * Created By: Parteek Goel
	 * Created Date: 7-OCT-2020
	 * 
	 ***********************************************************************************************************************/

	@Override
    public List<WalletAccount> getAllDetails() {
		return accountDao.findAll();
	}

	
	/*********************************************************************************************************************
	 * Method: deleteWalletAccount 
	 * Description: Delete user wallet account
	 * @param deleteaccountDto: object containing user PhoneNo at which user's wallet account is created.
	 * @throws WalletAccountDoNotExistsException: It is raised if the PhoneNo provided by the user is not exists
	 * Created By: Parteek Goel
	 * Created Date: 12-OCT-2020
	 * 
	 ***********************************************************************************************************************/
      
	@Override
	public String deleteWalletAccount(String phoneNo) throws WalletAccountDoNotExistsException {
		Optional<WalletAccount> optAccount = accountDao.findById(phoneNo);
		if (!optAccount.isPresent())
			 throw new WalletAccountDoNotExistsException(WalletConstants.ACCOUNT_NOT_EXISTS);
		accountDao.deleteById(phoneNo);
		return WalletConstants.WALLET_ACCOUNT_DELETED ;
	}
	

	

	
}
