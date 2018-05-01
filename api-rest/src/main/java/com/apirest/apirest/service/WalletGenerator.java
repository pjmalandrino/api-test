package com.apirest.apirest.service;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Sign;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class WalletGenerator {

    public String testWalletCreation(){

        try{
            System.out.println("Entering method");
            String fingerPrint = "testPrint!";
            byte[] message = fingerPrint.getBytes(StandardCharsets.UTF_8);

                String fileName = WalletUtils.generateNewWalletFile(
                        "c88b703fb08cbea894b6aeff5a544fb92e78a18e19814cd85da83b71f772aa6c",
                        new File("C:/Users/DRINO/Documents/workspace/walletFiles"), false);

                Credentials credentials = WalletUtils.loadCredentials("c88b703fb08cbea894b6aeff5a544fb92e78a18e19814cd85da83b71f772aa6c",
                        "C:/Users/DRINO/Documents/workspace/walletFiles/" + fileName);
                Sign.signMessage(message, credentials.getEcKeyPair());
            Sign.SignatureData signatureData = Sign.signMessage(message,credentials.getEcKeyPair(),true);
            System.out.println("DONE");
            System.out.println("**RESULTS** / R : " + signatureData.getR().toString());
            System.out.println("**RESULTS** / S : " + signatureData.getS().toString());
            System.out.println("**RESULTS** / HashCode : " + signatureData.hashCode());


            return signatureData.toString();
            }catch (CipherException | IOException | InvalidAlgorithmParameterException |
                    NoSuchAlgorithmException | NoSuchProviderException e){
                System.out.println("FAIL");
            }
            return null;
        }
}



