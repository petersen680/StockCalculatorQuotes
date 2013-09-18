package net.dmpetersen.androiddevelopment.StockCalculatorQuotes;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import android.app.Dialog;



public class StockCalculatorActivity extends Activity {

	
	 private String message;
	 private Double price2;
	 private Double limitTarget2;
	 private Double stopAmount2;
	 private Double stopTarget2;
	 private Double commission2;
	 private String check;
	
	 
	

	 EditText price;
     EditText stopAmount;
     EditText stopTarget;
     EditText limitTarget;
     EditText commission;
    
	 Dialog dialog;
     
     
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
     
        
        
        
        price = (EditText) findViewById(R.id.price);
        stopAmount = (EditText) findViewById(R.id.stopamount);
        stopTarget = (EditText) findViewById(R.id.stoptarget);
        limitTarget = (EditText) findViewById(R.id.limittarget);
        commission = (EditText) findViewById(R.id.commission);
        
      
        
       
        Button Calculate = (Button) findViewById(R.id.btn_calculate);
        

        Calculate.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0){
    	
/*
        	price = (EditText) findViewById(R.id.price);
            stopAmount = (EditText) findViewById(R.id.stopamount);
            stopTarget = (EditText) findViewById(R.id.stoptarget);
            limitTarget = (EditText) findViewById(R.id.limittarget);
            commission = (EditText) findViewById(R.id.commission);
   
 */
        		
        		
    	    
    	    
        		
        		check = stopAmount.getText().toString();  if(check.equals("")) 
    	        {    stopAmount2 = new Double(0.0);  } 
    	        else {stopAmount2 = new Double(Double.parseDouble(stopAmount.getText().toString())); }
        		
        		
        		check = price.getText().toString();  if(check.equals("")) 
	        {    price2 = new Double(0.0); } 
	        else {  price2 = new Double(Double.parseDouble(price.getText().toString()));  } 
        		
        		
        		check = stopTarget.getText().toString();  if(check.equals("")) 
    	        {    stopTarget2 = new Double(0.0);  } 
    	        else {stopTarget2 = new Double(Double.parseDouble(stopTarget.getText().toString()));  }
        	    
    	    
  
    	    check = limitTarget.getText().toString();  if(check.equals("")) 
	        {    limitTarget2 = new Double(0.0);  } 
	        else {limitTarget2 = new Double(Double.parseDouble(limitTarget.getText().toString()));   }
    	    
    	   
    	    
    	    check = commission.getText().toString();  if(check.equals("")) 
	        {    commission2 = new Double(0.0);  } 
	        else {commission2 = new Double(Double.parseDouble(commission.getText().toString()));  }
    	    
    	 
    	    
   
    
    	    
    	    if(price2.doubleValue() == 0 || limitTarget2.doubleValue() == 0 
    	    		|| stopAmount2.doubleValue() == 0 || stopTarget2.doubleValue() == 0 || commission2.doubleValue() == 0){
    	    
    	    	
    	    	message = getString(R.string.message1);
    	    
    	    	Intent i = new Intent("net.dmpetersen.androiddevelopment.StockCalculatorQuotes.SCERRORACTIVITYQUOTES");            
          	     Bundle extras = new Bundle();
          	     extras.putString("message", message);
          	     i.putExtras(extras);
          	     startActivity(i);
    	    
    	    }
    	    
    	    else if(stopAmount2.doubleValue() < ((price2.doubleValue() - stopTarget2.doubleValue()) + (2 * commission2.doubleValue()))){
    	    			
    	    	message = getString(R.string.message2);
    	    
    	    	Intent i = new Intent("net.dmpetersen.androiddevelopment.StockCalculatorQuotes.SCERRORACTIVITYQUOTES");            
          	     Bundle extras = new Bundle();
          	     extras.putString("message", message);
          	     i.putExtras(extras);
          	     startActivity(i);

    	    	
    	    }
    	    
    	    else if(stopTarget2.doubleValue() >= price2.doubleValue()){
    	    	
    	    	message = getString(R.string.message3);
    	    
    	    	Intent i = new Intent("net.dmpetersen.androiddevelopment.StockCalculatorQuotes.SCERRORACTIVITYQUOTES");            
          	     Bundle extras = new Bundle();
          	     extras.putString("message", message);
          	     i.putExtras(extras);
          	     startActivity(i);
    	    	
    	    }
    	    
    	    else if(limitTarget2.doubleValue() <= price2.doubleValue()){
    	    	
    	    	
    	    	message = getString(R.string.message4);
    	    
    	    	 Intent i = new Intent("net.dmpetersen.androiddevelopment.StockCalculatorQuotes.SCERRORACTIVITYQUOTES");            
           	     Bundle extras = new Bundle();
           	     extras.putString("message", message);
           	     i.putExtras(extras);
           	     startActivity(i);
    	   
    	    }
    	    
    	    else{
    	    	
    	    	calculate();
    	    	
    	    	
    	    }
   
    	    
        }
        	

        });
        
        	
    }
    
        	

 
        	
    @Override    	
    public boolean onCreateOptionsMenu(Menu menu) {   
    MenuInflater inflater = getMenuInflater();    
    inflater.inflate(R.menu.menu, menu);    
    return true;
    }
        	
    
    
    
    @Override
    
    public boolean onOptionsItemSelected(MenuItem item) {    
    	// Handle item selection 
    	switch (item.getItemId()) {  
    	case R.id.clearall:
    		clear();            
    		return true;        
    	case R.id.helpmenu:            
    		showHelp();            
    		return true;
    	default:            
    		return super.onOptionsItemSelected(item);    
    		}
        }
    
    
    
    
    
private void showHelp(){
	
	
	
	
	
	  dialog = new Dialog(this);


      dialog.setContentView(R.layout.helpdialog);

      dialog.setTitle(getString(R.string.helptitle));

      dialog.setCancelable(true);
      
      //there are a lot of settings, for dialog, check them all out!

      //set up text

      TextView text = (TextView) dialog.findViewById(R.id.helpview);

      text.setText(R.string.helpmessage); 


      //set up image view

      //ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);

      //img.setImageResource(R.drawable.nista_logo);


      //set up button

      Button button = (Button) dialog.findViewById(R.id.btn_dialog);

      button.setOnClickListener(new OnClickListener() {

     

          public void onClick(View v) {

              dialog.dismiss();

          }


      
      });
      //now that the dialog is set up, it's time to show it    

      dialog.show();

  }





              
          
                


    private void clear(){
    
    	stopAmount.setText("");
    	price.setText("");
    	stopTarget.setText("");
        limitTarget.setText("");
        commission.setText("");
        stopAmount.requestFocus();
        

      }
    
    
  
        	
    
    
    
    
    private void calculate(){
        		
        		
       int numberOfShares = 0;	     
       Double total = new Double(0);	     
       double temp2 = 0;	     
       double temp3 = 0;
       double atRisk = 0;
       double r_T_Commission = commission2.doubleValue() + commission2.doubleValue();
       	     
       	     while(temp3 < stopAmount2.doubleValue() - r_T_Commission){
       	    	 numberOfShares++;
       	        total = price2.doubleValue() * numberOfShares;  
       	        temp2 = stopTarget2.doubleValue() * numberOfShares; 
       	        atRisk = temp3 + (price2.doubleValue() - stopTarget2.doubleValue()) + r_T_Commission;
       	        temp3 = total - temp2;   
       	  
       	      }
       	     
       	     
       	     
       	     
       	     
       	     
       	     total = total + r_T_Commission;
       	     
       	     Double limit = new Double(limitTarget2.doubleValue());
       	     
       	     Double profitIf = new Double((limit.doubleValue() * numberOfShares) - 
       	     (price2.doubleValue() * numberOfShares) - r_T_Commission);
       	     
       	     NumberFormat currency = NumberFormat.getCurrencyInstance(); 
       	     
       	  
       	     String SAstring = new String(currency.format(atRisk));
       	     String BPstring = new String(currency.format(price2.doubleValue()));
       	     String STstring = new String(currency.format(stopTarget2.doubleValue()));
       	     String LTstring = new String(currency.format(limitTarget2.doubleValue()));
       	     String RTstring = new String(currency.format(r_T_Commission));
       	     String Tstring = new String(currency.format(total.doubleValue()));
       	     String Pstring = new String(currency.format(profitIf.doubleValue()));
       	
       	  

       	     String string = new String( getString(R.string.risk) + " " + SAstring.toString() + '\n' + getString(R.string.buyprice) + " " + BPstring.toString() + '\n' + getString(R.string.stopat) + " " + STstring.toString()
       	     +  '\n' + getString(R.string.limitat) + " " + LTstring.toString() + '\n' + getString(R.string.rtcommision) + " " + RTstring.toString());
       	     
       	     Intent i = new Intent("net.dmpetersen.androiddevelopment.StockCalculatorQuotes.SCRESULTACTIVITYQUOTES");            
       	     
       	     Bundle extras = new Bundle();
       	     extras.putString("string", string);
       	     extras.putInt("numberofshares", numberOfShares);
       	     extras.putString("total", Tstring.toString());
       	     extras.putString("profit",Pstring.toString());
       	     i.putExtras(extras);
       	     startActivity(i);
       	    
       	 }
       	
          
       
    
    
  
    
    

    
/*
	public void onStart() {
	super.onStart();
	   
	}
	
	
	
	public void onRestart() {
	super.onRestart();
	   
	}
	
	
	public void onResume() {
	super.onResume();
	
	   
	}
	
	
	public void onPause() {
	super.onPause();
	
	
	
	}
	
	
	public void onStop() {
	super.onStop();
	   
	}
	
	
	public void onDestroy() {
	super.onDestroy();
	   
	}

*/
    

}

        
        
        
        
        