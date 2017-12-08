package org.szelc.tga.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author by marcin.szelc on 2017-12-08.
 */
public class TgaController implements Initializable {



    private static final Logger log = Logger.getLogger(TgaController.class.toString());

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        log.info("AntStockController subcontroller loaded successfully.");
    }



}