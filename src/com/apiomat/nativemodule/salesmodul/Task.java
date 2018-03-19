package com.apiomat.nativemodule.salesmodul;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	@Override
    public String call() throws Exception {
//		while (!Thread.interrupted()) {
//			String apiKey = (String) SalesModul.APP_CONFIG_PROXY.getConfigValue(SalesModul.APIKEY, r.getApplicationName(), r.getSystem() );
//	    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	    	InputStream is = null;
//	    	byte[] byteChunk = new byte[4096];
//	    	
//	                	try {
//	            			URL url = new URL("https://maps.googleapis.com/maps/api/staticmap?center=51.34,12.37&zoom=14&size=400x400&key=");// + apiKey);	
//	            	    	  is = url.openStream ();
//	            	    	  int n;
//
//	            	    	  while ( (n = is.read(byteChunk)) > 0 ) {
//	            	    	    baos.write(byteChunk, 0, n);
//	            	    	  }
//	            	    	  objFromDB.postAreaPicture(baos.toByteArray(), "area", "png");
//	            	    	  objFromDB.save();
//	          
//	            	}
//	            	catch (Exception e) { 
//	            		try {
//	            		List<PlaceholderData> data = this.model.findByNames(PlaceholderData.class, "", r);
//	            		URL picFromPhD = null;
//	                	if(data != null)
//	                	{
//	                		picFromPhD = new URL(data.get(0).getMapImageURL());
//	                	} 
//						is = picFromPhD.openStream ();
//	        	    	  int n;
//
//	        	    	  while ( (n = is.read(byteChunk)) > 0 ) {
//	        	    	    baos.write(byteChunk, 0, n);
//	        	    	  }
//	        	    	  objFromDB.postAreaPicture(baos.toByteArray(), "area", "png");
//	        	    	  objFromDB.save();
//	            		  obj.throwException(e.getMessage());}
//	            		catch(Exception e1) {
//	            			 obj.throwException(e.getMessage());
//	            		}
//	            	}
//
//		}
        return "Ready!";
    }
}
