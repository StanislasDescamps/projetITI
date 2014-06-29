package hei.controllers;

import hei.model.FileUpload;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/test.jsp");
		view.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");		
		boolean isMultiPart= ServletFileUpload.isMultipartContent(request);
		if(isMultiPart){
			ServletFileUpload upload=new ServletFileUpload();
			try{
				FileItemIterator itr=upload.getItemIterator(request);
				while(itr.hasNext()){
					FileItemStream item=itr.next();
					if(item.isFormField()){
						String fieldName = item.getFieldName();
						InputStream is=item.openStream();
						byte[] b =new byte[is.available()];
						is.read(b);
						String value = new String(b);
						response.getWriter().println(fieldName+":"+value+"<br/>");
						
					}else{
						if (FileUpload.processFile(item)){
							response.getWriter().println("file uploaded successfully");
						}else response.getWriter().println("file uploading failed");
					}
				}
				
			}catch(FileUploadException fue){
				fue.printStackTrace();
			}
		}
	}
}
