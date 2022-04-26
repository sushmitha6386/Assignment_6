package com.greatlearning.designpattern1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBCSingletonDemo {
	    static int count=1;
	    static int  choice;
	    
	    public static void main(String[] args) throws IOException {
	        
	        JDBCSingleton jdbc= JDBCSingleton.getinstance();   
	        
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   do{ 
	        System.out.println("DATABASE OPERATIONS");
	        System.out.println(" --------------------- ");
	        System.out.println(" 1. Insertion ");
	        System.out.println(" 2. View      ");
	        System.out.println(" 3. Delete    ");
	        System.out.println(" 4. Update    ");
	        System.out.println(" 5. Exit      ");
	        
	        System.out.print("\n");
	       
	        
	        System.out.print("Please enter the choice what you want to perform in the database: ");
	        
	        choice=Integer.parseInt(br.readLine());
	        
	        switch(choice)
	       { 
	           case 1:
	                    System.out.print("Enter the username you want to insert data into the database: ");
	                    String username=br.readLine();
	                    System.out.print("Enter the password you want to insert data into the database: ");
	                    String password=br.readLine();
	                    
	                    try {
	                            int i= jdbc.insert(username, password);
	                            if (i>0) {
	                            System.out.println((count++) + " Data has been inserted successfully");
	                            }else{
	                                System.out.println("Data has not been inserted ");    
	                            }
	                        
	                        } catch (Exception e) {
	                          System.out.println(e);
	                        }
	                   //End of case 1
	                   break;
	            case 2:
	                    System.out.print("Enter the username you want to view the entire data from the database: ");
	                    String username1=br.readLine();
	             
	                    try{
	                         jdbc.view(username1);
	                    }catch (Exception e) {
	                          System.out.println(e);
	                    }
	                  //End of case 2
	                  break;
	             case 3:
	                     System.out.print("Enter the userid for which you want to delete the entire data from the database: ");
	                     String username3=br.readLine();
	           
	                     try {
	                            int i= jdbc.delete(username3);
	                            if (i>0) {
	                            System.out.println((count++) + " Data has been deleted successfully");
	                            }else{
	                                System.out.println("Data has not been deleted");    
	                            }
	                        
	                         } catch (Exception e) {
	                          System.out.println(e);
	                         }
	                   //End of case 3
	                   break;
	        
	             case 4:
	                    System.out.print("Enter the username for which  you want to update the data into the database: ");
	                    String username2=br.readLine();
	                    System.out.print("Enter the new password ");
	                    String password2=br.readLine();
	                    
	                    
	                    try {
	                            int i= jdbc.update(username2, password2);
	                            if (i>0) {
	                            System.out.println((count++) + " Data has been updated successfully");
	                            }
	                        
	                        } catch (Exception e) {
	                          System.out.println(e);
	                        }
	                     // end of case 4
	                     break;
	             case 5: break;
	             default:
	            	 		System.out.println("Incorrect Option. Try Again.");
	            	 		break;
	        }
	        
	       } while (choice!=5); 
	  }
	}
