package de.blockchain.experimental.models;

import de.blockchain.experimental.utils.SHA3Helper;
import de.blockchain.experimental.utils.SizeHelper;
import org.bouncycastle.util.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mirko Pleli 2021
 */
public class Block {

    private int magicNumber = 0x747501;

    private int blockSize;

    private int transactionCount;

    private List<Transaction> transactions;

    private BlockHeader blockHeader;

    public Block() {

    }

    public Block(byte[] previousHash) {
        this.transactionCount = 0;
        this.transactions = new ArrayList<>();
        this.blockSize = SizeHelper.calculateBlockSize(this);
        this.blockHeader = new BlockHeader(System.currentTimeMillis(), previousHash, getTransactionHash());
    }

    private byte[] getTransactionHash() {
        byte[] transactionsInBytes = new byte[0];
        for (Transaction transaction : transactions) {
            transactionsInBytes = Arrays.concatenate(transactionsInBytes, transaction.getTxId());
        }
        return SHA3Helper.hash256(transactionsInBytes);
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        this.transactionCount++;
        this.blockHeader.setTransactionListHash(getTransactionHash());
        this.blockSize = SizeHelper.calculateBlockSize(this);
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public BlockHeader getBlockHeader() {
        return blockHeader;
    }

    public void setBlockHeader(BlockHeader blockHeader) {
        this.blockHeader = blockHeader;
    }
}
