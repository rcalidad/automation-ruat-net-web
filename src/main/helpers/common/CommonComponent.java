/**
 * @description Contiene Metodos comunes de Inmuebles
 * @author Faustina Chambi Camata
 * @date 14/07/2022
 */

package main.helpers.common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonComponent 
{

	public static String getRandomNumber(int numberOfDigits)
	{
		StringBuilder randomNumber = new StringBuilder();
		for(int i = 0; i < numberOfDigits; i ++)
			randomNumber.append((int) (Math.random() * 10));
		
		return randomNumber.toString();
	}
	
	public static int getRandomNumber(int min, int max )
	{
		return ThreadLocalRandom.current ( ).nextInt ( min, max + 1 );
	}
	
	public static String generateProcessNumber()
	{
		return new StringBuilder().append("T-JAPONES").append(getRandomNumber(6)).toString();
	}
	
	public static void closeWindow(Robot r)
	{
		r.keyPress(KeyEvent.VK_ALT);
	    r.keyPress(KeyEvent.VK_F4);	
	    r.keyRelease(KeyEvent.VK_ALT);
	    r.keyRelease(KeyEvent.VK_F4);
	}
	
	public static String getTitleFormatString(String string)
	{
		StringTokenizer separator = new StringTokenizer(string);
		StringBuilder newString = new StringBuilder();
		String aux;
		
		while(separator.hasMoreTokens())
		{
			aux = separator.nextToken();
			if(!aux.equals("IP") && !aux.equals("IMT"))
			{
				if(aux.equalsIgnoreCase("Y") || aux.equalsIgnoreCase("A"))
				{
					newString.append(aux.toLowerCase());
				}
				else
				{
					newString.append(aux.substring(0, 1).toUpperCase());
					newString.append(aux.substring(1).toLowerCase());
				}			
			}			
			else
			{
				newString.append(aux);
			}
			newString.append(" ");
		}
		newString.deleteCharAt(newString.length() - 1);
		
		return newString.toString();
	}
	
	public static String getNameLastPdfGenerated()
	{
		File        reportFiles[]         = new File(Constants.REPORTS_DIRECTORY).listFiles();
		String      lastFile      = reportFiles[0].getName();
		long        lastModification = reportFiles[0].lastModified();
		
		for(File f: reportFiles)
		{
			if(f.lastModified() > lastModification)
			{
				lastFile      = f.getName();
				lastModification = f.lastModified();
			}
		}
		return lastFile;
	}	
	
	public static String getPdfContent(String fileName)
	{
		String          pdfContent = "";
		PDFParser       pdfParser    = null;
		COSDocument     cosDocument = null;
		PDDocument      pdDocument  = null;
		PDFTextStripper textStripper = null;
		
		try
		{
			pdfParser    = new PDFParser(new RandomAccessFile(new File (Constants.REPORTS_DIRECTORY.concat(fileName)), "r"));
			pdfParser.parse();
			
			cosDocument = pdfParser.getDocument();
			textStripper = new PDFTextStripper();
			textStripper.setStartPage(1);
			
			pdDocument  = new PDDocument(cosDocument);
			pdfContent = textStripper.getText(pdDocument);
			
			pdDocument.close();
			cosDocument.close();
		}
		catch(IOException pdfFileException)
		{
			StringWriter exceptionString      = null;
			PrintWriter  redirectException = null;
			
			exceptionString      = new StringWriter();
		    redirectException = new PrintWriter(exceptionString);
		    pdfFileException.printStackTrace(redirectException);
		}
		return pdfContent;
	}
	
	public static String getContentLastPdfGenerated()
	{		
		return getPdfContent(getNameLastPdfGenerated());
	}
	
	public static Calendar convertStringToDate(String date)
	{
		Calendar transformedDate = Calendar.getInstance();
		String   dateMask   = "";
		
		if(date.contains("-"))
		{
			dateMask = "dd-mm-yy";
		}
		else if(date.contains("/"))
		{
			dateMask = "dd/mm/yy";
		}		
		try 
		{
			transformedDate.setTime(new SimpleDateFormat(dateMask).parse(date));
		} 
		catch (ParseException conversionFechaExcepcion) 
		{
			conversionFechaExcepcion.printStackTrace();
		}
		return transformedDate;
	}
		
	
	/**
	 * Método que recibe el tiempo de ejecución en milisegundos y le da el formato X min, Y seg, Z mseg.
	 * @param executionTime tiempo en milisegundos.
	 * @return tiempoFormateadoEjecucion
	 */
	public static String executionTimeFormat(long executionTime)
	{
		String milliseconds = String.valueOf(executionTime % 1000);
		executionTime /= 1000;
		String seconds = (executionTime % 60) > 0? String.valueOf(executionTime % 60): String.valueOf(executionTime);
		executionTime /= 60;
		String minutes = (executionTime % 60 > 0)? String.valueOf(executionTime): "";
		return minutes + (minutes.isEmpty()? "": " min. ") + seconds + " seg. " + milliseconds + " mseg.";
	}
	

	
	 public static double roundDecimals(double initialValue, int numberOfDecimals)
	 {         
		 double result = initialValue;
		 double integerPart = Math.floor(result);
		 result = (result - integerPart) * Math.pow(10, numberOfDecimals);
		 result = Math.round(result);
		 result = (result / Math.pow(10, numberOfDecimals)) + integerPart;
		 return result;
	}
	 
	public static String removeLineBreak(String string)
	{
		return ((string.replace('\n', ' ')).replace('\r', ' ')).replaceAll("  ", " ").trim();
	}
	
	public static void processException(Exception exception)
	{
		StringWriter exceptionString = new StringWriter();
		PrintWriter  redirectException = new PrintWriter(exceptionString);
	    exception.printStackTrace(redirectException);
	    //CommonComponent.registrarEnLog("EXCEPCIÓN NO CONTROLADA: ".concat(cadenaExcepcion.toString()));
	}
	
	public static String removePageFooterHeader(String text)
	{
		String firstPart;
		String secondPart;
		
		if(text.contains("Página"))
		{
			firstPart = text.substring(0,text.indexOf("Página"));
			secondPart = text.substring(text.lastIndexOf(":") + 3);
			text = firstPart.concat(secondPart);
		}
		return text;
	}
	
	public static StringBuilder getHashtableInTableFormat(String NOMBRES_COLUMNAS[], Hashtable<String, ArrayList<String>> tablaHash)
	{
		int spaces [] = null;
		StringBuilder table = null;
		
		spaces = new int[NOMBRES_COLUMNAS.length];		
		table    = new StringBuilder();		
		
		table.append(setSpaces(10));
		for(int i = 0; i <  tablaHash.size(); i++)
		{
			spaces[i] = getMaxListSizeValue(NOMBRES_COLUMNAS[i], tablaHash.get(NOMBRES_COLUMNAS[i]));
			table.append(NOMBRES_COLUMNAS[i].concat(setSpaces(spaces[i] - NOMBRES_COLUMNAS[i].length() + 5)));
		}
		table.append("\n");
		
		for(int j = 0; j < tablaHash.get(NOMBRES_COLUMNAS[0]).size(); j ++)
		{
			table.append(setSpaces(10));
			for(int i = 0; i <  tablaHash.size(); i++)
			{	
				table.append(tablaHash.get(NOMBRES_COLUMNAS[i]).get(j).concat(setSpaces(spaces[i] - tablaHash.get(NOMBRES_COLUMNAS[i]).get(j).length() + 5)));
			}
			table.append("\n");
		}
		
		return table;
	}
	
	private static int getMaxListSizeValue(String listName, ArrayList<String> list)
	{
		int maxSizeValue = 0;
		
		maxSizeValue = listName.length();
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).length() > maxSizeValue)
			{
				maxSizeValue = list.get(i).length();
			}
		}		
		return maxSizeValue;
	}
	
	private static String setSpaces(int n)
	{
		String space = " ";
		return space.repeat(n);
	}
	
	public static Calendar dateFormat(String stringDate)
	{
		Calendar date = Calendar.getInstance();
		try 
		{
			date.setTime(new SimpleDateFormat(stringDate.contains("-")? "dd-MM-yy": "dd/MM/yy").parse(stringDate));
		} 
		catch (ParseException parseDateException)
		{
			throw new AssertionError("Formato de fecha incorrecto, favor verificar.");
		}
		return date;
	}
	
	/**
	 * Método liberarRecursos(): mata los procesos geckodriver y firefox.
	 */
	public static void freeUpResources()
	{
		try 
		{			
			Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		}
		catch (IOException noEncuentraProcesoGeckodriverExcepcion) { }
	}
	
	/**
	 * Función eliminarAcentos ( ): devuelve una cadena sin acentos.
	 * @param word palabra con acentos.
	 */
	public static String removeAccents(String word )
	{
		StringBuilder wordWithOutAccents = new StringBuilder ( );
		
		for ( int character_i = 0; character_i < word.length ( ); character_i ++ )
		{
			switch ( word.charAt ( character_i ) )
			{
				case 'Á': wordWithOutAccents.append ( 'A' ); break;
				case 'É': wordWithOutAccents.append ( 'E' ); break;
				case 'Í': wordWithOutAccents.append ( 'I' ); break;
				case 'Ó': wordWithOutAccents.append ( 'O' ); break;
				case 'Ú': wordWithOutAccents.append ( 'U' ); break;
				case 'á': wordWithOutAccents.append ( 'a' ); break;
				case 'é': wordWithOutAccents.append ( 'e' ); break;
				case 'í': wordWithOutAccents.append ( 'i' ); break;
				case 'ó': wordWithOutAccents.append ( 'o' ); break;
				case 'ú': wordWithOutAccents.append ( 'u' ); break;
				default : wordWithOutAccents.append ( word.charAt ( character_i ) );
			}		
		}
		
		return wordWithOutAccents.toString ( );
	}
	
	/**
	 * Función formatearNombreAtributo ( ): devuelve el nombre de un atributo sin espacios, reemplazando la ñ por ni y en formato
	 * Camel case.
	 * @param attributeName nombre de atributo sin formato.
	 */
	public static String attributeNameFormat(String attributeName )
	{
		StringTokenizer separator          = null;
		StringBuilder   attributeFormatted = new StringBuilder ( );
		
		if ( attributeName.contains ( "ñ" ) )
		{
			attributeName = attributeName.replaceAll ( "ñ", "ni" );
		}
		
		if ( attributeName.contains ( " " ) )
		{
			separator          = new StringTokenizer ( attributeName );
			attributeFormatted = attributeFormatted.append ( separator.nextToken ( ) );
			
			while ( separator.hasMoreTokens ( ) )
			{
				attributeFormatted.append ( getTitleFormatString( separator.nextToken ( ) ) );
			}
		}
		else
		{
			attributeFormatted.append ( attributeName );
		}
		
		return attributeFormatted.toString ( );
	}
	
	/**
	 * Función isNumber ( ): valida si una cadena es un número o no.
	 * @param string cadena a verificar.
	 */
	public static boolean isNumber(String string )
	{
		try
		{
			Double.parseDouble ( string );
			return true;
		}
		catch ( NumberFormatException noEsNumeroExcepcion )
		{
			return false;
		}
	}
	
	/**
	 * Función extractNumbers ( ): dada una cadena, devuelve en una lista de todos los números que contiene.
	 * @param string cadena con números.
	 */
	public static ArrayList < Integer > extractNumbers(String string )
	{
		String                newNumber      = "";
		ArrayList < Integer > numbersList     = new ArrayList < Integer > ( );
		
		for ( int character_i = 0; character_i < string.length ( ); character_i ++)
		{
			if ( string.charAt ( character_i ) >= 48 && string.charAt ( character_i ) <=57 )
			{
				newNumber = newNumber.concat ( String.valueOf ( string.charAt ( character_i ) ) );
			}
			else
			{
				if ( !newNumber.isEmpty ( ) )
				{
					numbersList.add ( Integer.parseInt ( newNumber ) );
					newNumber = "";
				}
			}
			
		}
		
		return numbersList;
	}

	public static String getCurrentDateTime()
	{
		return new SimpleDateFormat(Constants.DATE_TIME_MASK).format(Calendar.getInstance().getTime());
	}

	public static String giveDateFormat(String dateWithOutFormat)
	{
		final String ORIGIN_DATE_MASK = "yyyy-MM-dd";

		String dateWithFormat = "";

		DateFormat originFormat  = new SimpleDateFormat(ORIGIN_DATE_MASK);
		DateFormat finalFormat = new SimpleDateFormat(Constants.DATE_MASK);
		originFormat.setLenient(false);
		finalFormat.setLenient(false);
		try
		{
			dateWithFormat = finalFormat.format(originFormat.parse(dateWithOutFormat));
		}
		catch (ParseException parseException)
		{
			parseException.printStackTrace();
		}
		return dateWithFormat;
	}

	public void StartCommonLog()
	{
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, Constants.LOGS_DIRECTORY.concat(Constants.LOG_GECKODRIVER_FILE));
	}

	public String getEnvironment(String url){
		String a = ""+url.substring(5,8);
		return  a;
	}
}
