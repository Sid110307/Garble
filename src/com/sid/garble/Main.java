package com.sid.garble;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Main {
	public static String currentDateTime;
	public static String releaseNotes = """
				v0.95  - Changed look and feel.
				v0.9   - Added Encryption and Decryption from files.
				v0.8   - Redesigned GUI and modified credits screen.
				v0.7   - Date and Time for Encrypted/Decrypted data.
				v0.6   - File appending instead of replacing data.
				v0.5   - Optimizations and Bug fixes.
				v0.45  - Created GUI.
				v0.4   - Fixed a Bug where the data was not saving if the file exists.
				v0.3   - Added option to encrypt and decrypt to files.
				v0.25  - Better Encoding/Decoding using Base64.
				v0.2   - Made tabular layout for options.
				v0.15  - Added Base32 Decryption.
				v0.1   - Initial Beta Release. Added Base32 Encryption.
				v0.0.7 - Encryption and Decryption with Character shuffles (Courtesy of GoralKBS).
				v0.0.5 - Added text and number decryption.
				v0.0.3 - Added credits page.
				v0.0.2 - Simple text and number encryption with text replacing.
				v0.0.1 - Initial Alpha Release of Garble.
			""";

	public JPanel root;
	public JTextArea output;
	public JTextField input;
	public JButton textEncryption;
	public JButton textDecryption;
	public JButton fileEncryption;
	public JButton fileDecryption;
	public JButton credits;
	public JButton fork;
	public JButton fromFileEncryption;
	public JButton fromFileDecryption;

	public Main() {
		input.requestFocus();
		output.setEditable(false);
		currentDateTime = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss a").format(new Date()) + "\n";
		textEncryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), "")) Encrypt.TextEncryption(input, output);
			else JOptionPane.showMessageDialog(null, "Please enter text in the input field.",
					"Error", JOptionPane.ERROR_MESSAGE);
		});
		textDecryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), "")) Decrypt.TextDecryption(input, output);
			else JOptionPane.showMessageDialog(null, "Please enter text in the input field.",
					"Error", JOptionPane.ERROR_MESSAGE);
		});
		fileEncryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), "")) Encrypt.FileEncryption(input, output);
			else JOptionPane.showMessageDialog(null, "Please enter text in the input field.",
					"Error", JOptionPane.ERROR_MESSAGE);
		});
		fileDecryption.addActionListener(e -> {
			if (!Objects.equals(input.getText(), "")) Decrypt.FileDecryption(input, output);
			else JOptionPane.showMessageDialog(null, "Please enter text in the input field.",
					"Error", JOptionPane.ERROR_MESSAGE);
		});
		fromFileEncryption.addActionListener(e -> Encrypt.FromFileEncryption(output));
		fromFileDecryption.addActionListener(e -> Decrypt.FromFileDecryption(output));
		fork.addActionListener(e -> {
			try {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				assert desktop != null;
				desktop.browse(new URI("https://github.com/Sid110307/Garble.git"));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Your desktop doesn't support opening " +
								"web links.\nPlease open it manually: https://github.com/Sid110307/Garble.git",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		credits.addActionListener(e -> JOptionPane.showMessageDialog(null, "Garble is a " +
				"tool developed by Siddharth P Bharadwaj to encrypt and decrypt text. You can also encrypt and " +
				"decrypt to files.\nFor more information, contact me at siddharthpb2007@gmail.com.\n\nRelease " +
				"notes:\n" + releaseNotes, "About Garble", JOptionPane.INFORMATION_MESSAGE));
	}

	public static void main(String[] args) {
		JFrame main = new JFrame("Garble - Encryption and Decryption");
		main.setContentPane(new Main().root);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setMinimumSize(new Dimension(400, 300));
		main.pack();
		main.setVisible(true);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write(String fileName, String s) {
		try {
			Files.writeString(Path.of("./", fileName), s + System.lineSeparator(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}