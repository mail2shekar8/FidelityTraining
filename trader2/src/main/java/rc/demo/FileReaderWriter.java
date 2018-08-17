package rc.demo;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileReaderWriter {
	@Value(value = "${generator.output.file}")
	private String fileName;
	private FileOutputStream fileOutStream;
	private ObjectOutputStream objOutStream;
	private FileInputStream fileInStream;
	private ObjectInputStream objInStream;

	public FileReaderWriter() {
	}

	public FileReaderWriter(String fileName) {
		this.fileName = fileName;
	}

	public void write(List<Trade> trades) throws IOException {
		try {
			fileOutStream = new FileOutputStream(new File(fileName));
			objOutStream = new ObjectOutputStream(fileOutStream);
			objOutStream.writeInt(trades.size());
			for (Trade t : trades) {
				objOutStream.writeObject(t);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} finally {
			objOutStream.close();
			fileOutStream.close();
		}
	}

	public List<Trade> read() throws IOException {
		List<Trade> trades = new ArrayList<Trade>();
		try {
			fileInStream = new FileInputStream(new File(fileName));
			objInStream = new ObjectInputStream(fileInStream);
			int size = objInStream.readInt();
			for (int i = 0; i < size; i++) {
				trades.add((Trade) objInStream.readObject());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} finally {
			objInStream.close();
			fileInStream.close();
		}
		return trades;
	}
}
