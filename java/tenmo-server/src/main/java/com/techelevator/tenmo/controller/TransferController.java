package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "transfers")
@PreAuthorize("isAuthenticated()")
public class TransferController {

    private TransferDao transferDao;
    private UserDao userDao;

    //Constructor
    public TransferController(TransferDao transferDao, UserDao userDao) {
        this.transferDao = transferDao;
        this.userDao = userDao;
    }
  //TODO: Delete first attempt below
    //Request Methods
    /*@ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createTransfer(@Valid @RequestBody Transfer incomingTransfer) {
        Transfer thisTransfer = incomingTransfer;
        //return transferDao.createTransfer();
        transferDao.createTransfer(incomingTransfer.getAccountFrom(), incomingTransfer.getAccountTo(), incomingTransfer.getAmount());
       // results = transferDao.createTransfer(transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount());
       // return results;
    }*/


}


