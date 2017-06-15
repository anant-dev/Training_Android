package test;

// function overriding
public class Bank {
int getRateOfInterest(){return 0;}  
}
  
class Sbi extends Bank{  
int getRateOfInterest(){return 10;}  
}  
  
class Icici extends Bank{  
int getRateOfInterest(){return 8;}  
}  
class Axis extends Bank{  
int getRateOfInterest(){return 11;}  
} 
class Hdfc extends Bank{  
int getRateOfInterest(){return 7;}  
} 