
public class Fraction {
	public int nume,deno;//nume is numerator,deno is denominator
	public Fraction(){
		//noting
	}
	public Fraction(int nume){
		this.nume=nume;
		this.deno=1;
	}
	public Fraction(int nume,int deno){
		this.nume=nume;
		this.deno=deno;
		simplify();
	}
	public Fraction(Fraction a){
		this.nume=a.nume;
		this.deno=a.deno;
	}
	public void simplify(){
		int denom=deno,numer=nume;
		for(int remain=denom%numer;remain!=0;){
			remain=denom%numer;
			denom=numer;
			numer=remain;
		}
		deno/=denom;
		nume/=denom;
	}
	public double toDecimal(){
		double numer=nume;
		double denom=deno;
		return numer/denom;
	}
	public void toFraction(double a){
		String b=String.valueOf(a);
		char[] c=b.toCharArray();
		int l=0;
		for(int i=0;i<c.length;i++){
			if(c[i]=='.'){
				l=c.length-1-i;
			}
		}
		l=(int)Math.pow(10, l);
		nume=(int)a*l;
		deno=l;
		simplify();
	}
	public void add(int a,int b){
		nume=nume*b+deno*a;
		deno*=b;
		simplify();
	}
	public void add(Fraction f){
		this.nume=this.nume*f.deno+this.deno*f.nume;
		this.deno*=f.deno;
		simplify();
	}
	public void minus(int a,int b){
		nume=nume*b-deno*a;
		deno*=b;
		simplify();
	}
	public void minus(Fraction f){
		this.nume=nume*f.deno-this.deno*f.nume;
		this.deno*=f.deno;
		simplify();
	}
	public void multiply(int a,int b){
		nume*=a;
		deno*=b;
		simplify();
	}
	public void multiply(Fraction f){
		this.nume*=f.nume;
		this.deno*=f.deno;
		simplify();
	}
	public void divide(int a,int b){
		nume*=b;
		deno*=a;
		simplify();
	}
	public void divide(Fraction f){
		this.nume*=f.deno;
		this.deno*=f.nume;
		simplify();
	}
}
