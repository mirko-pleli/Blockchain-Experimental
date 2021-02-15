package de.blockchain.experimental.models;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Mirko Pleli 2021
 */
public class BlockHeader implements Serializable {

    private int version;

    private int nonce = 0;

    private long timestamp;

    private byte[] previousHash;

    private byte[] transactionListHash;

    public BlockHeader() {
    }

    public BlockHeader(long timestamp, byte[] previousHash, byte[] transactionListHash) {
        this.version = 1;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.transactionListHash = transactionListHash;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public void incrementNonce() throws ArithmeticException {
        if (this.nonce == Integer.MAX_VALUE) {
            throw new ArithmeticException();
        }
        this.nonce++;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(byte[] previousHash) {
        this.previousHash = previousHash;
    }

    public byte[] getTransactionListHash() {
        return transactionListHash;
    }

    public void setTransactionListHash(byte[] transactionListHash) {
        this.transactionListHash = transactionListHash;
    }

    @Override
    public String toString() {
        return "BlockHeader{" +
                "version=" + version +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", previousHash=" + Arrays.toString(previousHash) +
                ", transactionListHash=" + Arrays.toString(transactionListHash) +
                '}';
    }
}
