import java.util.Scanner;

//	1.	��дһ��Application����MyDate.java�����������࣬�����û�������ꡢ�¡��գ������������������õ��µ����ڣ�������ǰ������õ��µ����ڣ����������ڼ���������ļ��㡣


public class MyDate {
	int year;
	int month;
	int day;
	Scanner scanner;
	public void readYear(){
		scanner = new Scanner(System.in);
		System.out.println("������ݣ�");
		this.year = scanner.nextInt();
	}
	
	public void readMonth(){
		scanner = new Scanner(System.in);
		System.out.println("�����·ݣ�");
		this.month = scanner.nextInt();
	}
	
	public void readDay(){
		scanner = new Scanner(System.in);
		System.out.println("�������ӣ�");
		this.day = scanner.nextInt();
	}
	
	void print(){
		System.out.println(
				"���������ǣ�\n" + this.year + "-"
				+ this.month + "-" + this.day);
	}
	
	void push(){
		scanner = new Scanner(System.in);
		System.out.println("��������(��)��");
		int pushDay = scanner.nextInt();
		
		while(pushDay > 365){
			if(isSingleYear(this.year)){
				if(this.month >= 3){
					pushDay -= 365;
					this.year ++;
				}
				else{
					pushDay -= 365;
					this.year ++;
					this.day --;
					
				}
			}
			else{
				if(isSingleYear(this.year+1)){
					if(this.month>=3){
						pushDay -= 365;
						this.year ++;
						this.day --;
					}
					else{
						pushDay -= 365;
						this.year++;
					}
				}
				else{
					pushDay -= 365;
					this.year ++;
				}
			}
		}
		//print();
		while(pushDay>0){
			pushDay = MonthPlus(pushDay);
		}
		print();
	}
	
	void pop(){
		scanner = new Scanner(System.in);
		System.out.println("���ڼ���(��)��");
		int pushDay = scanner.nextInt();
		
		while(pushDay > 365){
			if(isSingleYear(this.year)){
				if(this.month <= 2){
					pushDay -= 365;
					this.year --;
				}
				else{
					pushDay -= 365;
					this.year --;
					this.day ++;
					
				}
			}
			else{
				if(isSingleYear(this.year-1)){
					if(this.month<=2){
						pushDay -= 365;
						this.year --;
						this.day ++;
					}
					else{
						pushDay -= 365;
						this.year--;
					}
				}
				else{
					pushDay -= 365;
					this.year --;
				}
			}
		}
		//print();
		while(pushDay>0){
			pushDay = MonthMinus(pushDay);
		}
		print();
	}
	
	int MonthPlus(int date){
		//print();
		int monthLength = 0;
		switch(this.month){
		case 1:
			monthLength = 31;
			break;
		case 2:
			if(isSingleYear(this.year)){
				monthLength = 29;
			}
			else{
				monthLength = 28;
			}
			break;
		case 3:
			monthLength = 31;
			break;
		case 4:
			monthLength = 30;
			break;
		case 5:
			monthLength = 31;
			break;
		case 6:
			monthLength = 30;
			break;
		case 7:
			monthLength = 31;
			break;
		case 8:
			monthLength = 31;
			break;
		case 9:
			monthLength = 30;
			break;
		case 10:
			monthLength = 31;
			break;
		case 11:
			monthLength = 30;
			break;
		case 12:
			monthLength = 31;
			break;
		}
		if(date + this.day > monthLength){
			int temp = monthLength - this.day + 1;
			this.month ++;
			if(this.month >= 13){ 
				this.year ++;
				this.month = 1; 
			}
			date -= temp;
			this.day = 1;
		}	
		else{
			this.day += date;
			date = 0;
		}
		return date;
	}

	int MonthMinus(int date){
		//print();
		int monthLength = 0;
		int lastLength = 0;
		switch(this.month){
		case 1:
			monthLength = 31;
			lastLength = 31;
			break;
		case 2:
			if(isSingleYear(this.year)){
				monthLength = 29;
				lastLength = 31;
			}
			else{
				monthLength = 28;
				lastLength = 31;
			}
			break;
		case 3:
			monthLength = 31;
			if(isSingleYear(this.year)){
				lastLength = 29;
			}
			else{
				lastLength = 28;
			}
			break;
		case 4:
			monthLength = 30;
			lastLength = 31;
			break;
		case 5:
			monthLength = 31;
			lastLength = 30;
			break;
		case 6:
			monthLength = 30;
			lastLength = 31;
			break;
		case 7:
			monthLength = 31;
			lastLength = 30;
			break;
		case 8:
			monthLength = 31;
			lastLength = 31;
			break;
		case 9:
			monthLength = 30;
			lastLength = 31;
			break;
		case 10:
			monthLength = 31;
			lastLength = 30;
			break;
		case 11:
			monthLength = 30;
			lastLength = 31;
			break;
		case 12:
			monthLength = 31;
			lastLength = 30;
			break;
		}
		if(date >= this.day){
			this.month --;
			if(this.month <= 0){ 
				this.year --;
				this.month = 12; 
			}
			date -= this.day;
			this.day = lastLength;
		}	
		else{
			this.day -= date;
			date = 0;
		}
		return date;
	}
	
	boolean isSingleYear(int year){
		if((year%4==0 && year%100!=0)||(year%400==0)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyDate date;
	    date = new MyDate();
	    date.readYear();
	    date.readMonth();
	    date.readDay();
	    date.print();
	    Scanner sc = new Scanner(System.in);
	    boolean run = true;
	    while(run){
	    	System.out.println();
	    	System.out.println("1.��������");
	    	System.out.println("2.������ǰ��");
	    	System.out.println("3.�˳�");
	    	System.out.println();
	    	
	    	switch(sc.nextInt()){
	    	case 1:
	    		date.push();
	    		break;
	    	case 2:
	    		date.pop();
	    		break;
	    	case 3:
	    		run = false;
	    		break;
	    	}
	    }
	    
	}
}
