package com.cydercode.simpleblockchain;

import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
        Digest digest = new Digest();

        BlockChain blockChain = new BlockChain();

        blockChain.addBlock(new Block("Genesis block", "0", digest));

        IntStream.range(0, 5).forEach(i -> {
            blockChain.addBlock(new Block("Block number " + i, blockChain.getLatestBlock(), digest));
        });

        System.out.println("BlockChain: ");

        blockChain.display();
    }

}
