
package com.numbertowords;

import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2017-10-05T17:10:52.525+02:00
 * Generated source version: 3.1.11
 * 
 */
public final class NumberConversionSoapType_NumberConversionSoap_Client
{

	private static final QName SERVICE_NAME =
		new QName( "http://www.dataaccess.com/webservicesserver/", "NumberConversion" );

	private NumberConversionSoapType_NumberConversionSoap_Client( )
	{}

	public static void main( String args[] ) throws java.lang.Exception
	{
		URL wsdlURL = NumberConversion.WSDL_LOCATION;
		//		if ( args.length > 0 && args[ 0 ] != null && !"".equals( args[ 0 ] ) )
		//		{
		//			File wsdlFile = new File( args[ 0 ] );
		//			try
		//			{
		//				if ( wsdlFile.exists( ) )
		//				{
		//					wsdlURL = wsdlFile.toURI( ).toURL( );
		//				}
		//				else
		//				{
		//					wsdlURL = new URL( args[ 0 ] );
		//				}
		//			}
		//			catch ( MalformedURLException e )
		//			{
		//				e.printStackTrace( );
		//			}
		//		}

		NumberConversion ss = new NumberConversion( wsdlURL, SERVICE_NAME );
		NumberConversionSoapType port = ss.getNumberConversionSoap( );

		{
			System.out.println( "Invoking numberToWords..." );
			java.math.BigInteger _numberToWords_ubiNum = new java.math.BigInteger( "100" );
			java.lang.String _numberToWords__return = port.numberToWords( _numberToWords_ubiNum );
			System.out.println( "numberToWords.result=" + _numberToWords__return );

		}
		{
			System.out.println( "Invoking numberToDollars..." );
			java.math.BigDecimal _numberToDollars_dNum = new java.math.BigDecimal( "12" );
			java.lang.String _numberToDollars__return = port.numberToDollars( _numberToDollars_dNum );
			System.out.println( "numberToDollars.result=" + _numberToDollars__return );

		}

		System.exit( 0 );
	}

}
