package com.tasasjusticia;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyViewClient extends WebViewClient {
	
	
	private Context context;
	 
	public MyViewClient(Context context) {
	this.context = context;
	}
	
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
    	
    	if(url.contains("compartirTasas"))
    	{
    		
    		String[] split = url.split("mio");
    		String resultado = split[1];
    		
    		Intent intent = new Intent(android.content.Intent.ACTION_SEND);
    		intent.setType("text/plain");
    		intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Calculadora de Tasas Judiciales");//se usará por ejemplo para email
    		intent.putExtra(Intent.EXTRA_TEXT, "El resultado del cálculo de la tasa judicial es: "+resultado+" euros, descarga la aplicación: https://play.google.com/store/apps/details?id=com.tasasjusticia");
    		context.startActivity(Intent.createChooser(intent, "Compartir aplicacion usando"));
    	}
    	else
    	{
    		view.loadUrl(url);
    	}
        
        return true;
    }
    
    
}