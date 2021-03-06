package neo.rpc.client.test.util;

import java.nio.ByteBuffer;

import neo.model.bytes.Fixed8;
import neo.model.bytes.UInt16;
import neo.model.bytes.UInt160;
import neo.model.bytes.UInt256;
import neo.model.bytes.UInt32;
import neo.model.bytes.UInt64;
import neo.model.core.Block;
import neo.model.core.CoinReference;
import neo.model.core.Transaction;
import neo.model.core.TransactionOutput;
import neo.model.core.Witness;

public final class MockUtil {

	public static CoinReference getCoinReference000() {
		final int minSize = UInt256.SIZE + UInt16.SIZE;
		return new CoinReference(ByteBuffer.wrap(new byte[minSize]));
	}

	public static Block getMockBlock000() {
		final int minSize = (UInt32.SIZE * 3) + (UInt256.SIZE * 2) + (UInt64.SIZE) + (UInt160.SIZE) + 4;
		return new Block(ByteBuffer.wrap(new byte[minSize]));
	}

	public static Block getMockBlock001() {
		final Block block = getMockBlock000();
		final Transaction transaction = getMockTransaction000();
		transaction.inputs.add(getCoinReference000());
		transaction.outputs.add(getTransactionOutput000());
		transaction.scripts.add(getWitness000());
		block.getTransactionList().add(transaction);
		return block;
	}

	public static Transaction getMockTransaction000() {
		final int minSize = UInt32.SIZE + 39 + 33 + 2 + 2;
		final byte[] ba = new byte[minSize];
		ba[UInt32.SIZE + 2] = 4;
		ba[UInt32.SIZE + 36] = 3;
		ba[UInt32.SIZE + 36 + 33] = (byte) 0x81;
		ba[UInt32.SIZE + 36 + 33 + 2] = (byte) 0xFF;
		return new Transaction(ByteBuffer.wrap(ba));
	}

	public static TransactionOutput getTransactionOutput000() {
		final int minSize = UInt256.SIZE + UInt160.SIZE + Fixed8.SIZE;
		return new TransactionOutput(ByteBuffer.wrap(new byte[minSize]));
	}

	public static Witness getWitness000() {
		final int minSize = 2;
		return new Witness(ByteBuffer.wrap(new byte[minSize]));
	}

}
