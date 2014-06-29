package hei.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItemStream;

public class FileUpload {

	public static boolean processFile(FileItemStream item){
		try{

		File f= new File("C:"+File.separator+"Users"+File.separator+"Utilisateur"+File.separator+"git"+File.separator+"projetITI"+File.separator+"projetEtude"+File.separator+"src"+File.separator+"main"+File.separator+"webapp"+File.separator+"img"+File.separator+"logo");
		if(!f.exists())f.mkdir();
		File savedFile =new File(f.getAbsolutePath()+File.separator+item.getName());
		FileOutputStream fos=new FileOutputStream(savedFile);
		InputStream is=item.openStream();
		int x=0;
		byte[] b=new byte[1024];
		
		while((x=is.read(b))!=-1){
			fos.write(b,0,x);
		}
		fos.flush();
		fos.close();
		return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
