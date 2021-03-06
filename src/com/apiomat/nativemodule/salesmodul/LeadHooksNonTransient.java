/*
 * Copyright (c) 2011 - 2018, Apinauten GmbH
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.apiomat.nativemodule.salesmodul;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import com.apiomat.nativemodule.*;
import com.apiomat.nativemodule.basics.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.gson.example.Example;
import com.gson.example.Station;
import com.numbertowords.NumberConversion;
import com.numbertowords.NumberConversionSoapType;
import com.numbertowords.NumberConversionSoapType_NumberConversionSoap12_Client;
import com.numbertowords.NumberConversionSoapType_NumberConversionSoap_Client;
import com.numbertowords.NumberToWords;
import com.numbertowords.NumberToWordsResponse;
import com.numbertowords.ObjectFactory;

import sun.net.www.http.HttpClient;




/**
* Generated class for hooks on your Lead data model
*/

public class LeadHooksNonTransient<T extends com.apiomat.nativemodule.salesmodul.Lead> implements com.apiomat.nativemodule.IModelHooksNonTransient<com.apiomat.nativemodule.salesmodul.Lead>
{
    protected com.apiomat.nativemodule.salesmodul.Lead model;

    @Override
    public void setCallingModel( com.apiomat.nativemodule.salesmodul.Lead model )
    {
        this.model = model;
    }


    /*
     * Following Methods can be used if your data model is NOT set to TRANSIENT
     */

	@Override
    public void beforePost( com.apiomat.nativemodule.salesmodul.Lead obj, com.apiomat.nativemodule.Request r )
    {
		obj.setLastVisit(new Date());
    	String defaultScore = (String) SalesModul.APP_CONFIG_PROXY.getConfigValue( SalesModul.DEFAULTSCORE, r.getApplicationName(), r.getSystem() );
    	obj.setScore(Long.valueOf(defaultScore));
    	
    }

    @Override
    public boolean beforePostData( final com.apiomat.nativemodule.salesmodul.Lead obj, final String attributeName, final com.apiomat.nativemodule.DataWrapper dataWrapper, final com.apiomat.nativemodule.Request r )
    {
        return false;
    }

    @Override
    public boolean beforeDeleteData( final com.apiomat.nativemodule.salesmodul.Lead obj, final String attributeName, final com.apiomat.nativemodule.DataWrapper dataWrapper, final com.apiomat.nativemodule.Request r )
    {
        return false;
    }

    @Override
    public void afterPost( com.apiomat.nativemodule.salesmodul.Lead obj, com.apiomat.nativemodule.Request r )
    {
    	IModel<?>[] models;
    	models = SalesModul.AOM.findByNames( r.getApplicationName(), Salesman.MODULE_NAME, Salesman.MODEL_NAME, "userName == \""+r.getUserEmail()+"\"", r );
    	//sch�ner: List<Salesman> foundSalesman = this.model.findByNames(Salesman.class, String.format("userName == \"%s\"", r.getUserEmail()), r);
    	if(models != null && models.length > 0)
    	{
    		com.apiomat.nativemodule.salesmodul.Salesman salesman = (Salesman) models[0];
    		salesman.postListOfLeads(obj);
    	}
    
    	obj.log("a new lead was created1");
    	this.model.log("a new lead was created");

//    	com.apiomat.nativemodule.salesmodul.ContactProtocol protocol = this.model.createObject(ContactProtocol.class, r);
//    	List<TFami> listTF = this.model.findByNames(TFami.class, "limit 1", r);
//    	if(null != listTF && listTF.size() > 0)
//    	{
//    		protocol.setNotes(listTF.get(0).getHvOid().toString());
//    		protocol.save();
//    		obj.postContactAttempts(protocol);
//    		obj.save();
//    	}
    	
    	
    		
    }

    @Override
    public void afterPostData( final com.apiomat.nativemodule.salesmodul.Lead obj, final String attributeName, final com.apiomat.nativemodule.DataWrapper dataWrapper, final com.apiomat.nativemodule.Request r )
    {
    }

    @Override
    public void afterDeleteData( final com.apiomat.nativemodule.salesmodul.Lead obj, final String attributeName, final com.apiomat.nativemodule.DataWrapper dataWrapper, final com.apiomat.nativemodule.Request r )
    {
    }

    @Override
    public void beforeGet( String id, com.apiomat.nativemodule.Request r )
    {
    }

    @Override
    public String beforeGetData( final String dataId, final String attributeName, final com.apiomat.nativemodule.TranscodingConfiguration transcodingConfig, final com.apiomat.nativemodule.Request r )
    {
        return null;
    }
    
    @Override
    public void afterGet( com.apiomat.nativemodule.salesmodul.Lead obj, com.apiomat.nativemodule.Request r )
    {
    }

    @Override
    public void afterGetData( final String dataId, final String attributeName, final com.apiomat.nativemodule.DataWrapper dataWrapper, final com.apiomat.nativemodule.TranscodingConfiguration transcodingConfig, final com.apiomat.nativemodule.Request r )
    {
    }
    
    @Override
    public boolean beforePut( com.apiomat.nativemodule.salesmodul.Lead objFromDB, com.apiomat.nativemodule.salesmodul.Lead obj, com.apiomat.nativemodule.Request r )
    {
    	com.apiomat.nativemodule.salesmodul.Task task = new com.apiomat.nativemodule.salesmodul.Task();
    	ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(task);

        try {
            System.out.println("Started..");
            System.out.println(future.get(10, TimeUnit.SECONDS));
            System.out.println("Finished!");
        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            future.cancel(true);
            System.out.println("Terminated!");
        }
        executor.shutdownNow();
    	

    	String apiKeyR = (String) SalesModul.APP_CONFIG_PROXY.getConfigValue(SalesModul.APIKEYREST, r.getApplicationName(), r.getSystem() );
    	URL url;
        BufferedReader br;
        Example jsonobj = null;
		try {
			url = new URL("https://creativecommons.tankerkoenig.de/json/list.php?lat=51.34&lng=12.37&rad=4&sort=price&type=e5&apikey=" + apiKeyR);
			br = new BufferedReader (new InputStreamReader(url.openStream()));
			jsonobj = (com.gson.example.Example) new Gson().fromJson(br, com.gson.example.Example.class);
		} 
		catch (Exception e) {
			
		}
		System.out.println(jsonobj);
		List<Station> stations = jsonobj.getStations();
		for(int i = 0; i < stations.size(); i++)
		{
			System.out.println(stations.get(i).getPrice());
		}
			
		double sum = 0.0;
		for(int i = 0; i < stations.size(); i++) {
			sum += stations.get(i).getPrice();
		}
		double avgPrice = sum/stations.size();
		objFromDB.setAverageAreaGasPrice(avgPrice);
		objFromDB.save();

		if(objFromDB.getScore() != null)
		{
			BigInteger bi = BigInteger.valueOf(objFromDB.getScore().intValue());
			NumberConversion numCon = new NumberConversion();
			NumberConversionSoapType soap = numCon.getNumberConversionSoap();
			objFromDB.setScoreWritten(soap.numberToWords(bi));
			objFromDB.save();
		}
		
        
    	if (null != obj.getScore() && obj.getScore() != objFromDB.getScore())
    	{
    		obj.throwException("score modification not allowed");
    	}
        return false;
        
//        CloseableHttpClient client = HttpClients.createDefault();
//        String apiKey = r.getApiKey();
//        URL myURL = new URL("localhost:8000/yambas/rest/modules");
//        HttpPost httpPost = new HttpPost(myURL);
//     
//        JSONObject json;
//        String moduleName = "test1";
//        String customerName = r.getAccountName();
//        json.append("customerName", customerName);
//        json.append("moduleName", moduleName);
//
//        StringEntity entity = new StringEntity(json.toString());
//        httpPost.setEntity(entity);
//        httpPost.addHeader("Accept", "application/json");
//        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
//        httpPost.addHeader("X-apiomat-system", r.getSystem());
//        httpPost.addHeader("X-apiomat-sdkVersion", "2.6.3"); 
//        httpPost.addHeader("X-apiomat-apikey", r.getApiKey());
//        httpPost.addHeader("Authorization", "Basic bWFya3dhcmR0QGFwaW9tYXQuY29tOkZyM2U3VHYz");
//        
//        CloseableHttpResponse response = client.execute(httpPost);
//        //assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
//        System.out.println(response.getStatusLine().getStatusCode());
//        client.close();
    }
    @Override
    public void afterPut( com.apiomat.nativemodule.salesmodul.Lead obj, com.apiomat.nativemodule.Request r )
    {
    }

    @Override
    public boolean beforeDelete( com.apiomat.nativemodule.salesmodul.Lead obj, com.apiomat.nativemodule.Request r )
    {
        return false;
    }

    @Override
    public String beforeGetAll( String query, com.apiomat.nativemodule.Request r )
    {
        /* NOTE that returning null or "" would ignore any query and always return any object of this class and backend */
        return query;
    }

    @Override
    public java.util.List<com.apiomat.nativemodule.salesmodul.Lead> afterGetAll( java.util.List<com.apiomat.nativemodule.salesmodul.Lead> objects, String query, com.apiomat.nativemodule.Request r )
    {
        /*
         * If you want to change the returned list of elements, you have to create a new list
         * and add the elements to return to it. Because getting elements from the "objects"
         * list will return a copy, changing values in this list does not have any effect.
         *
         * If NULL is returned, unnecessary conversions are omitted and result is taken from database.
         */
        return null;
    }

    @Override
    public boolean beforePostRef( com.apiomat.nativemodule.salesmodul.Lead obj, Object referencedObject, String referenceName, com.apiomat.nativemodule.Request r )
    {
        return false;
    }

    @Override
    public void afterPostRef( com.apiomat.nativemodule.salesmodul.Lead obj, Object referencedObject, String referenceName, com.apiomat.nativemodule.Request r )
    {
    }

    @Override
    public boolean beforeDeleteRef( com.apiomat.nativemodule.salesmodul.Lead obj, Object referencedObject, String referenceName, com.apiomat.nativemodule.Request r )
    {
        return false;
    }

    @Override
    public void afterDeleteRef( com.apiomat.nativemodule.salesmodul.Lead obj, Object referencedObject, String referenceName, com.apiomat.nativemodule.Request r )
    {
    }

    @Override
    public String beforeGetAllReferences( String query, String referenceName, com.apiomat.nativemodule.Request r )
    {
        /* NOTE that returning null or "" would ignore any query and always return any referenced object */
        return query;
    }

    @Override
    public <Z extends com.apiomat.nativemodule.AbstractClientDataModel> java.util.List<Z> afterGetAllReferences( java.util.List<Z> objects, String query,
        String referenceName, com.apiomat.nativemodule.Request r )
    {
            return null; // return objects here if you changed sth; returning null prevents unnecessary conversions
    }
}
