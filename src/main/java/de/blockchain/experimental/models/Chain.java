package de.blockchain.experimental.models;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Chain {

    private List<Block> chain = new CopyOnWriteArrayList<>();

    private int networkId;

    public void add(Block block) {
        chain.add(block);
    }

    public Block get(int index) {
        return chain.get(index);
    }

    public Block getLast() {
        return chain.get(chain.size() - 1);
    }

    public int size() {
        return chain.size();
    }

    public List<Block> getChain() {
        return chain;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    @Override
    public String toString() {
        return "Chain{" +
                "chain=" + chain +
                ", networkId=" + networkId +
                '}';
    }
}
