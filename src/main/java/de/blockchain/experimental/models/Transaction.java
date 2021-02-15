package de.blockchain.experimental.models;

import de.blockchain.experimental.utils.SHA3Helper;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Mirko Pleli 2021
 * <p>
 * Attributes that are unknowen during the hash calculation are declared with transistent.
 */
public class Transaction implements Serializable {

    private transient byte[] txId;

    private byte[] sender;

    private byte[] receiver;

    private double amount;

    private int nonce;

    private transient long receivedTimeStamp;

    private transient byte[] blockId;

    private double transactionFeeBasePrice;

    private double transactionFeeLimit;

    private transient double transactionFee;

    private transient int sizeInByte;

    public Transaction(byte[] sender, byte[] receiver, double amount, int nonce, double transactionFeeBasePrice, double transactionFeeLimit) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.nonce = nonce;
        this.transactionFeeBasePrice = transactionFeeBasePrice;
        this.transactionFeeLimit = transactionFeeLimit;
    }

    public Transaction() {
        initTxId();
    }

    public byte[] getTxId() {
        this.txId = SHA3Helper.hash256(this);
        return txId;
    }

    public void setTxId(byte[] txId) {
        this.txId = txId;
    }

    public byte[] getSender() {
        return sender;
    }

    public void setSender(byte[] sender) {
        this.sender = sender;
    }

    public byte[] getReceiver() {
        return receiver;
    }

    public void setReceiver(byte[] receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public long getReceivedTimeStamp() {
        return receivedTimeStamp;
    }

    public void setReceivedTimeStamp(long receivedTimeStamp) {
        this.receivedTimeStamp = receivedTimeStamp;
    }

    public byte[] getBlockId() {
        return blockId;
    }

    public void setBlockId(byte[] blockId) {
        this.blockId = blockId;
    }

    public double getTransactionFeeBasePrice() {
        return transactionFeeBasePrice;
    }

    public void setTransactionFeeBasePrice(double transactionFeeBasePrice) {
        this.transactionFeeBasePrice = transactionFeeBasePrice;
    }

    public double getTransactionFeeLimit() {
        return transactionFeeLimit;
    }

    public void setTransactionFeeLimit(double transactionFeeLimit) {
        this.transactionFeeLimit = transactionFeeLimit;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public int getSizeInByte() {
        return sizeInByte;
    }

    public void setSizeInByte(int sizeInByte) {
        this.sizeInByte = sizeInByte;
    }

    private void initTxId() {
        this.setTxId(SHA3Helper.hash256(this));
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender=" + Arrays.toString(sender) +
                ", receiver=" + Arrays.toString(receiver) +
                ", amount=" + amount +
                ", nonce=" + nonce +
                ", transactionFeeBasePrice=" + transactionFeeBasePrice +
                ", transactionFeeLimit=" + transactionFeeLimit +
                '}';
    }
}
