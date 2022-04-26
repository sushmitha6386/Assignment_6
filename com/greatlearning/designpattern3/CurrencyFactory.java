package com.greatlearning.designpattern3;

public class CurrencyFactory {
	public static CurrencyInterface getCurrencyByCountry(String cnty) throws Exception{
        
        if("GBP".equalsIgnoreCase(cnty)){
            return new GBPConverter();
        } else if("USD".equalsIgnoreCase(cnty)){
            return new USDConverter();
        }
        throw new Exception("Invalid CURRENCY...");
    }
     
     
    public static void main(String a[]){
        CurrencyInterface india;
        try {
            india = CurrencyFactory.getCurrencyByCountry("GBP");
            System.out.println("Indian currency of 500 GBP after conversion is : "+india.convertToINR());
            india = CurrencyFactory.getCurrencyByCountry("USD");
            System.out.println("Indian currency of 700 USD after conversion is : "+india.convertToINR());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
