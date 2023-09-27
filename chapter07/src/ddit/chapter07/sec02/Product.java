package ddit.chapter07.sec02;
//09.04
public class Product {
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price=price;
		bonusPoint=(int)(price*0.01);
	}
}
