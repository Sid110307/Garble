package com.sid.garble;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static java.util.Base64.getDecoder;

public class Decrypt {

	static String decryptedValue = "";

	public static void TextDecryption(@NotNull JTextField input, JTextArea output) {
		decryptedValue = new String(getDecoder().decode(input.getText().getBytes()));
		output.append(Main.currentDateTime + "Original: " + input.getText() + "\nDecrypted: "
				+ decryptedValue + "\n----------\n\n");
	}

	public static void FileDecryption(@NotNull JTextField input, JTextArea output) {
		decryptedValue = new String(getDecoder().decode(input.getText().getBytes()));
		Main.write("garble-decrypt.txt", Main.currentDateTime + "Original: " + input.getText()
				+ "\nDecrypted: " + decryptedValue + "\n----------");
		output.append("Decrypted!\n");
	}
}
