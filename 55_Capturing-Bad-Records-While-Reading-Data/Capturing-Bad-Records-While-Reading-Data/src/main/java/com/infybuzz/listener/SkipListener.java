package com.infybuzz.listener;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import org.springframework.batch.core.annotation.OnSkipInRead;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.stereotype.Component;

@Component
public class SkipListener {

	@OnSkipInRead
	public void skipInRead(Throwable th) {
		if(th instanceof FlatFileParseException) {
			createFile("D:\\M\\U\\Teaching\\Spring-Batch\\Data\\StsProjetcs\\spring-batch\\Chunk Job\\First Chunk Step\\reader\\SkipInRead.txt", 
					((FlatFileParseException) th).getInput());
		}
	}
	
	public void createFile(String filePath, String data) {
		try(FileWriter fileWriter = new FileWriter(new File(filePath), true)) {
			fileWriter.write(data + "," + new Date() + "\n");
		}catch(Exception e) {
			
		}
	}
}
