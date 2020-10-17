package com.cg.wallet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.wallet.dto.AddMoneyDto;
import com.cg.wallet.dto.DeleteAccountDto;
import com.cg.wallet.dto.SuccessResponse;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.exception.WalletAccountDoNotExistsException;
import com.cg.wallet.exception.WalletAccountExistsException;
import com.cg.wallet.service.AddWalletServiceImpl;
import com.cg.wallet.service.IAddWalletService;
import com.cg.wallet.util.WalletConstants;

@RestController
@CrossOrigin//(origins= {"http://localhost:4200"})
/****************************************************************************************************
* @author      :  Parteek goel
* Description  :  It is a controller class that is used to map the request for creating new wallet
*                 account, adding money to wallet and view all the details of all the account.
* Version      :  1.0
* Created Date :  7-OCT-2020
*******************************************************************************************************/

public class AddWalletMicroservice {
	
	@Autowired
	private IAddWalletService walletService;
	
	@Autowired
	private AddWalletServiceImpl addWalletService;
	
	/*********************************************************************************************************************
	* Method         :  addNewWalletAccount
	* Description    :  To map the request of user for creating wallet account of a new user.
	* @param userDto :  User's Details
	* @returns String:  After creating wallet account of the user it will return "Wallet account created successfully" message.
	* Created By     :  Parteek Goel
	* Created Date   :  7-OCT-2020
	***********************************************************************************************************************/
	
	@PostMapping(WalletConstants.ADD_WALLET_URL)
	public SuccessResponse addNewWalletAccount(@RequestBody UserDto userDto) throws WalletAccountExistsException {
		String message = walletService.addNewWalletAccount(userDto);
		return new SuccessResponse(message);
	}
	
	/*********************************************************************************************************************
	* Method             :  addMoney
	* Description        :  To map the request of user for adding money in user's wallet account.
	* @param addmoneyDto :  User's PhoneNo and amount to be added in wallet account.
	* @returns String    :  After adding money to wallet account of the user it will return "Money Added to wallet" message.
	* Created By         :  Parteek Goel
	* Created Date       :  7-OCT-2020
	***********************************************************************************************************************/
	
	@PutMapping(WalletConstants.ADD_MONEY_URL)
	public SuccessResponse addMoney(@RequestBody AddMoneyDto addmoneyDto) throws WalletAccountDoNotExistsException {
		String msg = walletService.addMoney(addmoneyDto);
		return new SuccessResponse(msg);
	}
	
	/*********************************************************************************************************************
	* Method             :  getAllDetails
	* Description        :  To map the request for showing all the user's details.
	* @returns           :  It will return all the details of all the user's.
	* Created By         :  Parteek Goel
	* Created Date       :  7-OCT-2020
	***********************************************************************************************************************/
	@GetMapping(WalletConstants.GET_DETAIL_URL)
	public List<WalletAccount> getAllDetails(){
	 return addWalletService.getAllDetails();
	 }
	
	/*********************************************************************************************************************************
	* Method                  :  deleteWalletAccount
	* Description             :  To map the request of user of deleting user's wallet account.
	* @param deleteaccountDto :  User PhoneNo for deleting user's wallet account.
	* @returns String         :  After deleting wallet account of the user it will return "Wallet Account Deleted Successfully" message.
	* Created By              :  Parteek Goel
	* Created Date            :  12-OCT-2020
	***********************************************************************************************************************************/
	@DeleteMapping(WalletConstants.DELETE_ACCOUNT_URL)
	public SuccessResponse deleteWalletAccount(@PathVariable(value = "phoneNo") String phoneNo) throws WalletAccountDoNotExistsException {
		String msg = walletService.deleteWalletAccount(phoneNo);
		return new SuccessResponse(msg);
	}
		
	
	
	

}
