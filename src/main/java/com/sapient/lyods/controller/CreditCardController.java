package com.sapient.lyods.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.lyods.command.AllCardResponse;
import com.sapient.lyods.command.ChargeCreditRequest;
import com.sapient.lyods.command.CreditCardRequest;
import com.sapient.lyods.handler.AbstractRestHandler;
import com.sapient.lyods.model.CreditCard;
import com.sapient.lyods.service.CreditCardService;
import com.sapient.lyods.util.CreditCardUtil;

@RestController
public class CreditCardController extends AbstractRestHandler {

	private final Logger logger = LoggerFactory.getLogger(CreditCardController.class);
	@Autowired
	CreditCardService creditCardService;

	@RequestMapping(value = "/addCard", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" })
	public ResponseEntity<String> addCard(@Valid @RequestBody CreditCardRequest creditCardRequest,
			HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult) {
		logger.debug("CreditCardController addCard start");
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		CreditCard creditCard = creditCardService.addCreditCard(creditCardRequest);
		return new ResponseEntity<String>("New Credit Card Created:" + creditCard.getCardNumber(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getAllCards", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<AllCardResponse>> getAllCards(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("CreditCardController getAllCards start");
		List<CreditCard> cardList = creditCardService.getAllCreditCard();
		List<AllCardResponse> allCardResponses = CreditCardUtil.genarateAllCardResponse(cardList);

		return new ResponseEntity<List<AllCardResponse>>(allCardResponses, HttpStatus.OK);
	}

	@RequestMapping(value = "/charge", method = RequestMethod.PUT, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> chargeRequest(@Valid @RequestBody ChargeCreditRequest chargeCreditRequest,
			HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult) {
		logger.debug("CreditCardController getAllCards start");
		CreditCard creditCard = creditCardService.chargeRequest(chargeCreditRequest);

		return new ResponseEntity<String>(
				"Balance Amount " + creditCard.getAccount().getBalance() + "in the Credit Card Number ending with "
						+ CreditCardUtil.getLastFourDigitAccountNumber(chargeCreditRequest.getCreditCardNumber()),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/credit", method = RequestMethod.PUT, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> creditRequest(@Valid @RequestBody ChargeCreditRequest chargeCreditRequest,
			HttpServletRequest request, HttpServletResponse response, BindingResult bindingResult) {
		logger.debug("CreditCardController getAllCards start");
		CreditCard creditCard = creditCardService.creditRequest(chargeCreditRequest);

		return new ResponseEntity<String>(
				"Balance Amount " + creditCard.getAccount().getBalance() + "in the Credit Card Number ending with "
						+ CreditCardUtil.getLastFourDigitAccountNumber(chargeCreditRequest.getCreditCardNumber()),
				HttpStatus.OK);
	}
}
