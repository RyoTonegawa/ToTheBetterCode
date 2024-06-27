package com.example.demo.Chapter6.AntiPattern.Bad;

public class RegularRates implements IHotelRates{
    public Money fee(){
        return new Money(7000);
    }
    
}