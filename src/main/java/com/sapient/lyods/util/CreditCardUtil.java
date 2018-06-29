package com.sapient.lyods.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.sapient.lyods.command.AllCardResponse;
import com.sapient.lyods.model.CreditCard;

public class CreditCardUtil {

	public static Integer genarateId(){
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;
		return n;
	}

	public static Date addCalendar(int year) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}
	
	public static boolean checkCreditCardLuhn(String ccNumber)
    {
            int sum = 0;
            boolean alternate = false;
            for (int i = ccNumber.length() - 1; i >= 0; i--)
            {
                    int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                    if (alternate)
                    {
                            n *= 2;
                            if (n > 9)
                            {
                                    n = (n % 10) + 1;
                            }
                    }
                    sum += n;
                    alternate = !alternate;
            }
            return (sum % 10 == 0);
    }

	public static List<AllCardResponse> genarateAllCardResponse(List<CreditCard> cardList) {
		List<AllCardResponse> allCardResponses = new ArrayList<AllCardResponse>();
		Iterator<CreditCard> iterator = cardList.iterator();
		while(iterator.hasNext()){
			CreditCard creditCard = iterator.next();
			AllCardResponse allCardResponse = new AllCardResponse();
			allCardResponse.setCardNumber(creditCard.getCardNumber());
			allCardResponse.setBalance(creditCard.getAccount().getBalance());
			allCardResponse.setCreditLimit(creditCard.getCreditLimit());
			allCardResponse.setCustomerName(creditCard.getAccount().getCustomer().getCustomerName());
			allCardResponses.add(allCardResponse);
		}
		return allCardResponses;
	}

	public static String getLastFourDigitAccountNumber(String creditCardNumber) {
		StringBuffer lastFourDigit = new StringBuffer();
		int beginIndex = creditCardNumber.length() - 4;
		lastFourDigit.append("****");
		lastFourDigit.append(creditCardNumber.substring(beginIndex, creditCardNumber.length()));

		return lastFourDigit.toString();
	}
	
}
