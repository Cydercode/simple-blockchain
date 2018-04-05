package com.cydercode.simpleblockchain;

import java.util.Date;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;

    public Block(String data, Block previousBlock, Digest digest) {
        this(data, previousBlock.getHash(), digest);
    }

    public Block(String data, String previousHash, Digest digest) {
        this.data = data;
        this.previousHash = previousHash;

        timeStamp = new Date().getTime();
        hash = calculateHash(digest);
    }

    private String calculateHash(Digest digest) {
        return digest.apply(previousHash + timeStamp + data);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
