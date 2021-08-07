package com.sid.garble;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.util.Base64.getDecoder;

public class Decrypt {
	static String decryptedValue = "";

	public static void TextDecryption(@NotNull JTextField input, JTextArea output) {
		decryptedValue = new String(getDecoder().decode(input.getText().getBytes()));
		output.append(Main.currentDateTime + "Original: " + input.getText() + "\nDecrypted: " + decryptedValue +
				"\n----------\n\n");
	}

	public static void FileDecryption(@NotNull JTextField input, JTextArea output) {
		decryptedValue = new String(getDecoder().decode(input.getText().getBytes()));
		Main.write("garble-decrypt.txt", Main.currentDateTime + "Original: " + input.getText() +
				"\nDecrypted: " + decryptedValue + "\n----------");
		output.append("Decrypted!\n");
	}

	public static void FromFileDecryption(JTextArea output) {
		try {
			JFileChooser chooser = new JFileChooser();

			if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
				System.out.println("Cancelled decryption.");
			}
			else {
				File file = chooser.getSelectedFile();

				BufferedReader in = new BufferedReader(new FileReader(file));
				String line = in.readLine();
				StringBuilder content = new StringBuilder();

				while (line != null) {
					content.append(line.trim());
					line = in.readLine();
				}

				decryptedValue = new String(getDecoder().decode(content.toString().getBytes()));
				output.append(Main.currentDateTime + "Original: " + content + "\nDecrypted: " + decryptedValue +
						"\n----------\n\n");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
