package de.blockchain.experimental.utils;

import de.blockchain.experimental.models.Block;
import de.blockchain.experimental.models.Transaction;

import java.util.List;

/**
 * @author Mirko Pleli 2021
 */
public class SizeHelper {
    public final static int TRANSACTION_SIZE_IN_BYTES = 128;

    public final static int BLOCK_HEADER_SIZE_IN_BYTES = 80;

    public final static int BLOCK_META_DATA_SIZE_IN_BYTES = 12;

    public static int calculateBlockSize(Block block) {
        return BLOCK_HEADER_SIZE_IN_BYTES + block.getTransactions().size() * TRANSACTION_SIZE_IN_BYTES +
                BLOCK_META_DATA_SIZE_IN_BYTES;
    }

    public static int calculateTransactionListSize(List<Transaction> transactions) {
        return transactions.size() * TRANSACTION_SIZE_IN_BYTES;
    }
}
