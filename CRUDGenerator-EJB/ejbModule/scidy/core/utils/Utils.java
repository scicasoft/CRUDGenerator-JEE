package scidy.core.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
	public static String capitalizeFirstLetters(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public static String tranformerTexte(String s, String[] patterns,
			String[] dattums) {
		String str = s;
		for (int i = 0; i < patterns.length; i++) {
			str = str.replaceAll("\\{\\{" + patterns[i] + "\\}\\}", dattums[i]);
		}
		return str;
	}

	public static String recupererContenuFichier(String path)
			throws IOException {
		File fc = new File(path);
		BufferedReader fcReader = new BufferedReader(new FileReader(fc));
		StringBuilder contenu = new StringBuilder();
		String line;

		while ((line = fcReader.readLine()) != null) {
			contenu.append(line + '\n');
		}
		
		fcReader.close();
		return contenu.toString();
	}

	public static void mettreDansFichier(String path, String contenu)
			throws IOException {
		File f = new File(path);
		if (f.exists())
			f.delete();
		f.createNewFile();
		BufferedWriter fcWriter = new BufferedWriter(new FileWriter(f));
		fcWriter.write(contenu);
		fcWriter.close();
	}
}
