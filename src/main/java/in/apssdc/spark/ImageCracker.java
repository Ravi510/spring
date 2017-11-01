package in.apssdc.spark;
import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageCracker
{

	public static String crackImage(String filePath)
	{

		File imageFile = new File(filePath);

		ITesseract instance = new Tesseract();

		try
		{

			String result = instance.doOCR(imageFile);

			return result;

		}
		catch (TesseractException e)
		{

			System.err.println(e.getMessage());

			return "Error while reading image";

		}

	}

	public static void main(String[] args)
	{

		System.out.println(ImageCracker.crackImage("test.png"));

	}

}