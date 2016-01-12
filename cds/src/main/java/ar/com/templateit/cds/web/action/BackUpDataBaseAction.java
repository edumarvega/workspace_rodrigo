package ar.com.templateit.cds.web.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import ar.com.templateit.cds.web.util.TemplateUtil;

import com.opensymphony.xwork2.ActionSupport;

public class BackUpDataBaseAction extends ActionSupport {

	private static final long serialVersionUID = 3962840782833360714L;
	
	private String mySqldumPath;
	private String comando;
	private String pathBackup;

	public String hacerBackUp() throws Exception {
		try {
			TemplateUtil tu = new TemplateUtil();
			
			String comando = this.getMySqldumPath()+this.getComando();
			
			//Process p = Runtime.getRuntime().exec("C:/Aplicaciones/mysqldump -u root -proot cds");
			
			Process p = Runtime.getRuntime().exec(comando);

			InputStream is = p.getInputStream();
			
			//FileOutputStream fos = new FileOutputStream("D:\\backup\\backup_pruebas.sql");
			String pathArchivo = this.getPathBackup()+tu.generarNombreArchivo();
			
			FileOutputStream fos = new FileOutputStream(pathArchivo);
			
			byte[] buffer = new byte[1000];

			int leido = is.read(buffer);
			while (leido > 0) {
				fos.write(buffer, 0, leido);
				leido = is.read(buffer);
			}

			fos.close();

			return "successBackUp";

		} catch (IOException e) {
			e.printStackTrace();

			return "errorBackUp";
		}

	}
	
	public void transfer(InputStream input, OutputStream output) throws Exception {
		  byte[] buf = new byte[1024];
		  int len;
		  while ((len = input.read(buf)) > 0) {
		    output.write(buf, 0, len);
		  }
		  input.close();
		  output.close();
		}

	public String getMySqldumPath() {
		return mySqldumPath;
	}

	public void setMySqldumPath(String mySqldumPath) {
		this.mySqldumPath = mySqldumPath;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public String getPathBackup() {
		return pathBackup;
	}

	public void setPathBackup(String pathBackup) {
		this.pathBackup = pathBackup;
	}

	
	
	
}
