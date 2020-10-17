package com.cg.wallet;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.wallet.dto.AddMoneyDto;
import com.cg.wallet.dto.DeleteAccountDto;
import com.cg.wallet.dto.UserDto;
import com.cg.wallet.exception.WalletAccountDoNotExistsException;
import com.cg.wallet.exception.WalletAccountExistsException;
import com.cg.wallet.service.AddWalletServiceImpl;

@SpringBootTest
class PaymentWalletApplicationTests {
	
	@Autowired
	private AddWalletServiceImpl service;
	
	/**********************************************************************************************
	* Method         :  testAddWallet1
	* Description    :  To test whether new wallet account is created successfully or not
	                    when user create account with the phoneNo that do not exists in database .
	* Created By     :  Parteek Goel
	* Created Date   :  8-OCT-2020
	************************************************************************************************/
	@Test
	public void testAddWallet1() throws WalletAccountExistsException 
	{
		UserDto user = new UserDto();
		
		user.setPhoneNo("8077406368");
		user.setBalance(100);
		user.setUserName("ankit");
		user.setPassword("abcde");
		
		String result= service.addNewWalletAccount(user);
		Assertions.assertEquals("Wallet account created successfully",result);
	}
	
	
	/**************************************************************************************
	* Method         :  testAddWallet2
	* Description    :  To test whether it throws WalletAccountExistsException successfully 
	                    when user give the phoneNo that exists in database.               
	* Created By     :  Parteek Goel
	* Created Date   :  8-OCT-2020
	****************************************************************************************/
	@Test
	public void testAddWallet2() throws WalletAccountExistsException 
	{
		UserDto user = new UserDto();
		
		user.setPhoneNo("9897553074");
		user.setBalance(5000);
		user.setUserName("kartik gupta");
		user.setPassword("5489654");

		assertThrows(WalletAccountExistsException.class, ()->service.addNewWalletAccount(user));
	}
	
	/**************************************************************************************
	* Method         :  testAddMoney1
	* Description    :  To test whether money added to user wallet sucessfully or not
	                    when user give the phoneNo that exists in database .
	* Created By     :  Parteek Goel
	* Created Date   :  8-OCT-2020
	****************************************************************************************/
	@Test
	public void testAddMoney1() throws WalletAccountDoNotExistsException 
	{
		AddMoneyDto addmoney = new AddMoneyDto();
		
		addmoney.setPhoneNo("9897553074");
	    addmoney.setAmount(200);
				
		String result= service.addMoney(addmoney);
		Assertions.assertEquals("Money Added to wallet successfully",result);
	}
	/**************************************************************************************************
	* Method         :  testAddMoney2
	* Description    :  To test whether it throws WalletAccountDoNotExistsException sucessfully or not
	                    when user give the phoneNo that do not exists in database .
	* Created By     :  Parteek Goel
	* Created Date   :  8-OCT-2020
	****************************************************************************************************/
    @Test
	public void testAddMoney2() throws WalletAccountDoNotExistsException 
	{
      
    	AddMoneyDto addmoney = new AddMoneyDto();
		
		addmoney.setPhoneNo("1111111111");
	    addmoney.setAmount(200);
	    
		assertThrows(WalletAccountDoNotExistsException.class, ()->service.addMoney(addmoney));
	} 
    
}
